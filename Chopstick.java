
public class Chopstick {

    private boolean[] isHeld = {false, false, false, false, false};
    public synchronized void grabChopStick()
    {
        DiningPhilosopher p = (DiningPhilosopher) Thread.currentThread();
        int pnum = p.getPhilosopherId();
        while(isHeld[pnum] || isHeld[(pnum + 1) % 5])
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(p.name+ " : grabbed the chopstick!");
        isHeld[pnum] = true;
        isHeld[(pnum + 1) % 5] = true;
    }
    public synchronized void looseChopStick()
    {
        DiningPhilosopher p = (DiningPhilosopher) Thread.currentThread();
        int pnum = p.getPhilosopherId();
        System.out.println(p.name + " :loose the chopstick!");
        isHeld[pnum] = false;
        isHeld[(pnum+ 1) % 5] = false;
        notifyAll();
    }
}
