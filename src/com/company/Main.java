package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Новая Пункция");

        NextDayPF ndpf = new NextDayPF();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(ndpf.getPanel());
         frame.pack();
        frame.setVisible(true);

	// write your code here:s
    }
}
