package com.company;import javax.swing.*;import com.company.Utilities.GUI.Settings;import com.company.Utilities.GUI.Utils;import net.miginfocom.swing.MigLayout;import java.awt.*;public class NextDayPF {    private JPanel master;    private JPanel patient_info_panel;    private JPanel gamete_source_panel;    public NextDayPF() {        this.master = new JPanel(new MigLayout());        setup_patient_info_panel();        setup_Gamete_source_panel();        master.setBackground(new Color(59, 123, 151));        master.add(patient_info_panel, "gapbottom 50, wrap");        master.add(gamete_source_panel);        master.validate();    }    private void setup_patient_info_panel(){        JCheckBox jc = new JCheckBox("OMC");        this.patient_info_panel = new JPanel(new MigLayout("fillx, filly"));        patient_info_panel.add(Utils.coatPanelBorder("", jc), "gap 10:10");        patient_info_panel.add(Utils.createPanelTextField("Карта №", 12), "spanx 2, gap 4");//:1        patient_info_panel.add(Utils.coatPanelBorder("Диагноз", checkbox_array(Settings.DIAGNOSES), " wrap 2"), "spany 2, grow");        patient_info_panel.add(Utils.coatPanelBorder("Врач", createList(Settings.DOCTORS, 12)), "spany 4, grow, wrap");        patient_info_panel.add(Utils.createPanelTextField("Дата", 7));        patient_info_panel.add(Utils.createPanelTextField("Время", 5));        patient_info_panel.add(Utils.createPanelTextField("№ протокола", 5), "wrap");        patient_info_panel.add(Utils.createPanelTextField("Примечания", 35), "gap 2, spanx 4, gap 1, wrap");        patient_info_panel.add(Utils.coatPanelBorder("Hep:", checkbox_array(Settings.HEPATITIS), "wrap 6"), "spanx 4");//:validate            jc.setBackground(Settings.default_background);        jc.setFont(new Font("PT Serif Caption", Font.BOLD, 17));        patient_info_panel.setBackground(Settings.default_background);        patient_info_panel.validate();    }    private void setup_Gamete_source_panel(){        this.gamete_source_panel = new JPanel(new MigLayout("fillx, filly, debug 4000"));        this.gamete_source_panel.setBackground(patient_info_panel.getBackground());    }    private JPanel coatPanelBorder(String title, JComponent jc) {        JPanel pc = new JPanel(new MigLayout(""));        pc.setName(title + "_panel");        pc.add(jc);        pc.setBorder(BorderFactory.createTitledBorder(Settings.simple_line_border, title));        pc.setBackground(Settings.default_background);        pc.validate();        return pc;    }    private JPanel[] checkbox_array(String[] titles) {        JCheckBox[] jcb = new JCheckBox[titles.length];        JPanel[] jcp = new JPanel[titles.length];        for (int i = 0; i < titles.length; i++) {            jcb[i] = new JCheckBox(titles[i]);            jcb[i].setName("checkbox_" + titles + "_" + i);            jcb[i].setBackground(Settings.default_background);            jcp[i] = new JPanel(new MigLayout("insets 0"));            jcp[i].add(jcb[i]);            jcp[i].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Settings.default_background));        }        return jcp;    }    private JPanel coatPanelBorder(String title, JComponent[] jc, String mig) {        JPanel pc = new JPanel(new MigLayout(mig));        pc.setName(title + "_panel");        for (int i = 0; i < jc.length; i++) {            pc.add(jc[i]);        }        pc.setBorder(BorderFactory.createTitledBorder(Settings.simple_line_border, title));        pc.setBackground(Settings.default_background);        pc.validate();        return pc;    }    private JPanel createPanelTextField(String title, int columns) {        JTextField tf = new JTextField(columns);        JPanel pan = new JPanel();        if (title.length() > 0) {            pan.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Settings.default_border_color), title));        }        tf.setBackground(new Color(250, 250, 250));        tf.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));        pan.setBackground(Settings.default_background);        pan.add(tf);        pan.validate();        return pan;    }    private ListCellRenderer get_list_renderer(int font_size) {        final int font_s = font_size;        ListCellRenderer renderer = new ListCellRenderer() {            @Override            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {                JLabel label = new JLabel();                JPanel k = new JPanel(new MigLayout("", ""));                label.setText(value.toString());                if (isSelected) {                    k.setBackground(new Color(216, 218, 216));                    label.setForeground(Color.BLACK);                    label.setFont(new Font("PT Sans", Font.BOLD, font_s));                    k.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(1, 3, 1, 1, Color.black), ""));                } else {                    k.setBackground(Color.WHITE);//.LIGHT_GRAY);                    label.setForeground(Color.black);//new Color(0,0,0));                    label.setFont(new Font("PT Sans", Font.BOLD, font_s));                    k.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.lightGray));//.createEmptyBorder(0,5,0,0));                }                k.add(label, "");                return k;            }        };        return renderer;    }    private ListCellRenderer get_combo_renderer() {        ListCellRenderer renderer = new ListCellRenderer() {            @Override            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {                JLabel label = new JLabel();                JPanel k = new JPanel(new MigLayout("", ""));                label.setText(value.toString());                label.setForeground(Color.BLACK);                if (isSelected) {                    k.setBackground(Color.white);                    label.setForeground(Color.BLACK);                    label.setFont(new Font("PT Sans", Font.BOLD, 12));                } else {                    k.setBackground(Color.WHITE);                    label.setFont(new Font("PT Sans", Font.PLAIN, 12));                }                k.add(label, "");                return k;            }        };        return renderer;    }    public JList createList(String[] list_array, int font_size) {        JList rList = new JList(list_array);        rList.setCellRenderer(get_list_renderer(font_size));        rList.setVisibleRowCount(4);        rList.setAutoscrolls(true);        return rList;    }    public JPanel getPanel() {        return this.master;    }    private JPanel createComboPanel(String[] str_arr, int count, String str_flow) {        JPanel p_JB = new JPanel(new MigLayout("", "", "30"));        int x = 0;        while (x < count) {            JComboBox jbox = new JComboBox(str_arr);            jbox.setName("combo_" + x);            jbox.setRenderer(get_combo_renderer());            p_JB.add(jbox, "wrap");            x++;        }        p_JB.setBackground(Settings.default_background);        p_JB.validate();        return p_JB;    }    private JLabel createLabel(String text) {        JLabel label = new JLabel(text);        label.setFont(new Font("PT Sans", Font.BOLD, 13));        label.setVerticalAlignment(SwingUtilities.CENTER);        return label;    }    private JTextField createTextField(String title, int columns) {        JTextField tf = new JTextField(columns);        if (title.length() > 0) {            tf.setBorder(BorderFactory.createTitledBorder(title));        }        return tf;    }}