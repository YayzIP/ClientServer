package com.example;

import java.io.PrintWriter;
import java.util.Scanner;

public class ThreadWriter extends Thread {
    private PrintWriter out;
    private Scanner scn = new Scanner(System.in);

    public ThreadWriter(PrintWriter out) {
        this.out = out;
    }

    @Override
    public void run() {
        String messaggio;
        do {
            messaggio = scn.nextLine();
            if (messaggio.equals("exit")) {
                out.println("!");
                break;
            }
            out.println(messaggio);
        } while (true);

        scn.close();
    }
}
