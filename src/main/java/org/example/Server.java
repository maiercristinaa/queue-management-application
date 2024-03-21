package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private LinkedBlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private Interfata frame;

    public Server() {
        tasks = new LinkedBlockingQueue<>();
        waitingPeriod = new AtomicInteger(0);
        this.frame= new Interfata();

    }

    public LinkedBlockingQueue<Task> getTasks() {
        return tasks;
    }

    public void setTasks(LinkedBlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task newTask){
        this.tasks.add(newTask);
        waitingPeriod.getAndIncrement();
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public void run(){
        while (true)
        {
            try {
                for (Task t : tasks) {
                    frame.setTextArea1(Thread.currentThread().getName()+": "+tasks+"\n");
                    if(t.getServiceTime()==0) {
                        tasks.remove(t); // Elimină sarcina finalizată din coadă
                        waitingPeriod.getAndDecrement(); // Scade perioada de așteptare cu 1
                        Thread.sleep(t.getServiceTime() * 1000); // Așteaptă pentru timpul specificat în sarcină
                    }

                }

            } catch (InterruptedException e){
                    e.printStackTrace();
                }
        }
    }
}
