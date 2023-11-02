package threading;

public class threadRunnable implements Runnable{
    int threadNumber;

    threadRunnable(int threadNumber){
        this.threadNumber=threadNumber;
    }

    @Override
    public void run(){
        System.out.println("Thread number : " + threadNumber+ " name : " + Thread.currentThread().getName() +" class : threadRunnable");
    }

}