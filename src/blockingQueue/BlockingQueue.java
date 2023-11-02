package blockingQueue;

public class BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        Queuer qq = new Queuer(5);
        Thread a = new Thread(()->{
            for(int i=0;i<10;i++){
                qq.sum();
                qq.add(i);

            }
        },"adder");

       Thread r = new Thread(()->{
            for(int i=0;i<10;i++){
                qq.sum();
                qq.remove();

            }
        },"remover");


       a.start();r.start();

       a.join();r.join();

    }
}
