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
    private JMenuBar menuBar;
    public SessionView(){
        menuBar = new JMenuBar();
        view_master = new JPanel();

        toStr = "SessionView: END_OF_CONSTRUCTOR";

    }

    public void setActionListener(ActionListener pListener){
        _actionListener=pListener;

    }

    private void buildMenu(){
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        menuBar.add(new JLabel("Embr Name: "));

    }

    public JMenuBar getMenuBar() {


        return menuBar;

    }



public void createGUI(){
    view_master.setLayout(new MigLayout());
    view_master.add(new JLabel("-=====================-"));
    JButton addButton = new JButton("Add");
    addButton.addActionListener(_actionListener);


    view_master.add(addButton);
}
    public JComponent show(){
    return menuBar;
    }

    public String toString(){
        return toStr + "SessionView: toStrrrrrRing";
    }
}
