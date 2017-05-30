package mx;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Monitor {
    private ArrayList<DomainStatus> domainStatusList;
    private long delayInMs;

    public Monitor(ArrayList<DomainStatus> domainStatusList, long delayInMs) {
        this.domainStatusList = domainStatusList;
        this.delayInMs = delayInMs;
    }

    public ArrayList<DomainStatus> getDomainListWithStatuses() throws HostException
    {
        try{
            checkDomainsStatuses();
        } catch (InterruptedException | IOException e){
            throw new HostException("Wystąpił błąd z pobraniem statusu dla domen");
        }
        return domainStatusList;
    }

    private void checkDomainsStatuses() throws InterruptedException, IOException {
        for (DomainStatus domainStatus : domainStatusList) {
            checkDomainStatus(domainStatus);
            Thread.sleep(delayInMs);
        }
    }

    private void checkDomainStatus(DomainStatus domainStatus) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(domainStatus.getUrl()).openConnection();
        connection.setInstanceFollowRedirects(true);
        domainStatus.setStatus(connection.getResponseCode());
        connection.disconnect();
    }
}
