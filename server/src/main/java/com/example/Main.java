package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(3000)) {
            do {
                Socket client = serverSocket.accept();
                ClientHandler ClientHandler = new ClientHandler(client);
                ClientHandler.start();
            } while (true);
        }

    }
}