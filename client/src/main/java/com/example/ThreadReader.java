package com.example;

import java.io.BufferedReader;
import java.io.IOException;

public class ThreadReader extends Thread {
    private BufferedReader in;

    public ThreadReader(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try {
            String messaggio;

            do {
                messaggio = in.readLine();
                if (messaggio != null) {
                    System.out.println(messaggio);
                }
            } while (!messaggio.equals("Thanks!"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
