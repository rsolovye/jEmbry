package com.company.next;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by bobsol on 06.08.16.
 */
public class SessionView {
    private  ActionListener _actionListener;
    private JPanel view_master;
    private String toStr;

    public SessionView(){


    view_master = new JPanel();
     toStr = "SessionView: END_OF_CONSTRUCTOR";
    }

    public void setActionListener(ActionListener pListener){
        _actionListener=pListener;

    }


    public MenuBar getMenuBar() {
        MenuBar menuBar = new MenuBar();


        return menuBar;

    }
public String toString(){
    return toStr + "SessionView: toStrrrrrRing";
}
public void createGUI(){
    view_master.setLayout(new MigLayout());
    view_master.add(new JLabel("-=====================-"));
    JButton addButton = new JButton("Add");
    addButton.addActionListener(_actionListener);


    view_master.add(addButton);
}
    public JPanel getPanel(){
    return view_master;
    }

}
