package com.open.design.observer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.open.design.R;
import com.open.design.ui.ClassBean;

import java.util.List;

/**
 * ****************************************************************************************************************************************************************************
 *
 * @author :guangjing.feng
 * @createTime: 2018/9/3.
 * @version:1.1.0
 * @modifyTime:
 * @modifyAuthor:
 * @description: *****************************************************************************************************************************************************************************
 **/
public class ObserverListAdapter extends BaseAdapter {
    private Context mContext;
    private List<WeatherObserver> list;

    public ObserverListAdapter(Context mContext, List<WeatherObserver> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_class_list,null);
        TextView button = view.findViewById(R.id.btnlist);
        WeatherObserver bean = (WeatherObserver) getItem(position);
        button.setText(bean.getId()+""+bean.getChanged());
        return view;
    }
}
