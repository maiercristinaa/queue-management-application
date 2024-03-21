package org.example;


public class Task {
    private int arivalTime;
    private int serviceTime;
    private int id;

    public int getArivalTime() {
        return arivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getId() {
        return id;
    }

    public void setArivalTime(int arivalTime) {
        this.arivalTime = arivalTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Task(int arivalTime, int serviceTime, int id) {
        this.arivalTime = arivalTime;
        this.serviceTime = serviceTime;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "arivalTime=" + arivalTime +
                ", serviceTime=" + serviceTime +
                ", id=" + id +
                '}';
    }
}
