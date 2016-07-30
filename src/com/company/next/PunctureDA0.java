package com.company.next;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by micro on 23.07.2016.
 */
public class PunctureDA0 {

    private final HashMap<String, <String[]> hmListValues;
    private final HashMap<String, String> hmSelectedValues;
    public PunctureDA0(){
        hmListValues = DB_TEMP.MAP; ; //new HashMap<String, String[]>();
        hmSelectedValues = new HashMap<String, String>();
        
    }

    public String[] getListValues(string pKey){
            return hmListValues.get(pKey);
    }

    public hashmap<String, String[]> getListValues(string[] pKeySet){

    HashMap<String, <String[]> tmp_Map = new HashMap<String, <String[]>();
for (String s: pKeySet)
{ 
if (tmp_Map.contains(s)) {
{
tmp_Map.put(getListValues(s))
}
}
            return tmp_Map;
    }



    public void setSelected(String key, String value){
        hmSelectedValues.put(key, value);
        System.out.println(this.getClass().getName() + " @ " + LocalTime.now() + " : (" + key +  ", " + value + ").");

    }


    public int getListNumber() {
        return hmListValues.size();
    }
}
