package com.company;

//import com.company.next.PunctureController;
import com.company.next.SessionController;
import com.company.next.SessionModel;
import com.company.next.SessionView;

import javax.swing.*;

public class Main {

public static String APP_NAME="jEmbry";
    public static JFrame frame = new JFrame();


    public static void main(String[] args) {

        frame.setTitle(APP_NAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SessionModel session = new SessionModel();
        SessionView sessionView = new SessionView();
        SessionController sessionController = new SessionController(session, sessionView);

        sessionController.updateSessionView();

        frame.setMenuBar(sessionView.getMenuBar());
        frame.setContentPane(sessionView.getPanel());


        frame.pack();
        frame.setVisible(true);
    }
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
