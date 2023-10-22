package org.next_step;

import java.net.ServerSocket;
import java.net.Socket;

//HTTP 웹 서버 구현
public class WebServer {
    public static void main(String[] args) throws Exception{
        try(ServerSocket listenSocket = new ServerSocket(8080)){
            System.out.println("WebServer Connected");

            Socket connection;
            while((connection = listenSocket.accept()) != null){
                RequestHandler requestHandler = new RequestHandler(connection);
                requestHandler.start();
            }
        }
    }
}
