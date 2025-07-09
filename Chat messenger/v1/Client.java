import java.net.*;
import java.io.*;

class Client
{
    public static void main (String arg[])
    {
        try
        {
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Connect to the Server

            // Creates a stream socket and connects it to the specified port number on the named host.
            Socket clientSocket = new Socket("localhost",1432);

            System.out.println("Client is running..");

            if(clientSocket.isConnected())
            {
                System.out.println("Connected with server.");
            }
            else
            {
                System.out.println("Unable to connect with server !!");
            }
            System.out.println("*****************************************************");

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Read & Write Data 

            // typed message to send 
            BufferedReader writeMsg = new BufferedReader(new InputStreamReader(System.in));

            // send msg to server
            /*
                a PrintStream never throws an IOException
                a PrintStream can be created so as to flush automatically
            */
            PrintStream sendMsg = new PrintStream(clientSocket.getOutputStream());

            // receives msg responses from the server.
            BufferedReader receivedMsg = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// While loop: Keep reading and sending messages

            String sReadMsg = null , sWriteMsg = null ;

            while(true)
            {
                System.out.print("\t\tYou : ");
                sWriteMsg = writeMsg.readLine();    // Get user input
                sendMsg.println(sWriteMsg);          // send msg to server.println(String or data or chat)

                sReadMsg = receivedMsg.readLine();  // // Read response

                if((sReadMsg == null) || sReadMsg.equalsIgnoreCase("exit")) break;
                
                System.out.println("Server : "+sReadMsg);
            }   

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// close connections : Closes BufferedReader, PrintStream, and Socket to free resources.

            System.out.println("*************************************************************************");
            clientSocket.close();
            writeMsg.close();
            sendMsg.close();
            receivedMsg.close();

            if(clientSocket.isClosed() == true)
            {
                System.out.println("Client is closed.");
            }
            else
            {
                System.out.println("Client is ON.");
            }

            System.out.println("Thankyou for using your application");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
        catch(UnknownHostException e1)
        {
            System.out.println(e1);
        }
        catch(IOException e2)
        {
            System.out.println(e2);
        }
    }
}