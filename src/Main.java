import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice;
		while (true)
		{
			System.out.println("Enter 1 for Server and 2 for Client");
			try
			{
				choice  = Integer.parseInt(br.readLine());

			}
			catch (IOException e)
			{
				System.out.println("Error reading input");
				return;
			}
			catch (NumberFormatException e)
			{
				System.out.println("Invalid input");;
				continue;
			}
			if (choice == 1 || choice == 2)
				break;
			else
				System.out.println("Invalid input");
		}

		if (choice == 1)
		{
			Server server = new Server();
			server.start(br);
		}
		else
		{
			Client client = new Client();
			client.start(br);
		}

		try
		{
			br.close();
		}
		catch (IOException e)
		{
			try
			{
				e.printStackTrace(new PrintStream("logs.txt"));
			}
			catch (FileNotFoundException ex)
			{
				ex.printStackTrace(System.out);
			}
		}
	}
}