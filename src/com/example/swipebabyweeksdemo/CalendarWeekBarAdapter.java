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
	private int mSelectedItem=-1;
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
		if(mSelectedItem!=-1&&position==mSelectedItem){
			convertView.setBackgroundResource(R.drawable.progress_weekbg_select);
		}else{
			convertView.setBackgroundResource(R.drawable.progress_weekbg1_unselect);
		}
		viewHolder.tv_week.setText(""+(position+4));
		return convertView;
	}
	public void setSelectedItem(int position){
		this.mSelectedItem=position;
		notifyDataSetChanged();
	}
	public int getCurrentSelectedItem(){
		return this.mSelectedItem;
	}
	private class ViewHolder{
		private TextView tv_week;
	}
}
