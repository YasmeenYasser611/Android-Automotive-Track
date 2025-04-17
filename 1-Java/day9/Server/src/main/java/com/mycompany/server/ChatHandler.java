/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yasmeen
 */
public class ChatHandler extends Thread
{
    private DataInputStream dis;
    private PrintStream dos;
    static Vector<ChatHandler> clientsVector = new Vector<ChatHandler>();

    public ChatHandler(Socket cs) 
    {
        try {
            dis = new DataInputStream(cs.getInputStream());
            dos = new PrintStream(cs.getOutputStream());
            ChatHandler.clientsVector.add(this);
            start();
        }  
        catch (UnknownHostException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }

    
}
    public void run()
    {
        while(true)
        {
            try 
            {
                String str = dis.readLine();
                sendMessageToAll(str);
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    void sendMessageToAll(String msg)
    {
        for(int i=0 ; i< clientsVector.size() ; i++)
        {
            clientsVector.get(i).dos.println(msg);
        }
    }
}
