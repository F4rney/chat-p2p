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
private static void enviarMensagens(String 
endereco, int porta) {
    try (Socket socket = new Socket(enderec
porta);
         PrintWriter out = new PrintWriter
(socket.getOutputStream(), 
true);
         BufferedReader consoleInput = new 
BufferedReader(new InputStreamRead
(System.in))) {
        System.out.println("Conectado ao 
outro cliente. Digite suas 
mensagens:");
        System.out.println("Digite 'sair'
para encerrar a conversa.");
        String mensagem;
        while ((mensagem = consoleInput.
readLine()) != null && !mensagem.
equalsIgnoreCase
("sair")) {
            out.println(mensagem);
        }
        System.out.println("Conversa 
encerrada.");
    } catch (IOException e) {
        System.err.println("Erro ao enviar 
mensagens: " + e.getMessage());
    }
}
}
