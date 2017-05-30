package mx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextFileSource implements SourceInterface {

    protected ArrayList<DomainStatus> domainStatuses;

    protected String filename;

    public TextFileSource(String inputFilename) {
        domainStatuses = new ArrayList<>();
        filename = inputFilename;
    }

    @Override
    /**
     * @throws SourceNotFoundException
     */
    public ArrayList<DomainStatus> getDomainList() throws SourceNotFoundException {
        domainStatuses.clear();
        try{
            readDomainsFromFile();
        }
        catch(IOException ex){
            throw new SourceNotFoundException(ex.getMessage());
        }

        return domainStatuses;
    }

    private void readDomainsFromFile() throws IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String url;
        while ((url = br.readLine()) != null) {
            domainStatuses.add(new DomainStatus(url));
        }
        br.close();

    }
}
