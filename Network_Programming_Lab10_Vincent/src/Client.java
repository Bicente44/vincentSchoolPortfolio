/*
 * Student Name: Vincent Welbourne
 * Student Number: 041161454
 * Course: CST8108_030 Network Programming
 * Program: CET-CS-Level 2
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client class connects to the server on port 1254, reads text messages, and prints them.
 * The client terminates when it receives the "finish" message.
 * Implemented cross messenging client to server
 */
public class Client {
    public static final String SERVER_ADDRESS = "localhost"; // localhost or Friend's IPv4
    public static final int SERVER_PORT = 1254;

    
    public static void main(String[] args) {
        Socket clientSocket = null;
        DataInputStream dataIn = null;
    	String message1 = " ";
    	DataOutputStream dataOut;
        Scanner scanner = new Scanner(System.in);
        
        
        try {
            // Connect to the server.
            clientSocket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server at " + SERVER_ADDRESS + ":" + SERVER_PORT);
            
            // Create an input stream to read messages from the server.
            dataIn = new DataInputStream(clientSocket.getInputStream());
            dataOut = new DataOutputStream(clientSocket.getOutputStream());

            String messageFromServer;
            // Continuously read messages until "finish" is received.
            
			while (!message1.equals("finish")) {
				messageFromServer = dataIn.readUTF();
				System.out.println("Message from server: " + messageFromServer);
				System.out.print("Enter message to send to Server: ");
				message1 = scanner.nextLine();
                dataOut.writeUTF(message1);
                dataOut.flush(); 
            }
			scanner.close();
        } catch (IOException e) {
            System.err.println("Error in client: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Ensure input stream and socket are closed.
            if (dataIn != null) {
                try {
                    dataIn.close();
                } catch (IOException e) {
                    System.err.println("Error closing DataInputStream: " + e.getMessage());
                }
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }
    }
}
