package classes.GUI.app.chat.ex2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {

    private Socket socket;
    private ArrayList<ServerThread> threadList;
    private BufferedWriter out;

    public ServerThread(Socket socket, ArrayList<ServerThread> threadList) {
        this.socket = socket;
        this.threadList = threadList;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String inMsg = null;
            while (true) {
                inMsg = in.readLine();
                if (inMsg.equalsIgnoreCase("bye")) {
                    break;
                }
                sendAllClient(inMsg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendAllClient(String inMsg) {
        for (ServerThread st : threadList) {
            try {
                st.out.write(inMsg + "\n");
                st.out.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
