package org.server.MainServer;

import org.server.Config;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MainServer {
    ServerSocket serverSocket;
    Socket socket;
    List<Thread> list;

    public MainServer(){
        list = new ArrayList<>();
        System.out.println("Main Server Start.");
    }

    public void giveAndTake(){
        try{
            serverSocket = new ServerSocket(Config.TCP_CONNECTION_DEFAULT_PORT);
            serverSocket.setReuseAddress(true);

            while(true){
                socket = serverSocket.accept();
                System.out.println("New Socket accepted.");
                ServerSocketThread thread = new ServerSocketThread(this, socket);
                addClient(thread);
                thread.start();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public synchronized void addClient(ServerSocketThread thread){
        list.add(thread);
        System.out.println("Client: 1 user added. Total: " + list.size());
    }

    public synchronized void removeClient(Thread thread){
        list.remove(thread);
        System.out.println("Client: 1 user removed. Total: " + list.size());
    }

    public synchronized void broadCasting(String str){
        for(int i = 0; i < list.size(); ++i){
            ServerSocketThread thread = (ServerSocketThread) list.get(i);
            thread.sendMessage(str);
        }
    }
}
