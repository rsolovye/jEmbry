package com.company.next;

import com.company.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bobsol on 06.08.16.
 */

public class SessionController {
    SessionModel _model;
    SessionView _view;
    private final ControllerListener _controllerListener;

 public SessionController (SessionModel pModel, SessionView pView ){
     _model = pModel;
     _view = pView;

     _controllerListener = new ControllerListener();
     _view.setActionListener(_controllerListener);


 }

    public void updateSessionView() {
        //match views fields with models dat

        _view.createGUI();
        Main.APP_FRAME.setJMenuBar(_view.getMenuBar());
    }

    class ControllerListener implements ActionListener{

     @Override
     public void actionPerformed(ActionEvent e) {
         System.out.println(e.getSource().toString());
     }
 }
}
