package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(3000);

        Socket client = serverSocket.accept();
        System.out.println("User connesso");

        final BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        final PrintWriter out = new PrintWriter(client.getOutputStream(), true);

        out.println("Ti sei connesso! Sono Gigio e qualunque cosa tu scriva te la manderò indietro in maiuscolo");
        String messaggio;

        do {
            out.println("Inserisci la stringa");
            messaggio = in.readLine();
            out.println(messaggio.toUpperCase());
        } while (!messaggio.equals("end"));

        serverSocket.close();

    }
}