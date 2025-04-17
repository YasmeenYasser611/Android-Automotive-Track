/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author yasmeen
 */
public class Server 
{
    private ServerSocket server;
    
    public Server(){
        try {
            server = new ServerSocket(8008);
            while(true)
            {
                Socket s = server.accept();
                new ChatHandler(s);
            }
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally
        {
            try 
            {
                server.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) 
    {
        new Server();
    }
}
