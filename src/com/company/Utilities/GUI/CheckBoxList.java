package com.company.Utilities.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxList extends JList {

    DefaultListModel listModel = new DefaultListModel();

    public CheckBoxList() {

        setModel(listModel);

        setCellRenderer(new MyCellRenderer());
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int index = locationToIndex(e.getPoint());
                if (index != -1) {
                    MyDataClass data = ((MyDataClass)listModel.get(index));
                    data.setSelected(!data.isSelected);
                    listModel.set(index, data);
                }
            }
        });
    }
public void addCB(boolean b, String txt){
    listModel.addElement(new MyDataClass(b, txt));

}

    public void addCB(String[] txt){
        for (String c:txt) {
            listModel.addElement(new MyDataClass(false, c));
            }
    }
    protected class MyCellRenderer implements ListCellRenderer {

        private JCheckBox checkBox = new JCheckBox();


        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            checkBox.setBackground(isSelected ? getSelectionBackground() : getBackground());
            checkBox.setForeground(isSelected ? getSelectionForeground() : getForeground());
            checkBox.setFont(getFont());
            checkBox.setText(((MyDataClass)value).getTextToDisplay());
            checkBox.setSelected(((MyDataClass)value).isSelected());

            return checkBox;
        }
    }




    private class MyDataClass {
        private boolean isSelected;
        private String textToDisplay;

        private MyDataClass(boolean selected, String textToDisplay) {
            isSelected = selected;
            this.textToDisplay = textToDisplay;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public void setSelected(boolean selected) {
            isSelected = selected;
        }

        public String getTextToDisplay() {
            return textToDisplay;
        }

        public void setTextToDisplay(String textToDisplay) {
            this.textToDisplay = textToDisplay;
        }
    }
}