package com.company;

//import com.company.next.PunctureController;
import com.company.Utilities.GUI.Utils;
import com.company.next.*;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main {

public static String APP_NAME="jEmbry";

    public static JFrame APP_FRAME = new JFrame();


    public static void main(String[] args) {

        APP_FRAME.setTitle(APP_NAME);
        APP_FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SessionModel session = new SessionModel();
        SessionView sessionView = new SessionView();
        SessionController sessionController = new SessionController(session, sessionView);
//user chooser




         JList user_list = Utils.getList(DB_TEMP.EMB);
        ListSelectionModel lm = user_list.getSelectionModel();
        lm.addListSelectionListener(e -> {
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            if (!lsm.getValueIsAdjusting() && lsm.getMinSelectionIndex()!=-1) {
                System.out.println(user_list.getSelectedValue());
                session.setUser((String) user_list.getSelectedValue());

            }


        });

         JPanel userChooserPanel = Utils.getTitledPanel("You are....", user_list, TitledBorder.CENTER, TitledBorder.CENTER);


                // new JPanel(new MigLayout("flowy"));
               // userChooserPanel.add(Utils.getList(lm))

        sessionController.updateSessionView();

        APP_FRAME.setJMenuBar(sessionView.getMenuBar());
        APP_FRAME.getContentPane().add(userChooserPanel);


        APP_FRAME.pack();
        APP_FRAME.setVisible(true);
    }

     //private  JPanel userChooser(){

        //etUsersFromDB();
         //generateList();
         //listenforselection();
         //SetChoosenUserInModel();

    // }
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
