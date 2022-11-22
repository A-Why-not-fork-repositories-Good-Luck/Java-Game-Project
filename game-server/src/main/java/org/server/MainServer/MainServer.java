package org.server.MainServer;

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

    public void start(){

    }

    public synchronized void addClient(){

    }

    public synchronized void removeClient(){

    }

    public synchronized void broadCasting(){

    }
}
