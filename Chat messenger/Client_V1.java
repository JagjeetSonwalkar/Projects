import java.net.*;
import java.io.*;

class Client_V1
{
    public static void main(String arg[])
    {
        try
        {
            System.out.println("Client started..");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   Connect to the Server

            Socket cobj = new Socket("localhost",1400);      // Creates a Socket and connects to port 1400 of the server (running on the same computer – "localhost")

            System.out.println("Client coonected with server");
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Read & Write Data 

            BufferedReader bobj = new BufferedReader(new InputStreamReader(System.in));     // reads user input (messages to send)

            PrintStream SendMsg = new PrintStream(cobj.getOutputStream());                  // sends messages to the server

            BufferedReader ReceivedMsg = new BufferedReader(new InputStreamReader(cobj.getInputStream()));      // receives responses from the server.

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// While loop: Keep reading and sending messages

            String ReadMsg = null , typeMsg = null ;

            while(!(ReadMsg = bobj.readLine()).equalsIgnoreCase("End"))
            {
                SendMsg.println(ReadMsg);

                typeMsg = ReceivedMsg.readLine();

                System.out.println("Server says  : "+typeMsg);

                System.out.println("Enter any msg for Server : ");
            }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// close connections : Closes BufferedReader, PrintStream, and Socket to free resources.

            // cobj.close();
            // ReceivedMsg.close();
            // SendMsg.close();

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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