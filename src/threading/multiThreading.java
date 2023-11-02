package threading;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class multiThreading {


    public static void main(String[] args) throws InterruptedException {

        /*Thread tRunnable = new Thread( new threadRunnable(1), "tRunnable");
        Thread tThread = new threadThread("tThread", 2);
        tRunnable.start();
        tThread.start();

        new Thread( () -> {
            System.out.println("Thread name : " + Thread.currentThread().getName() +" class : threadLambda");

        }, "tLambda").start();*/


        //thread Safety  using locks with synchronized
        sharedResource sr = new sharedResource(5);
        /*new Thread( () -> {
            for(int i=0;i<10;i++) {

                System.out.println(Thread.currentThread().getName() + " added "+ i + " "+ sR.add(i)+ " count " + sR.count);
            }
        }, "adder").start();

        new Thread( () -> {
            for(int i=0;i<10;i++) {
                System.out.println(Thread.currentThread().getName() + " removed "+ i +" "+ sR.remove() + " count " + sR.count);

            }
        }, "remover").start();*/



        for(int i=0;i<26;i++) {
            new Thread(()->{
                sr.addStringBuffer();

            },String.valueOf(i)).start();
        }

        for(int i=0;i<26;i++) {
            new Thread(()->{
                sr.addStringBuilder();

            },String.valueOf(i)).start();
        }

        Thread.sleep(5000);

        char tempArray[] = sr.sb.toString().toCharArray();
        Arrays.sort(tempArray);
        System.out.println("StringBuffer : "+new String(tempArray));




        char ntempArray[] = sr.sb1.toString().toCharArray();
        Arrays.sort(ntempArray);
        System.out.println("StringBuilder : "+new String(ntempArray));


    }

}