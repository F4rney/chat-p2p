package src;

import java.io.*;
import java.net.*;

public class ReceberMensagens implements Runnable {
    private int porta;

    public ReceberMensagens(int porta) {
        this.porta = porta;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(porta)) {
            System.out.println("Escutando mensagens na porta " + porta);

            while (true) {
                Socket socket = serverSocket.accept();

                try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String mensagem;
                    while ((mensagem = in.readLine()) != null) {
                        System.out.println("Mensagem recebida: " + mensagem);
                    }
                } catch (IOException e) {
                    System.err.println("Erro ao ler mensagem: " + e.getMessage());
                } finally {
                    socket.close(); // Fecha o socket do cliente após leitura
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao receber mensagens: " + e.getMessage());
        }
    }
}
