package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationManager implements Runnable{
    private  Scheduler planificator;
    private Interfata interfata;
    private List<Task> taskList = new ArrayList<Task>();

    public SimulationManager(Interfata interfata) {
        this.interfata=interfata;
        planificator = new Scheduler(interfata.getQ());
        generateRandomTask();
    }

   // timpul minim și maxim de procesare și de sosire din interfață
    public void generateRandomTask() {
        for (int i = 0; i < interfata.getN(); i++) {
            int minProcessingTime = interfata.getMinST();
            int maxProcessingTime = interfata.getMaxST();
            int minArrivalTime = interfata.getMinAT();
            int maxArrivalTime = interfata.getMaxAT();
            Random r1 = new Random();
            int st = r1.nextInt(maxProcessingTime - minProcessingTime) + minProcessingTime;
            Random r2 = new Random();
            int at = r2.nextInt(maxArrivalTime - minArrivalTime) + minArrivalTime;
            Task t = new Task(at, st, i);
            taskList.add(t);
        }
    }


    public void run()
    {
        int currentTime = 0;
        while(currentTime<interfata.gettSim())
        {
            for(int i = 0;i<taskList.size();i++)
            {
                if(taskList.get(i).getArivalTime()==currentTime)
                {
                    int pozition = 0;
                    int minim = Integer.MAX_VALUE;
                    for(int j =0; j<planificator.getLista().size();j++)  // Parcurgem lista planificatorului și gasim poziția listei cu cel mai mic timp de așteptare
                    {
                        if(planificator.getLista().get(j).getWaitingPeriod().get()<minim)
                        {
                            minim = planificator.getLista().get(j).getWaitingPeriod().get();
                            pozition = i;
                        }
                    }
                    planificator.getLista().get(pozition).getTasks().add(taskList.get(i)); //adaugam sarcina curentă în lista de sarcini corespunzătoare poziției găsite
                    taskList.remove(i);
                }
            }
            for(int z=0;z<interfata.getQ();z++){
                for(Task t:planificator.getLista().get(z).getTasks()) {
                    if (t.getServiceTime() > 0)
                        t.setServiceTime(t.getServiceTime() - 1); //scadem timpul de procesare al fiecărei sarcini cu 1
                }
            }
            for(int k =0; k<interfata.getQ();k++)
            {
                System.out.println(planificator.getLista().get(k).getTasks());
            }
            for(int l = 0; l<taskList.size(); l++)
            {
                System.out.println(taskList.get(l).toString());
            }
            String newl = System.lineSeparator();
            System.out.println(newl);
            currentTime++;
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex )
            {
                ex.printStackTrace();
            }
        }
    }
}
