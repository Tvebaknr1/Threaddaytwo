/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emil
 */
public class thread extends Thread{

    private String url;
    private int img;

    public thread(String Url) {
        url = Url;
        
    }

    @Override
    public void run() {
        byte[] imgbit = null;
        try {
            imgbit = getBytesFromUrl(url);
        } catch (IOException ex) {
            Logger.getLogger(thread.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i < imgbit.length; i++) {
            img += imgbit[i];
        }
        
    }
    public int getbytes(){
        
        return img;
    }
    

    public static byte[] getBytesFromUrl(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        connection.connect();
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try {
            InputStream is = connection.getInputStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0) {
                bis.write(bytebuff, 0, read);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return bis.toByteArray();
    }

}
