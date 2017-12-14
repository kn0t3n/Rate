package com.sabel.threads;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MeinFenster extends JFrame implements Runnable {

    private JLabel jLabel;
    private JButton jButton;
    private JPanel jPanelSouth, jPanelNorth;

    public MeinFenster() {
        super("Mein Fenster");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.initComponents();

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(MeinFenster.this).start();
            }
        });
        this.setVisible(true);
    }

    private void initComponents() {
        jPanelNorth = new JPanel();
        jPanelSouth = new JPanel();
        jLabel = new JLabel();
        jButton = new JButton("Start");
        jPanelSouth.add(jButton);
        jPanelNorth.add(jLabel);
        this.add(jPanelNorth, BorderLayout.NORTH);
        this.add(jPanelSouth, BorderLayout.SOUTH);
    }

    @Override
    public void run() {
        String name = getName();
        for (int i = 0; i < 5; i++) {
            jLabel.setText("Zahl: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
        jLabel.setText(getName() + " fertig!");
    }

    public static void main(String[] args) {
        new MeinFenster();
    }
}
