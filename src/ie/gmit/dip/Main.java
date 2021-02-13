package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int portNumber = portNumber();
        startClient(portNumber);
    }

    public static int portNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter port number of a server you are connecting to (5000 - 65,535 inclusive)");
        String portString = input.nextLine();
        int portNumber = 0 ;

        while(true){
            try{
                portNumber = Integer.parseInt(portString);
                if(portNumber >=5000 && portNumber <= 65535){
                    System.out.println("Connecting to the server with port number " + portNumber);
                    break;
                }else if(portNumber < 5000){
                    System.out.println("Please use port number higher than 5000");
                }else if (portNumber > 65535) {
                    System.out.println("Port number cannot be higher than 65535");
                }
                System.out.println("Enter port number of the server you are connecting to (5000 - 65,535 inclusive)");
                portString = input.nextLine();

            } catch (NumberFormatException e){
                System.out.println("Invalid port number");
                System.out.println("Try again");
                portString = input.nextLine();
            }
        }
        return portNumber;
    }

    public static void startClient(int port){
        try(Socket socket = new Socket("localhost", port)) {
            System.out.println("Connected");
            ServerConnection serverConnection = new ServerConnection(socket);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            new Thread(serverConnection).start();

            while (true){
                System.out.println("Enter string to be echoed: ");
                String message = input.readLine();
                Thread.sleep(1000);
                if(message.equals("\\q")){
                    output.println(message);
                    socket.close();
                    break;

                }else if (!message.equals("\\q")){
                    output.println(message);
                }
            }

        }catch (IOException | InterruptedException e){
            System.out.println("Client cannot be connected to this port. Please try another port.");
            int portnumber = portNumber();
            startClient(portnumber);
        }

    }
}
