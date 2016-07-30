package com.company.next;

import com.company.Utilities.GUI.ListPanel;
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

import static com.company.next.PunctureController._dao;
import static java.time.LocalTime.*;

/**
 * Created by micro on 23.07.2016.
 */
public class PunctureController {
    JButton _test_add = new JButton("TEST - Добавить");

    static PunctureView _view = new PunctureView();
    static PunctureDA0 _dao = new PunctureDA0();

    ArrayList<DefaultListModel> _listModels = new ArrayList<DefaultListModel>();

    public static ArrayList<JList> _list_of_lists = new ArrayList<JList>();
    HashMap<String, JList> _hmLists = new HashMap<String, JList>();
    

    public PunctureController() {
        //get VALUES FOR LISTS

        for (int i = 0; i < _dao.getListNumber(); i++) {


            DefaultListModel lm = new DefaultListModel();


             _listModels.add(lm);

for (String keys : _listKeys) {
    for (String vals : _dao.getListValues()) {
        lm.addElement(vals);
    }



            _view.addList("" + i, lm);


        }



        _view.setList_action_listener(new AddActionListener(_view));

            _view.createGUI();
    }


    public JPanel createGUI() {
//        JPanel p = new JPanel(new MigLayout(""));
//        for (JComponent c : _list_of_lists) {
//           // p.add(c, "gap 20");
//        }
//        JPanel lp = new ListPanel(_dao.getListValues(0), null);
//        p.add(lp);
//        p.add(_test_add, "newline");
//        p.validate();
        return _view.getPanel();
    }
public void debug_lists(){
//        System.out.println( "Number of JLists = " +_view.get_all_lists().size());
//        for (JList j : _view.get_all_lists()){
//            System.out.println(j.getName() + " size = " + j.getModel().getSize());//;.toString());//.values().toString());
//
//            for (int i = 0; i < j.getModel().getSize() ; i++) {
//
//
//                System.out.println(i + " : " + j.getModel().getElementAt(i));
//            }
//
//    }
}

}


class AddActionListener implements ActionListener
{

    private ArrayList<JList> _jlists;
    AddActionListener(PunctureView pView){
        _jlists=pView.get_all_lists();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println();
        System.out.println(java.time.LocalTime.now());

        for (JList k: _jlists)
        {
            if (k.getSelectedIndex()!=-1)
            {
                //System.out.println(k.getName() + " : " + k.getSelectedValue().toString());
                _dao.setSelected(k.getName(), k.getSelectedValue().toString());
            }
            //TODO: SEND TO DAO
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
