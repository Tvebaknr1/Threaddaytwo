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
public class Tester {

    private static String url1 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png";
    private static String url2 = "https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png";
    private static String url3 = "https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png";
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        long start = System.nanoTime();
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());

        thread thr = new thread(url1);
        thr.run();
        thread thr1 = new thread(url2);
        thr1.run();
        thread thr2 = new thread(url3);
        thr2.run();
        thr.join();
        i += thr.getbytes();
        thr1.join();
        i += thr1.getbytes();
        thr2.join();
        i += thr2.getbytes();

        long end = System.nanoTime();
        System.out.println("Time Sequental: " + (end - start));
        //parral Time Sequental: 750481978
        //secence Time Sequental: 717362488
    }

}
