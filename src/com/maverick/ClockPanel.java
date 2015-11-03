package com.maverick;

import javax.swing.*;
import java.awt.*;


public class ClockPanel extends JPanel {
    private JLabel lab1 = new JLabel();
    private int fontsize = 32;


    public ClockPanel(){
        setLayout(null);
        add(lab1);
        lab1.setBounds(80,50,200,fontsize);
        lab1.setFont(new Font("Arial", Font.BOLD, fontsize));
        lab1.setForeground(Color.red);
    }


    public void setLabel1Text(String text){
        this.lab1.setText(text);
    }

}