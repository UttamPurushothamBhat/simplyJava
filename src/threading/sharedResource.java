package threading;

import java.util.*;

public class sharedResource {
    Stack<Integer> s;
    int maxSize;
    int count;

    int countBuff;
    int countBuild;

    Hashtable<Integer,Integer> ht;

    HashMap<Integer,Integer> hm;

    List<Integer> l;

    StringBuffer sb;

    StringBuilder sb1;
    sharedResource(int num){
        s = new Stack<Integer>();
        maxSize=num;
        count=0;
        ht = new Hashtable<>();
        hm =new HashMap<>();
        l = new ArrayList<>();
        sb = new StringBuffer();
        sb1 = new StringBuilder();
        countBuff=0;
        countBuild=0;
    }

    public synchronized boolean add(int val){
        if(s.size()>maxSize)return false;
        s.add(val);count++;return true;
    }

    public synchronized boolean remove(){
       if(s.isEmpty())return false;
       s.pop();
       count--;
       return true;
    }


    public void put( ){
        Integer i = Integer.parseInt(Thread.currentThread().getName());
        System.out.println(i +"th threard "+Thread.currentThread().getName() + " adding to table/map ");

            try {
                if(i<5) {
                    Thread.sleep(300);
                } else Thread.sleep(100);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        //hm.put(hm.size(),hm.size());
        ht.put(ht.size(),ht.size());





    }

    public void read(Character c){
        ht.remove(c);
    }

    public synchronized  void listadd(){

        count++;
        try {
            for(int i=0;i<10;i++) {
                if (Thread.currentThread().getName().equals(String.valueOf(i)))
                    Thread.sleep(i*100);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        l.add(count);
        System.out.println(Thread.currentThread().getName() + " adding to list " + getListSize() );
    }

    public int getListSize(){
       return l.get(l.size()-1);
    }


    public synchronized void addStringBuffer(){
        try {
            if(Integer.parseInt(Thread.currentThread().getName())<5) {
                Thread.sleep(300);
            } else Thread.sleep(100);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }        char a = (char)('A' + countBuff++);
        sb.append(a);
    }

    public synchronized void addStringBuilder(){
        try {
            if(Integer.parseInt(Thread.currentThread().getName())<5) {
                Thread.sleep(300);
            } else Thread.sleep(100);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        char a = (char)('A' + countBuild++);
        sb1.append(a);
    }

}
