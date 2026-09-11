import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    public static final int PORT = 5000;
    public static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connecting to server at " + HOST + ":" + PORT);
            output.println("CLIENT_HELLO");

            String response = input.readLine();
            if (response != null) {
                System.out.println("Server response: " + response);
            }

            System.out.println("Press Enter to close the client...");
            consoleInput.readLine();
        }
    }
}
