package com.company.next;

import com.company.Main;

/**
 * Created by bobsol on 06.08.16.
 */
public class SessionModel {


private String User_Name;
    /**
     *  Controller send data here collectrd from the view
     */
    PunctureView pView;
    private String user;
    public SessionModel(){



    }

    public void setUser(String s){ this.user = s;
    pView = new PunctureView();
        Main.APP_FRAME.setContentPane(pView.getPanel());
        Main.APP_FRAME.pack();
        Main.APP_FRAME.revalidate();

        Main.APP_FRAME.repaint();
        Main.APP_FRAME.validate();
    }

    public String toString(){
        return "System model: says hi";

    }


}
