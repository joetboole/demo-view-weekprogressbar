package com.example.swipebabyweeksdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CalendarWeekBarAdapter extends BaseAdapter {
	private int mCount=39;
	private LayoutInflater mInflater;
	public CalendarWeekBarAdapter(Context context) {
		mInflater=LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return mCount;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder=null;
		if(convertView==null){
			convertView=mInflater.inflate(R.layout.item_calendar_bar, null);
			viewHolder=new ViewHolder();
			viewHolder.tv_week=(TextView) convertView.findViewById(R.id.tv_calendar_weekbar);
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		viewHolder.tv_week.setText(""+(position+4));
		return convertView;
	}
	private class ViewHolder{
		private TextView tv_week;
	}
}