import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ConnManagerThread implements Runnable {
    private Socket clientSocket;
    private PrintWriter pw;
    private BufferedReader br;
    private Thread thrd ;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private EventManager evnt;
    public ConnManagerThread(Socket cs,EventManager ev ){
        try {
            thrd = new Thread(this);
            clientSocket = cs;
            evnt = ev;
            synchronized(evnt){
                evnt.addAddress(clientSocket.getInetAddress(), clientSocket.getLocalPort());
                evnt.displayAddress();
            }
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
            thrd.start();
        }
        catch(Exception e){

        }
    }
    public void run(){
        try {
            System.out.println((String)ois.readObject());
            while(true){
                switch((String)ois.readObject()){
                    case "Topic":
                        synchronized (evnt){
                            if(evnt.addTopic((Topic)ois.readObject())){
                                evnt.displayTopics();
                            }

                        }
                }

            }
        }
        catch(SocketException e){
            System.out.println("Disconnected");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
