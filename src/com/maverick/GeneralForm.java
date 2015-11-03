package com.maverick;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Alex on 03.11.2015.
 */

public class GeneralForm extends JFrame implements Runnable {
    private boolean running;
    private int tickCount;

    private final SimpleDateFormat TFormat = new SimpleDateFormat("HH:mm:ss");
    private MinePanel minePanel = new MinePanel();
    private ClockPanel clockPanel = new ClockPanel();
    private final int w = 70;
    private final int h = 35;

    public GeneralForm(String title) throws HeadlessException {
        super(title);
        ActionListener listener = new ButtonListener();
        Container osnova = getContentPane();
        osnova.setLayout(null);
        osnova.add(minePanel);
        minePanel.setBounds((300 - w) / 2, 44, w, h);
        minePanel.setBackground(Color.BLACK);
        osnova.add(clockPanel);
        clockPanel.setBounds(0, 0, 300, 150);
        clockPanel.setBackground(Color.BLACK);
        clockPanel.setVisible(false);
        minePanel.bat1.addActionListener(listener);
    }
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double unprocessed = 0;
        double nsPerTick = 1000000000.0 / 60;
        int ticks = 0;
        long lastTimer1 = System.currentTimeMillis();
        while (running) {
            long now = System.nanoTime();
            unprocessed += (now - lastTime) / nsPerTick;
            lastTime = now;
            while (unprocessed >= 1) {
                ticks++;
                tick();
                unprocessed -= 1;
            }
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (System.currentTimeMillis() - lastTimer1 > 1000) {
                lastTimer1 += 1000;
                //System.out.println(ticks + " ticks, ");
                ticks = 0;
            }
        }
    }
    private void tick() {
        if (!hasFocus()) {
            clockPanel.setLabel1Text((TFormat.format(new Date())));
        }
        tickCount++;
    }
    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void stop() {
        running = false;
    }


    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(minePanel.isVisible()) {
                minePanel.setVisible(false);
                clockPanel.setVisible(true);
            }

        }
    }
}

