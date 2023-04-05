package org.example;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SOCKET SERV
 */

public class SocketServ {

    @SneakyThrows
    public static void main(String[] args) {
        while (true) {
            try (ServerSocket sC = new ServerSocket(5555)) {
                try (Socket client = sC.accept()) {
                    BufferedReader read = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    String line = read.readLine();
                    System.out.println(client.getInetAddress().getHostName() + " - " + line);
                } catch (Exception e) {
                    System.out.println("Oopps  client have problem ");
                }
            }
        }
    }
}

