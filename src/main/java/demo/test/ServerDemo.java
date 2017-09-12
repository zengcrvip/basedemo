package demo.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {

	public static void main(String[] args) throws IOException {
		Server server = new Server(8080);
		server.start();
	}
}

class Server extends Thread {
	private ServerSocket serverSocket = null;
	private int port;

	public Server(int port) throws IOException {
		this.port = port;
		serverSocket = new ServerSocket(port);
	}

	public void run() {
		while (true) {
			try {
				Socket client = serverSocket.accept();
				Worker worker = new Worker(client);
				worker.start();
			} catch (IOException e) {
				e.printStackTrace(System.out);
			}
		}
	}
}

class Worker extends Thread {
	Socket client = null;
	DataOutputStream out = null;
	DataInputStream in;

	public Worker(Socket client) throws IOException {
		super();
		this.client = client;
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		DataInputStream in = new DataInputStream(client.getInputStream());
	}

	public void run() {
		while (true) {
			try {
				String request = in.readUTF();
				if ("exit".equalsIgnoreCase(request)) {
					client.close();
					break;
				}
				String reply = "Reply: " + request;
				out.writeUTF(reply);
			} catch (IOException e) {
				e.printStackTrace(System.out);
			}
		}
	}
}
