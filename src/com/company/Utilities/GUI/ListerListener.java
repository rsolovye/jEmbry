package com.company.Utilities.GUI;

import com.company.NextDayPF_DAO;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by micro on 22.07.2016.
 */
public class ListerListener extends JPanel implements ListSelectionListener {
    private JList list;
    private DefaultListModel listModel;
    private NextDayPF_DAO l;

    public ListerListener(String[] pData, NextDayPF_DAO lf){
        super(new MigLayout("fillx, filly, grow"));

        listModel = new DefaultListModel();
        listModel.addListDataListener(new MyListDataListener());

        if (pData != null){
            for (String d : pData){
                listModel.addElement(pData);
            }
        }
        list = new JList(listModel);
        list.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);
        //list.setSelectedIndex(0);
        list.addListSelectionListener(this);
    }

    public void setDefaultSelectedIndex(String s){
        list.setSelectedIndex(listModel.indexOf(s));
    }

    @Override

    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
                //No selection: disable delete, up, and down buttons.
                    System.out.print(list.getSelectedIndex());
            }  else {
                //Single selection: permit all operations.

                System.out.print(list.getSelectedValue().toString());
            }
        }
    }

    private class MyListDataListener implements ListDataListener {
        @Override
        public void intervalAdded(ListDataEvent e) {

        }

        @Override
        public void intervalRemoved(ListDataEvent e) {

        }

        @Override
        public void contentsChanged(ListDataEvent e) {
            System.out.println("contentsChanged: " + e.getIndex0() +
                    ", " + e.getIndex1());


        }
    }
}
