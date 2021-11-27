package ch15.simple_chat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VerySimpleChatServer {

    List<PrintWriter> clientOutPutStream;

    public static void main(String[] args) {
        new VerySimpleChatServer().go();
    }

    public void go() {
        clientOutPutStream = new ArrayList<>();
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutPutStream.add(writer);
                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
                System.out.println("Связь установлена...");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket socket;

        public void tellEveryone (String message) {
            Iterator iterator = clientOutPutStream.iterator();
            while (iterator.hasNext()) {
                try {
                    PrintWriter writer = (PrintWriter) iterator.next();
                    writer.println(message);
                    writer.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public ClientHandler(Socket clientSocket) {
            try {
                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("read " + message);
                    tellEveryone(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
