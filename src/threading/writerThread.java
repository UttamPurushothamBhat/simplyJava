package threading;

import java.util.List;

public class writerThread extends Thread{

    List<Integer> l;
    String name;
    writerThread(List<Integer> l ,int i){
        super(String.valueOf(i));
        name=String.valueOf(i);
        this.l = l;

    }
    @Override
    public  void run() {
        int x =l.size()+1;
       l.add(x);
       System.out.println(name+ " added "+ x);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
