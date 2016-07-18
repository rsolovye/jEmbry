package com.company;import javax.swing.*;import com.company.Utilities.GUI.Settings;import com.company.Utilities.GUI.Utils;import net.miginfocom.swing.MigLayout;import java.awt.*;public class NextDayPF {    private JPanel master;    private JPanel patient_info_panel;    private JPanel gamete_source_panel;    public NextDayPF() {        this.master = new JPanel(new MigLayout());        setup_patient_info_panel();        setup_Gamete_source_panel();        master.setBackground(new Color(59, 123, 151));        master.add(patient_info_panel, "gapbottom 50, wrap");        master.add(gamete_source_panel);        master.validate();    }    private void setup_patient_info_panel(){        JCheckBox jc = new JCheckBox("OMC");        this.patient_info_panel = new JPanel(new MigLayout("fillx, filly"));        patient_info_panel.add(Utils.coatPanelBorder("", jc), "gap 10:10");        patient_info_panel.add(Utils.createPanelTextField("Карта №", 12), "spanx 2, gap 4");//:1        patient_info_panel.add(Utils.coatPanelBorder("Диагноз", Utils.checkbox_array(Settings.DIAGNOSES), " wrap 2"), "spany 2, grow");        patient_info_panel.add(Utils.coatPanelBorder("Врач", Utils.createList(Settings.DOCTORS, 12)), "spany 4, grow, wrap");        patient_info_panel.add(Utils.createPanelTextField("Дата", 7));        patient_info_panel.add(Utils.createPanelTextField("Время", 5));        patient_info_panel.add(Utils.createPanelTextField("№ протокола", 5), "wrap");        patient_info_panel.add(Utils.createPanelTextField("Примечания", 35), "gap 2, spanx 4, gap 1, wrap");        patient_info_panel.add(Utils.coatPanelBorder("Hep:", Utils.checkbox_array(Settings.HEPATITIS), "wrap 6"), "spanx 4");//:validate            jc.setBackground(Settings.default_background);        jc.setFont(new Font("PT Serif Caption", Font.BOLD, 17));        patient_info_panel.setBackground(Settings.default_background);        patient_info_panel.validate();    }    private void setup_Gamete_source_panel(){        this.gamete_source_panel = new JPanel(new MigLayout("fillx, filly, debug 4000"));        this.gamete_source_panel.setBackground(patient_info_panel.getBackground());    }}