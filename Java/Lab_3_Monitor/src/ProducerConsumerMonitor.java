/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;


class Producer implements Runnable {
    BoundedBufferMonitor b = null;
    public Producer(BoundedBufferMonitor initb) {
        b = initb;
        new Thread(this).start();
    }
    public void run() {
        int item;
        Random r = new Random();
        while (true) {
            item = r.nextInt(500);
            System.out.println("Produced item " + item);
            b.deposit(item);
            try {
                Thread.sleep(item);
            } catch (InterruptedException e) {
            }
        }
    }
}
class Consumer implements Runnable {
    BoundedBufferMonitor b = null;
    public Consumer(BoundedBufferMonitor initb) {
        b = initb;
        new Thread(this).start();
    }
    public boolean check_SNT(int item){
        for(int i=2; i<=item/2; i++)
            {
                if(item%i==0){
                    return false;
                }
            }
        return true;
    }
    public void run() {
        int item;
        while (true) {
            item = b.fetch();
            if(check_SNT(item)){
                System.out.println("Fetched item " + item+" :OK ");
            }
            else{
                System.out.println("Fetched item " + item+" :NOT ");
            }
            
            
            try {
            Thread.sleep(item);
        } catch (InterruptedException e) {
        }
        }
    }
}
class ProducerConsumer {
    public static void main(String[] args) {
        BoundedBufferMonitor buffer = new BoundedBufferMonitor();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
    }
}

