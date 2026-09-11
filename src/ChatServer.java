import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            try (Socket socket = serverSocket.accept()) {
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {

                    String clientMessage = input.readLine();
                    if (clientMessage != null) {
                        System.out.println("Received from client: " + clientMessage);
                    }

                    output.println("Connected to chat server");
                    System.out.println("Confirmation sent to client");
                }
            }
        }
    }
}
