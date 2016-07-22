package com.company;import javax.swing.*;import javax.swing.border.TitledBorder;import javax.swing.event.ListSelectionEvent;import javax.swing.event.ListSelectionListener;import com.company.Utilities.GUI.CheckBoxList;import com.company.Utilities.GUI.MyListSelectionListener;import com.company.Utilities.GUI.Settings;import com.company.Utilities.GUI.Utils;import net.miginfocom.swing.MigLayout;import java.awt.*;import java.util.Enumeration;import java.util.HashMap;@SuppressWarnings("Since15")public class NextDayPF {    private JPanel master, master2;    public JPanel getPanel() {        return master2;    }    public NextDayPF() {        //UIManager.put("p.background", new Color(59, 123, 151));        try {            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {                    System.out.println(info.getName());                if ("Nimbus".equals(info.getName())) {                    UIManager.setLookAndFeel(info.getClassName());                    UIManager.put("control", new Color(255, 255, 255));                    break;                }            }        } catch (Exception e) {            // If Nimbus is not available, you can set the GUI to another look and feel.        }        this.master = new JPanel(new MigLayout(""));        master2 = new JPanel(new MigLayout("flowy", "", ""));        JPanel pDoc = Utils.getTitledPanel("Врач",                                            Utils.getList(Utils.DOCTORS, 12, 4, true),                                            TitledBorder.DEFAULT_JUSTIFICATION,                                            TitledBorder.DEFAULT_POSITION                                            );        JPanel dd = new JPanel(new MigLayout("flowy", "", ""));        JComponent omc_cb = Utils.getCB("ОМС",                                        pDoc.getSize().width,                                        22,                                        14,                                        true                                        );        dd.add(omc_cb, "top, gapleft 15");        dd.add(pDoc, "gapbottom 4, grow, push, ");        CheckBoxList diag_list =  new CheckBoxList();        diag_list.addCB(Utils.DIAGNOSES);        dd.add(Utils.getTitledPanel("Диагноз", diag_list, TitledBorder.CENTER, TitledBorder.CENTER), "center, grow, push");        master.add(patient_panel(), "");        master.add(dd, "top");        master.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true), "title"));        master.validate();                master2.add(master);        master2.add(gamete_panel());        master2.validate();    }    private JPanel patient_panel(){     JPanel panel = new JPanel(new MigLayout("debug 4000","",""));        panel.add(new JLabel(""), " h 30!, wrap");        panel.add(Utils.getTwoTF("Дата и Время", 7, 5), "top, split 7");        panel.add(Utils.getTF("№ протокола", 6), "top");        panel.add(Utils.getTF("Номер карты", 11), "pushx, growx, wrap");        panel.add(Utils.getTF("Примечания"), "pushx, growx, wrap");        panel.add(Utils.getTF("ФИО пациентки"), "split 3, pushx, growx ");        panel.add(Utils.getTF("ДР", 5));        panel.add(Utils.getTF("Код", 5), "wrap");        panel.add(Utils.getTF("ФИО пациентки"), "split 3, pushx, growx");        panel.add(Utils.getTF("ДР", 5));        panel.add(Utils.getTF("Код", 5), " sg a, wrap");        panel.validate();        return panel;    }          private JPanel gamete_panel(){        JPanel gamete_panel = new JPanel((new MigLayout("fillx, filly, ")));        gamete_panel.setBorder(BorderFactory.createTitledBorder("Источник Женских Гамет"));        final JList source_list = Utils.getList(Utils.BUTTON_GROUP_1);        source_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);        //source_list.addListSelectionListener(new MyListSelectionListener(source_list));        gamete_panel.add(Utils.getPanel(source_list), "center, grow, push");        gamete_panel.add( Utils.getList(Utils.FEM_EGG_STATE), "center, grow, push");        gamete_panel.validate();        return gamete_panel;    }   public static ButtonGroup getGroupOfButtons(String[] txt, String byDefault){      ButtonGroup group = new ButtonGroup();       for (String t : txt) {               group.add(new JRadioButton("txt", t.equals(byDefault)));           }       return group;    }}