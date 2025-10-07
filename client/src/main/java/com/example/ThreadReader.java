package com.example;
import java.io.BufferedReader;
import java.io.IOException;

public class ThreadReader extends Thread {
    private BufferedReader in;
    private String messaggio;

    public ThreadReader(BufferedReader in){
        this.in = in;
    }

    @Override
    public void run() {
        try {
            do {
                messaggio = in.readLine();
                System.out.println(messaggio);
            } while (!messaggio.equals("end"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
