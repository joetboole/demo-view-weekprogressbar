package com.example.swipebabyweeksdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		private HorizontalListView lv_weekBar;
		private CalendarWeekBarAdapter mCalendarWeekBarAdapter;
		private Button btn_previous,btn_next;
		public PlaceholderFragment() {
		}
		@Override
		public void onAttach(Activity activity) {
			mCalendarWeekBarAdapter=new CalendarWeekBarAdapter(activity);
			super.onAttach(activity);
		}
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			lv_weekBar=(HorizontalListView)rootView.findViewById(R.id.lv_calendar_weekbar);
			lv_weekBar.setAdapter(mCalendarWeekBarAdapter);
//			getGridViewWidthBasedOnChildren(lv_weekBar,1);
			lv_weekBar.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					mCalendarWeekBarAdapter.setSelectedItem(position);
//					parent.setSelection(position+3);
//					mCalendarWeekBarAdapter.notifyDataSetChanged();
				}
				
			});
			btn_previous=(Button)rootView.findViewById(R.id.btn_previous);
			btn_next=(Button)rootView.findViewById(R.id.btn_next);
			btn_previous.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					int position=lv_weekBar.getFirstVisiblePosition();
					Log.e("debug", "select position"+position);
//					if(position>1){
						Log.e("debug", "bar@@@--position:"+(position-1));
						lv_weekBar.setSelection(position-4);
						mCalendarWeekBarAdapter.notifyDataSetInvalidated();
//					}
				}
			});
			
			btn_next.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					int position=lv_weekBar.getLastVisiblePosition();
					Log.e("debug", "select position"+position);
//					if(position<lv_weekBar.getCount()-1){
						Log.e("debug", "bar@@@++position:"+(position+1));
						lv_weekBar.setSelection(position+4);
						mCalendarWeekBarAdapter.notifyDataSetInvalidated();
//					}
					
				}
			});
			return rootView;
		}
	}

}
