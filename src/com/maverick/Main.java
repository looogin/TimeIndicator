package com.maverick;


import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        GeneralForm generalForm = new GeneralForm("Time");
        generalForm.setSize(300, 150);
        generalForm.setResizable(false);
        Dimension frameSize = generalForm.getSize();
        generalForm.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        generalForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        generalForm.setVisible(true);
        generalForm.start();
    }
}
