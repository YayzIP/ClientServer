package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            out.println("Ti sei connesso! Sono Gigio e qualunque cosa tu scriva te la manderò indietro in maiuscolo");
            String messaggio;

            do {
                out.println("Inserisci la stringa:");
                messaggio = in.readLine();
                if (messaggio != null) {
                    out.println(messaggio.toUpperCase());
                }
            } while (messaggio != null && !messaggio.equalsIgnoreCase("end"));

            client.close();
            System.out.println("Connessione chiusa con " + client.getInetAddress());

        } catch (IOException e) {
            System.out.println("Errore con il client: " + e.getMessage());
        }
    }
}
