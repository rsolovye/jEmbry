package com.company;

import com.company.next.PunctureController;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Новая Пункция");

        NextDayPF ndpf = new NextDayPF();
        PunctureController pc = new PunctureController();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.add(ndpf.getPanel());
       frame.add(pc.createGUI());
        frame.pack();
        frame.setVisible(true);
    }
	// write your code here:s
//        public static void main(String[] args) {
//            //Schedule a job for the event dispatch thread:
//            //creating and showing this application's GUI.
//            javax.swing.SwingUtilities.invokeLater(new Runnable() {
//                public void run() {
//                    LookAndFeelDemo.createAndShowGUI();
//                }
//            });
//        }

}
