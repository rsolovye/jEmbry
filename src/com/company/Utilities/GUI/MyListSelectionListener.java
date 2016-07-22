package com.company.Utilities.GUI;



import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by micro on 22.07.2016.
 */
public    class MyListSelectionListener implements ListDataListener {
private final JList _owner ;
    public MyListSelectionListener(JList jl){
        super();
        _owner = jl;
    }


    @Override
    public void intervalAdded(ListDataEvent e) {

    }

    @Override
    public void intervalRemoved(ListDataEvent e) {

    }

    @Override
    public void contentsChanged(ListDataEvent e) {

    }
}
