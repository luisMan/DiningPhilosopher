import java.util.*;

public class DiningPhilosopher extends Thread
{
    String name;
    int philosopherId;
    private Chopstick chopstick;
    private int waitTime =0;
    private int eatingTime =0;
    static  int currentPhilosopherId =0;
    //lets create a hashmap to get this lazy philosopher
    public static HashMap<Integer,String> philosopher = new HashMap<Integer,String>(){
        {
            put(0,"Luis Manon el CEO");
            put(1,"Popoteur El arabe");
            put(2,"Rodny El Sensei");
            put(3,"Stanley ma que duerme");
            put(4,"Donelys family guy"); }};



    public DiningPhilosopher(Chopstick chopstick)
    {
        super();
        philosopherId = currentPhilosopherId;
        currentPhilosopherId++;
        this.chopstick = chopstick;
    }

    //function to return the philosopher id of the current thread
    public int getPhilosopherId()
    {
        return philosopherId;
    }

    //our override function that runs asynchronomously
    public void run()
    {
        while(true){
            waiting();
            chopstick.grabChopStick();
            eating();
            chopstick.looseChopStick();
        }
    }


    //this method is to illustrate who is busy doing something
    private void waiting()
    {
        name =   philosopher.get(philosopherId);
        waitTime++;
        System.out.println( philosopher.get(philosopherId) +"is waiting for x"+ waitTime +" times");
        try
        {
            sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    //this philopher stop being lazy and now is eating since there is more available chopstick
    private void eating() {
        eatingTime++;
        System.out.println("P #"+(philosopherId+1)+" is eating for x"+ waitTime+" times");
        try
        {
            sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}