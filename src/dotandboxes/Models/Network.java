
package dotandboxes.Models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Network {
    
    private static InetAddress ipAddress;
    private static int port;
    
    public static String receiveData(){
        DatagramSocket serverSocket;
        try {
            serverSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024]; 
            while(true){    
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length); 
                serverSocket.receive(receivePacket);
                String data = new String( receivePacket.getData());
                System.out.println("RECEIVED: " + data);
                ipAddress = receivePacket.getAddress();             
                port = receivePacket.getPort();
                return data;
            }
        }
        catch (SocketException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return "";
    }
  
    public static void sendData(String data){
        if(ipAddress == null || port == 0){
            return;
        }
        
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            byte[] sendData = data.getBytes(); 
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ipAddress , port);     
            clientSocket.send(sendPacket);
            clientSocket.close();
        }
        catch (SocketException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Network.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
