
package example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class SocketClient {

    public static void main( String[] args ) throws IOException {
        // Check arguments
        if (args.length < 3) {
            System.err.println("Argument(s) missing!");
            System.err.printf("Usage: java %s host port file%n", SocketClient.class.getName());
            return;
        }

        String host = args[0];
        // Convert port from String to int
        int port = Integer.parseInt(args[1]);
        // Concatenate arguments using a string builder
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < args.length; i++) {

            sb.append(args[i]);
            if (i < args.length-1) {
                sb.append(" ");
            }
        }
        String text = sb.toString();

        // Create client socket
        Socket socket = new Socket(host, port);
        System.out.printf("Connected to server %s on port %d %n", host, port);

        // Create stream to send data to server
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        // Send text to server as bytes
        out.writeBytes(text);
        out.writeBytes("\n");
        System.out.println("Sent text: " + text);

        /* Codigo Extra Para Enviar e Receber Mensagem*/

        String cmd, line;

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintStream output = new PrintStream(socket.getOutputStream(),true);


            System.out.print(host+":"+port+"#>"); //linha de comandos

            while(true) {//inicio do ciclo
                System.out.println("xxxxxxxxxxxxxxxxxxxxxeeeee");
                Scanner scan = new Scanner (System.in);
                cmd = scan.nextLine();// ler comando a enviar
                output.println(cmd); //envia comando ao servidor

                if ( cmd.equalsIgnoreCase("stop")){
                    System.out.println("CONEC��O TERMINADA PELO CLIENTE");
                    break;//sair do ciclo.

                }
            }

            input.close();//termina input
            output.close();//termina output
            socket.close();// termina socket
        }

    }


