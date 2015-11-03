package com.maverick;

import javax.swing.*;


public class MinePanel extends JPanel {
    private  String namebutton = "Time";
    public  JButton bat1 = new JButton(namebutton);

    public MinePanel(){
        setLayout(null);
        add(bat1);
        bat1.setBounds(0,0,70,35);

    }


}