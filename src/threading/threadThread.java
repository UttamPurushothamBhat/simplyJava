package threading;


public class threadThread  extends Thread{
    String name;
    int threadNumber;

    threadThread(String name, int threadNumber){
        super(name);
        this.threadNumber=threadNumber;
    }


    @Override
    public void run(){
        System.out.println("Thread number : " + threadNumber+ " name : " + Thread.currentThread().getName() +" class : threadThread");
    }


}
