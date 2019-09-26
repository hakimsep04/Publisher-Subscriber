import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.*;

public class EventManager{

    List<Topic> topics;
    Map<InetAddress, Integer> ips;
    public EventManager(){
        topics = new ArrayList<Topic>();
        ips = new HashMap<InetAddress, Integer>();
    }
    /*
     * Start the repo service
     */
    private void startService() {

    }

    /*
     * notify all subscribers of new event
     */
    private void notifySubscribers(Event event) {

    }

    /*
     * add new topic when received advertisement of new topic
     */
    public boolean addTopic(Topic topic){

        Iterator<Topic> it = topics.iterator();
        while(it.hasNext()){
            if(it.next().name.equalsIgnoreCase(topic.name))
                return false;
        }
        topics.add(topic);
        return true;
    }

    /*
     * add subscriber to the internal list
     */
    private void addSubscriber(){

    }

    /*
     * remove subscriber from the list
     */
    private void removeSubscriber(){

    }

    /*
     * show the list of subscriber for a specified topic
     */
    private void showSubscribers(Topic topic){

    }

    public void displayTopics(){
        Iterator<Topic> it = topics.iterator();
        while(it.hasNext()){
            System.out.println(it.next().name);
        }
    }

    public static void main(String[] args) {
        new EventManager().startService();
    }

    public void addAddress(InetAddress ip, int port){
        ips.put(ip,port);
    }

    public void displayAddress(){
        Iterator it = ips.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + "  " + pair.getValue());
        }
    }

}
