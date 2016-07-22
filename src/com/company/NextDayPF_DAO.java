package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by micro on 22.07.2016.
 */
public class NextDayPF_DAO {

    private HashMap<String, String> dao_fields = new HashMap<String, String>();
public NextDayPF_DAO(){

}
        public void mapData(String k, String v){

            dao_fields.put(k, v);

        }
}
