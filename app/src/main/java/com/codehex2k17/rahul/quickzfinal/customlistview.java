package com.codehex2k17.rahul.quickzfinal;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by vidhant on 13/3/17.
 */

public class customlistview extends ArrayAdapter<String> {
    private String[] ids;
    private String[] Names;
    private String[] Prices;

    private Activity context;



    public customlistview(Activity context, String[] ids, String[] Names, String[] Prices) {
        super(context, R.layout.activity_cart, ids);
        this.context = context;
        this.ids = ids;
        this.Names = Names;
        this.Prices = Prices;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.listviewfile, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.textViewId);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewPrice = (TextView) listViewItem.findViewById(R.id.textViewPrice);


            textViewId.setText(ids[position]);
            textViewName.setText(Names[position]);
            textViewPrice.setText(Prices[position]);



        return listViewItem;
    }
}