///////////////////////////////////////////////////////////
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
///////////////////////////////////////////////////////////

class Client
{
    public static void main(String[] arg)
    {
        try
        {
            final int iPortNumber = 122;

            // connect to the server
            Socket socketObj = new Socket("localhost",iPortNumber);
            System.out.println("Client is On with port number: "+iPortNumber);

            if(socketObj.isConnected())
            {
                System.out.println("Clinet is connected with Server...");
            }
            else
            {
                System.out.println("!!! Client is unable to coonect with server !!!");
            }

            // Read and write the DATA Object creation
            BufferedReader bufferedReaderObjTypeData = new BufferedReader(new InputStreamReader(System.in)); // type the data
            BufferedReader bufferedReaderObjRecive = new BufferedReader(new InputStreamReader(socketObj.getInputStream())); // recieve the data
            PrintStream printStreamObjSendData = new PrintStream(socketObj.getOutputStream()); // send the data to client

            // read and write data
            ///////////////////////////////////////
            String readMsg = null, writeMsg = null;
            //////////////////////////////////////////
            while(true)
            {
                // wite the msg
                System.out.print("\t\tClient: ");
                writeMsg = bufferedReaderObjTypeData.readLine();

                // send the msg
                printStreamObjSendData.println(writeMsg);

                // read the msg
                readMsg = bufferedReaderObjRecive.readLine();

                // display the readed msg
                if(readMsg.equalsIgnoreCase("off") || readMsg.equalsIgnoreCase(null))
                {
                    break;
                }
                System.out.println("Server: "+readMsg);
            }

            // close the client
            if(socketObj.isClosed() == true)
            {
                System.out.println("Client is Disconnected with client");
            }
            
        }
        catch(UnknownHostException e1)
        {
            System.out.println("ERROR: "+e1.getMessage());
        }
        catch(IOException e2)
        {
            System.out.println("ERROR: "+e2.getMessage());
        }
        
        System.out.println("Client is now 'off'");
    }
}