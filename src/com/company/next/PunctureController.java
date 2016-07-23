package com.company.next;

import com.company.Utilities.GUI.Utils;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.*;

import static java.time.LocalTime.*;

/**
 * Created by micro on 23.07.2016.
 */
public class PunctureController {
    JButton _test_add = new JButton("TEST - Добавить");

    PunctureView _view = new PunctureView();
    PunctureDA0 _dao = new PunctureDA0();
    ArrayList<DefaultListModel> _listModels = new ArrayList<DefaultListModel>();
    public static ArrayList<JList> _list_of_lists = new ArrayList<JList>();
    HashMap<String, JList> _hmLists = new HashMap<String, JList>();

    public PunctureController() {

        for (int i = 0; i < _dao.getListNumber(); i++) {


            DefaultListModel lm = new DefaultListModel();



            _listModels.add(lm);


            for (String vals : _dao.getListValues(i)) {
                lm.addElement(vals);
            }
            JList tmp = Utils.getList(lm, 4, ListSelectionModel.SINGLE_SELECTION);

            tmp.setName("list" + i);
            tmp.addListSelectionListener(new SharedListSelectionHandler());

            _list_of_lists.add(tmp);
            _hmLists.put(tmp.getName(), tmp);

        }
        System.out.println( "Number of JLists = " +_hmLists.size());
        for (JList j : _hmLists.values()){
            System.out.println(j.getName() + " size = " + j.getModel().getSize());//;.toString());//.values().toString());

            for (int i = 0; i < j.getModel().getSize() ; i++) {


                System.out.println(i + " : " + j.getModel().getElementAt(i));
            }

    }
    _test_add.addActionListener(new AddActionListener());

    }


    public JPanel createGUI() {
        JPanel p = new JPanel(new MigLayout(""));
        for (JComponent c : _list_of_lists) {
            p.add(c, "gap 20");
        }
        p.add(_test_add, "newline");
        p.validate();
        return p;
    }
}
class AddActionListener implements ActionListener
{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println();
        System.out.println(java.time.LocalTime.now());

        for (JList k: PunctureController._list_of_lists)
        {

            System.out.println(k.getName() + " : " + k.getSelectedValue().toString());
    }
    }
}

class SharedListSelectionHandler implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = ((JList) e.getSource()).getSelectionModel();

        int firstIndex = e.getFirstIndex();
        int lastIndex = e.getLastIndex();
        boolean isAdjusting = e.getValueIsAdjusting();
        System.out.println("Event for indexes "
                + firstIndex + " - " + lastIndex
                + "; isAdjusting is " + isAdjusting
                + "; selected indexes:");

        if (lsm.isSelectionEmpty()) {
            System.out.println(e.getSource().toString() + " <none>");
        } else {
            // Find out which indexes are selected.
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i)) {
                    System.out.println("Selected index " + i);
                }
            }
        }

    }
}
