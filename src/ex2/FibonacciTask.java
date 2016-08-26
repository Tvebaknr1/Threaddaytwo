package ex2;


import java.util.ArrayList;
import java.util.List;

public class FibonacciTask extends Thread{
    private long tal;
    public static List<FibonacciObserver> observers = new ArrayList();
    
    public void registerFibonacciObserver(FibonacciObserver o){
      observers.add(o);
    }
    
    public FibonacciTask() {
        tal = 0;
    }
    
    public void updatetal(long n){
        this.tal=n;
    }
    @Override
    public void run() {
        //Call the Fibonacci method from here
        //long tal = ......
        long i = fib(tal);
        for(FibonacciObserver observer : observers){
          observer.dataReady(i);
        }
    }
    public void runagain(){
        long i = fib(tal);
        for(FibonacciObserver observer : observers){
          observer.dataReady(i);
        }
    }
    
    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
