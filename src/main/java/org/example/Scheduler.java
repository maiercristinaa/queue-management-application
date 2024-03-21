package org.example;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> lista = new ArrayList<Server>();
    public Scheduler(int num){
        for(int i = 0; i<num; i++)
        {
            Server serv = new Server();
            lista.add(serv);
            Thread t = new Thread(serv);
            t.start();
        }
    }

    public List<Server> getLista() {
        return lista;
    }

}
