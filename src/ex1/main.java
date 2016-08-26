/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author Emil
 */
public class main {
    private static String url1 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png";
    private static String url2 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png";
    private static String url3 = "https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png";
    
    public static void main(String[] args) throws InterruptedException {
        
        thread thr = new thread(url1);
        thr.start();
        thread thr1 = new thread(url2); 
        thr1.start();
        thread thr2 = new thread(url3);
        thr2.start();
        thr.join();
        System.out.println(thr.getbytes());
        thr1.join();
        System.out.println(thr1.getbytes());
        thr2.join();
        System.out.println(thr2.getbytes());
        
    }
}
