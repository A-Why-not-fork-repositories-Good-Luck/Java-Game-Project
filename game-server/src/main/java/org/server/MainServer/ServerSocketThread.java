package org.server.MainServer;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSocketThread extends Thread{

    Socket socket;
    MainServer server;
    BufferedReader in;
    PrintWriter out;
    public ServerSocketThread(MainServer server, Socket socket){
        this.server = server ;
        this.socket = socket;
    }

    public void sendMessage(String str){
        out.println(str); 
    }

    @Override
    public void run(){

    }
}
