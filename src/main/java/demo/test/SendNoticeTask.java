package demo.test;

/**
 * Created by changrong.zeng on 2017/11/8.
 */
public class SendNoticeTask implements Runnable {
    private int count;

    public void setCount(int count)
      {
        this.count = count;
      }
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start to" + " send " + count + " ...");
        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish " + Thread.currentThread().getName());
    }
}
