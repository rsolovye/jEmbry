package com.company.next;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by micro on 23.07.2016.
 */
public class PunctureDA0 {

    private final ArrayList<String[]> hmListValues;
    private final HashMap<String, String> hmSelectedValues;
    public PunctureDA0(){
        hmListValues = new ArrayList<String[]>() ; //new HashMap<String, String[]>();
        hmSelectedValues = new HashMap<String, String>();
        get_lists_from_db();
    }

    private void get_lists_from_db(){
        hmListValues.add(DB_TEMP.DOCTORS);
        hmListValues.add(DB_TEMP.DIAGNOSES);
        hmListValues.add(DB_TEMP.EMB);

    }

    public String[] getListValues(int index){
            return hmListValues.get(index);
    }

    public void setSelected(String key, String value){
        hmSelectedValues.put(key, value);

    }


    public int getListNumber() {
        return hmListValues.size();
    }
}
