package com.codehex2k17.rahul.quickzfinal;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.stream.IntStream;

/**
 * Created by vidhant on 12/3/17.
 */

public class parsejson {
    public static String[] ids;
    public static String[] Names;
    public static String[] Finalprices;
    public static String[] Finalprices1;
    public static double Finalprice3;

    private JSONArray cart=null;
    private String json;
    double price1;
    double price;
    double sum=0;
    public parsejson(String json){
        this.json=json;
    }
    protected void parsejson(){
        JSONObject jsonObject=null;
        try{
            jsonObject=new JSONObject(json);
            cart=jsonObject.getJSONArray(Config.JSON_ARRAYCART);
            ids= new String[cart.length()];
            Names= new String[cart.length()];
            Finalprices=new String[cart.length()];
            Finalprices1=new String[cart.length()];
            for (int j=0;j<cart.length();j++) {
                JSONObject jo1 = cart.getJSONObject(j);

                Finalprices1[j] = jo1.getString(Config.KEY_PRICE2);
                price1 = Double.parseDouble(parsejson.Finalprices1[j]);

                sum = sum + price1;
            }
            Finalprice3=sum;

            for (int i=0 ; i<cart.length() ; i++) {
                JSONObject jo = cart.getJSONObject(i);
                ids[i] = jo.getString(Config.KEY_ID);
                Names[i] = jo.getString(Config.KEY_NAME2);
                Finalprices[i] = jo.getString(Config.KEY_PRICE2);



            }



        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
