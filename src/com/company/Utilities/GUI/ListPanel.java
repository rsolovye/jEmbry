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
public class ListPanel extends JPanel implements ListSelectionListener {
    private JList list;

    public void set_listModel(DefaultListModel _listModel) {
        this._listModel = _listModel;
    }

    private DefaultListModel _listModel;
    private NextDayPF_DAO l;

    public ListPanel(String[] pData, NextDayPF_DAO lf){
        super(new MigLayout(""));

        _listModel = new DefaultListModel();
        _listModel.addListDataListener(new MyListDataListener());

        if (pData != null){
            for (String d : pData){
                _listModel.addElement(d);
            }
        }
        list = new JList(_listModel);
        list.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);
        //list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        super.add(this.list);
    }

    public void setSelection(String s){
        list.setSelectedIndex(_listModel.indexOf(s));
    }



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

        public void intervalAdded(ListDataEvent e) {

        }


        public void intervalRemoved(ListDataEvent e) {

        }


        public void contentsChanged(ListDataEvent e) {
            System.out.println("contentsChanged: " + e.getIndex0() +
                    ", " + e.getIndex1());


        }
    }
}
