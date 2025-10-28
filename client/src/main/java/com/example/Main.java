package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        String ip = "localhost";

        final Socket mySocket = new Socket(ip, 3000);
        System.out.println("connessione effettuata");
        final BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
        final PrintWriter out = new PrintWriter(mySocket.getOutputStream(), true);

        final ThreadReader tr = new ThreadReader(in);
        final ThreadWriter tw = new ThreadWriter(out);

        tr.start();
        tw.start();

        try {
            tr.join();
            tw.join();
        } catch (InterruptedException e) {
            System.out.println("connessione terminata");
            mySocket.close();
        }
    }
}