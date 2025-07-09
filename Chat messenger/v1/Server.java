import java.net.*;
import java.io.*;

class Server
{
    public static void main(String arg[]) throws IOException
    {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Start the Server 

        // The server socket listens on port 1400 (port 1400 is like door , where client can connect)
        ServerSocket serverSocket = new ServerSocket(1432);

        System.out.println("Server is running...");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Accept Client Connections 

        // accept() will wait until a client connects
        // Once a client connects, it creates a new Socket (sobj) to communicate with client.
        Socket socket = serverSocket.accept();

        if(socket.isConnected())
        {
            System.out.println("Server is connected with client.");
        }
        else
        {
            System.out.println("Unable to connect with client !!");
        }

        System.out.println("*************************************************************************");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Read & Write Data 

        // type the msg to send client
        BufferedReader typeMsg = new BufferedReader(new InputStreamReader(System.in));

        // reads data coming from the client
        BufferedReader receivedMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // sends data back to the client
        PrintStream sendMsg = new PrintStream(socket.getOutputStream());

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// While loop: Keep reading and sending messages

        String sReadMsg = null , sWriteMsg = null ;

        while(true)
        {
            sReadMsg = receivedMsg.readLine();
            if(sReadMsg == null || sReadMsg.equalsIgnoreCase("exit")) break;

            System.out.println("Client : "+sReadMsg);

            System.out.print("\t\tYou : ");

            sWriteMsg = typeMsg.readLine();

            sendMsg.println(sWriteMsg);
        }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// close connections : Closes BufferedReader, PrintStream, and Socket to free resources.

        System.out.println("*************************************************************************");
        serverSocket.close();
        socket.close();
        typeMsg.close();
        sendMsg.close();
        receivedMsg.close();

        if(serverSocket.isClosed() == true)
        {
            System.out.println("Server is closed.");
        }
        else
        {
            System.out.println("Server is ON.");
        }

        System.out.println("Thankyou for using your application");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}