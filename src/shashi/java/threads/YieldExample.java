package shashi.java.threads;

/**
 * Created with IntelliJ IDEA.
 * User: Shashi Mourya
 * Email: 0905shashi@gmail.com
 * Date: 3/22/18
 * Time: 2:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class YieldExample
{
    public static void main(String[] args)
    {
        Thread producer = new Producer();
        Thread consumer = new Consumer();

       // producer.setPriority(Thread.MIN_PRIORITY); //Min Priority
       // consumer.setPriority(Thread.MAX_PRIORITY); //Max Priority

        producer.start();
        consumer.start();
    }
}

class Producer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Producer : Produced Item " + i);
           // Thread.yield();
        }
    }
}

class Consumer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Consumer : Consumed Item " + i);
           // Thread.yield();
        }
    }
}
