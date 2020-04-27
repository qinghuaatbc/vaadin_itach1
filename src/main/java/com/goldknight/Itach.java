package com.goldknight;

import org.springframework.stereotype.Component;

import javax.management.Notification;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
@Component
public class Itach {

    private String ip;
    private int port;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
 //
  //private ArrayList<String> keys = new ArrayList<String>();
    private HashMap<String,String> keys = new HashMap<String,String>();
//should close the socket

    public Itach() {
        keys.put("0","r,1:1,1,38580,1,1,343,172,19,86BBBBBBBBBBBBBBB,19,1596,343,86,19,3360DED,19,3800\r");
        keys.put("1","sendir,1:1,1,38580,1,1,343,172,19,172,19,86CCCCCCCCCCBBBB,19,1167,343,86,19,3360EFEFE,19,3800\r");
        keys.put("2","sendir,1:1,1,38580,1,1,198,86,19,3360,343,86BCBCBC,19,3800\r");
        keys.put("3","sendir,1:1,1,38580,1,1,343,172,19,172B,19,86CCCCCCCCCBCBB,19,1167,343,86,19,3360EFEFEFEFEFEFE,19,3800\r");
        keys.put("4","sendir,1:1,1,38580,1,1,343,172,19,86B,19,172BBBBBBBBBBBCC,19,1339,343,86,19,3360EFEFEFEFE,19,3800\r");
        keys.put("5","sendir,1:1,1,38580,1,1,343,172,19,172,19,86BCCCCCCCCCBBCB,19,1167,343,86,19,3360EFEFEFE,19,3800\r");
        keys.put("6","sendir,1:1,1,38580,1,1,343,172,19,86,19,172CBBBBBBBBBBCBC,19,1253,343,86,19,3360EFEFE,19,3800\r");
        keys.put("7","sendir,1:1,1,38580,1,1,343,172,19,172BB,19,86CCCCCCCCBCCB,19,1167,343,86,19,3360EFEFE,19,3800\r");
        keys.put("8","sendir,1:1,1,38580,1,1,343,172,19,86BB,19,172BBBBBBBBBBBC,19,1425,343,86,19,3360EFEFEFE,19,3800\r");
        keys.put("9","sendir,1:1,1,38580,1,1,343,172,19,172,19,86CBCCCCCCCCBBBC,19,1167,343,86,19,3360EFEFEFEFE,19,3800\r");



//keys.add("sendir,1:1,1,38580,1,1,343,172,19,86BBBBBBBBBBBBBBB,19,1596,343,86,19,3360DED,19,3800"+"\r");
//keys.add("sendir,1:1,1,38580,1,1,343,172,19,172,19,86CCCCCCCCCCBBBB,19,1167,343,86,19,3360EFEFE,19,3800"+"\r");
//keys.add("sendir,1:1,1,38580,1,1,198,86,19,3360,343,86BCBCBC,19,3800"+"\r");
//keys.add("sendir,1:1,1,38580,1,1,343,172,19,172B,19,86CCCCCCCCCBCBB,19,1167,343,86,19,3360EFEFEFEFEFEFE,19,3800"+"\r");
//keys.add("sendir,1:1,1,38580,1,1,343,172,19,86B,19,172BBBBBBBBBBBCC,19,1339,343,86,19,3360EFEFEFEFE,19,3800"+"\r");
//keys.add("sendir,1:1,1,38580,1,1,343,172,19,172,19,86BCCCCCCCCCBBCB,19,1167,343,86,19,3360EFEFEFE,19,3800"+"\r");
//keys.add("sendir,1:1,1,38580,1,1,343,172,19,86,19,172CBBBBBBBBBBCBC,19,1253,343,86,19,3360EFEFE,19,3800"+"\r");
//keys.add("sendir,1:1,1,38580,1,1,343,172,19,172BB,19,86CCCCCCCCBCCB,19,1167,343,86,19,3360EFEFE,19,3800"+"\r");
//keys.add("sendir,1:1,1,38580,1,1,343,172,19,86BB,19,172BBBBBBBBBBBC,19,1425,343,86,19,3360EFEFEFE,19,3800"+"\r");
//keys.add("sendir,1:1,1,38580,1,1,343,172,19,172,19,86CBCCCCCCCCBBBC,19,1167,343,86,19,3360EFEFEFEFE,19,3800"+"\r");



        //out.println("sendir,1:1,1,38580,1,1,343,172,19,172BB,19,86CCCCCCCCBCCB,19,1167,343,86,19,3360EFEFE,19,3800\r");

    }


     public void send(String k){
         try {
             clientSocket = new Socket("192.168.1.134", 4998);
         } catch (IOException ex) {
             ex.printStackTrace();
         }
         try {
             out = new PrintWriter(clientSocket.getOutputStream(), true);
             in  = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));

         } catch (IOException ex) {
             ex.printStackTrace();
         }
         System.out.println(keys.get(k));
        out.println(keys.get(k));

//         try {
//             System.out.println(in.readLine());
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

     }


  //  public ArrayList<String> getKeys() {
    //    return keys;
  //  }

    public void closeAll(){
        out.close();;
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public Socket getClientSocket() {
        return clientSocket;
    }

    public PrintWriter getOut() {
        return out;
    }
}
