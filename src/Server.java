import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Server
{
	void start(BufferedReader br)
	{
		System.out.println("Enter time for which server should run in minutes: ");
		int time = 0;
		while (true)
		{
			try
			{
				time = Integer.parseInt(br.readLine());
				break;
			}
			catch (Exception e)
			{
				System.out.println("Invalid input");
			}
		}
		time = time * 60 * 1000;

		System.out.println("Enter port number: ");
		int port = 0;
		while (true)
		{
			try
			{
				port = Integer.parseInt(br.readLine());
				break;
			}
			catch (Exception e)
			{
				System.out.println("Invalid input");
			}
		}

		Socket socket = new Socket();
		try
		{
			socket.bind(new InetSocketAddress(port));
		}
		catch (IOException e)
		{
			System.out.println("Port already in use");
			this.start(br);
			System.exit(0);
		}
		System.out.println("Server started on port " + port);

		try
		{
			Thread.sleep(time);
		}
		catch (InterruptedException e)
		{
			System.out.println("Server interrupted");
		}

		try
		{
			socket.close();
		}
		catch (IOException e)
		{
			System.out.println("Error closing socket");
		}
	}
}
