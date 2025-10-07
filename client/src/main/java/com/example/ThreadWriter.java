package com.example;
import java.io.PrintWriter;
import java.util.Scanner;

public class ThreadWriter extends Thread {
    private PrintWriter out;
    private Scanner scn = new Scanner(System.in);        
    private String messaggio;

    public ThreadWriter(PrintWriter out){
        this.out = out;
    } 
    

    @Override
    public void run() {
        do {
            messaggio = scn.next();
            out.println(messaggio);
        } while (!messaggio.equals("end"));

        scn.close();
    }
}
