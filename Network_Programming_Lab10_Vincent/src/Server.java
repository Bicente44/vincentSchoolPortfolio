/*
 * Student Name: Vincent Welbourne
 * Student Number: 041161454
 * Course: CST8108_030 Network Programming
 * Program: CET-CS-Level 2
*/

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Server class listens on port 1254, accepts a client connection, and sends keyboard input messages to the client.
 * When the user types "finish", that message is sent and the connection is closed.
 * Implemented cross messenging Server to Client
 */
public class Server {
    public static final int PORT = 1254;
    
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Scanner scanner = new Scanner(System.in);
        DataInputStream dataIn;
        
        try {
            // Create a ServerSocket to listen on the specified port.
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);
            
            // The server runs indefinitely, accepting one client at a time.
            while (true) {
                System.out.println("Waiting for a client to connect...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getInetAddress().getHostAddress());
                
                // Create an output stream to send messages to the client.
                DataOutputStream dataOut = new DataOutputStream(clientSocket.getOutputStream());
                dataIn = new DataInputStream(clientSocket.getInputStream());
                
                String message;
                String messageFromClient;
                // Loop: read messages from the keyboard and send them to the client.
                do {
                    System.out.print("Enter message to send to client: ");
                    message = scanner.nextLine();
                    dataOut.writeUTF(message);
                    messageFromClient = dataIn.readUTF();
    				System.out.println("Message from server: " + messageFromClient);
                    dataOut.flush();
                } while (!message.equals("finish"));
                
                System.out.println("Finish message sent. Closing connection with client.");
                // Close the resources for this client.
                dataOut.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            System.err.println("Error in server: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Ensure the server socket and scanner are closed.
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    System.err.println("Error closing server socket: " + ex.getMessage());
                }
            }
            
            scanner.close();
        }
    }
}
