import java.net.*;  // import java network classes        // Allows us to work with network sockets
import java.io.*;   // import java input output classes   // help with reading , writing data

class Server_V1
{
    public static void main(String arg[])
    {
        try
        {
            System.out.println("Server started..");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Start the Server 

            ServerSocket ssobj = new ServerSocket(1400);        // The server socket listens on port 1400 (port 1400 is like door , where client can connect)

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Accept Client Connections 

            Socket sobj = ssobj.accept();                       // accept() will wait until a client connects
            // Once a client connects, it creates a new Socket (sobj) to communicate with client.

            System.out.println("Server connected to client");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Read & Write Data 

            BufferedReader bobj = new BufferedReader(new InputStreamReader(System.in));

            BufferedReader ReceivedMsg = new BufferedReader(new InputStreamReader(sobj.getInputStream()));     // reads data coming from the client

            PrintStream SendMsg = new PrintStream(sobj.getOutputStream());                                 // sends data back to the client

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// While loop: Keep reading and sending messages

            String ReadMsg = null ,typeMsg = null ;

            while((ReadMsg = ReceivedMsg.readLine()) != null)
            {
                System.out.println("Client says : "+ ReadMsg);

                System.out.println("Enter any msg for client : ");
                typeMsg = bobj.readLine(); 

                SendMsg.println(typeMsg);
            }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// close connections : Closes BufferedReader, PrintStream, and Socket to free resources.

            // sobj.close();
            // ReceivedMsg.close();
            // SendMsg.close();

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
        catch(IOException e1)
        {
            System.out.println(e1);
        }  
    }
}