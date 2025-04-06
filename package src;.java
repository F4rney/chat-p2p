package src;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatP2P {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a porta para escutar mensagens: ");
        int portaReceber = scanner.nextInt();

        System.out.print("Digite o endereço do outro cliente: ");
        String enderecoOutroCliente = scanner.next();

        System.out.print("Digite a porta para enviar mensagens: ");
        int portaEnviar = scanner.nextInt();

        new Thread(new ReceberMensagens(portaReceber)).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.printIn("Erro ao esperar: " + e.getMessage());
        }

        enviarMensagens(enderecoOutroCliente, portaEnviar);
        scanner.close();
}
