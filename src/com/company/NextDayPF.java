package com.company;import javax.swing.*;import com.company.Utilities.GUI.Settings;import com.company.Utilities.GUI.Utils;import net.miginfocom.swing.MigLayout;import java.awt.*;public class NextDayPF {    private JPanel master;    public JPanel getPanel() {        return master;    }    public NextDayPF() {        this.master = new JPanel(new MigLayout("debug"));        master.setBackground(new Color(59, 123, 151));        master.add(patient_panel(), " wrap");        //master.add(gamete_panel());        master.validate();    }    private JPanel patient_panel(){        JCheckBox jc = new JCheckBox("");        jc.setBackground(Utils.BG_SUB_1);        jc.setFont(new Font("PT Serif Caption", Font.BOLD, 17));     JPanel panel = new JPanel(new MigLayout("debug","",""));     //JPanel gamete_source_panel;       // panel.add(Utils.getTitledPanel(jc), "gap 10:10");             // panel.add()        panel.add(Utils.getTitledPanel("Дата", new JTextField(7)), "split 7, sg a");        panel.add(Utils.getTitledPanel("Время", new JTextField(5)), "sg a");        panel.add(Utils.getTitledPanel("№ протокола", new JTextField(5)), "sg a");        panel.add(Utils.getTitledPanel("Карта №", new JTextField(5)), "pushx, growx");        panel.add(Utils.getTitledPanel("OMC", jc));        panel.add(Utils.getTitledPanel(new JLabel("brrr")),"span 2, growx, wrap");        //panel.add(Utils.getTitledPanel("Врач", Utils.getList(Utils.DOCTORS, 12, 4, true)), "spany 2, sg b");        //panel.add(Utils.getTitledPanel("Диагноз", Utils.getMultiComboPanel(Utils.DIAGNOSES, 2)), "spany 2, grow, sg b, wrap");        panel.add(Utils.getTitledPanel("Примечания", Utils.getTextFieldPanel(35, new MigLayout("fillx"))), "split 7, spanx 5, growx");        panel.add(new Panel(), "spanx 2, growx, wrap");        panel.add(gamete_panel(), "split 7, spanx 5");        panel.add(new JLabel(""), "spanx 2, growx, wrap");        panel.add(gamete_panel(), "split 7, spanx 5");        panel.add(new JLabel(""), "spanx 2, growx, wrap");        ;        panel.add(Utils.getTitledPanel("Hep:", Utils.makePaneledCheckBoxes(Utils.HEPATITIS)), "wrap 6, spany");//:validate        panel.setBackground(Utils.BG_SUB_1);        panel.validate();        return panel;    }          private JPanel gamete_panel(){        JPanel gamete_panel = new JPanel((new MigLayout("fillx, filly, debug 4000")));        gamete_panel.setBackground(Utils.BG_SUB_1);        gamete_panel.add(Utils.getTitledPanel("Ф.И.О.", Utils.getTextFieldPanel(35)));        gamete_panel.add(Utils.getTitledPanel("ДР", Utils.getTextFieldPanel(7)));        gamete_panel.add(Utils.getTitledPanel("Код",Utils.getTextFieldPanel(7)), "wrap");//        gamete_panel.add(Utils.getTitledPanel("ФИО Пацинета", Utils.getTextFieldPanel(35)));//        gamete_panel.add(Utils.getTitledPanel("ДР", Utils.getTextFieldPanel(7)));////        gamete_panel.add(Utils.getTitledPanel("Код",Utils.getTextFieldPanel(7)), "wrap");        gamete_panel.validate();        return gamete_panel;    }}