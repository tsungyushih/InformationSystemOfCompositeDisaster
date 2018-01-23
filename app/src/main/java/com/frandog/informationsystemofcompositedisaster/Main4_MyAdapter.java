package com.frandog.informationsystemofcompositedisaster;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

/**
 * Created by Student on 2018/1/11.
 */

public class Main4_MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Main4Item> mylist;
    public Main4_MyAdapter(Context context, ArrayList<Main4Item>mylist)
    {
        this.context=context;
        this.mylist=mylist;
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.main4_myitem,null);
            viewHolder = new ViewHolder();
            viewHolder.lv = view.findViewById(R.id.listview);
            view.setTag(viewHolder);
        }
        else
        {
            viewHolder =(ViewHolder) view.getTag();
        }

        return view;
    }

    static class ViewHolder{
        ListView lv;
    }
}
