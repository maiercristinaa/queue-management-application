package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfata {

    private JButton button1;
    private JPanel panou;
    private JTextField n;
    private JTextField q;
    private JTextField tSim;
    private JTextField minST;
    private JTextField maxST;
    private JTextField minAT;
    private JTextField maxAT;
    private JTextArea textArea1;

    public int getN() {
        return Integer.parseInt(n.getText());
    }

    public int getQ() {
        return Integer.parseInt(q.getText());
    }

    public int gettSim() {
        return Integer.parseInt(tSim.getText());
    }

    public int getMinST() {
        return Integer.parseInt(minST.getText());
    }

    public int getMaxST() {
        return Integer.parseInt(maxST.getText());
    }

    public int getMinAT() {
        return Integer.parseInt(minAT.getText());
    }

    public int getMaxAT() {
        return Integer.parseInt(maxAT.getText());
    }

    public String getTextArea1() {
        return textArea1.getText();
    }

    public void setTextArea1(String textArea1) {
        this.textArea1.append(String.valueOf(textArea1));
    }

    public Interfata()
    {
        JFrame frame = new JFrame("Threads");
        frame.setContentPane(panou);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(850,350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Interfata inter = this;
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimulationManager simulation = new SimulationManager(inter);
                Thread t = new Thread(simulation);
                t.start();
            }
        });


    }

}
