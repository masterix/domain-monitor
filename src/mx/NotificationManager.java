package mx;

import java.util.ArrayList;

/**
 * Created by masterix on 28.05.2017.
 */
public class NotificationManager {

    private ArrayList<NotificationSender> senders;

    public NotificationManager(){
        senders = new ArrayList<>();
    }

    public void addSender(NotificationSender sender){
        senders.add(sender);
    }

    public void removeSender(NotificationSender sender){
        senders.remove(sender);
    }

}
