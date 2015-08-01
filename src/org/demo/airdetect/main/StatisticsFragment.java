package org.demo.airdetect.main;

import java.util.ArrayList;
import java.util.List;

import com.dexafree.materialList.view.MaterialListView;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

public class StatisticsFragment extends android.support.v4.app.Fragment {

	public static final String EXTRA_ARG = "extra.arg";
	private static final String LOG_TAG = "StatisticsFragment";	
	private static StatisticsFragment singleton = null;
	private static final int XAXIS_LABEL_TYPE_DAY = 1;
	private static final int XAXIS_LABEL_TYPE_WEEK = 2;
	private static final int XAXIS_LABEL_TYPE_MONTH = 3;
	//local data
	private static final String[] WEEK = new String[]{"Mon","Tue", "Wed", "Thu","Fri","Sat","Sun"};
//	private BarData data;
	//widgets
//	private Button btn_day;
//	private Button btn_week;
//	private Button btn_month;
//	private BarChart bc_statistics;
	private ListView mListView;
//	private ChartListAdapter mAdapter;
	private LineChartListAdapter mAdapter;
	//for demo purpose
//	private List<BarData> list_day;
//	private List<BarData> list_week;
//	private List<BarData> list_month;
	private List<LineData> list_day;
	private List<LineData> list_week;
	private List<LineData> list_month;
	private View rootView;
//	public static StatisticsFragment getInstance(){
//		if(singleton == null ){
//			singleton = new StatisticsFragment();			
//		}
		
//		return singleton;
//	}
			
	public StatisticsFragment(){
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		if(rootView == null){
			rootView = inflater.inflate(R.layout.fragment_statistics, container, false);
//			btn_day = (Button) rootView.findViewById(R.id.btn_day);
//			btn_week = (Button) rootView.findViewById(R.id.btn_week);
//			btn_month = (Button) rootView.findViewById(R.id.btn_month);
//			bc_statistics = (BarChart) rootView.findViewById(R.id.bc_statistics);
			mListView = (ListView) rootView.findViewById(R.id.lv_charts);
			
			
//			btn_day.setOnClickListener(btnListener);
//			btn_week.setOnClickListener(btnListener);
//			btn_month.setOnClickListener(btnListener);
//			
//			btn_day.setBackgroundColor(Color.rgb(217, 80, 138));
//			btn_day.setTextColor(getResources().getColor(R.color.white));
//			btn_week.setTextColor(getResources().getColor(android.R.color.secondary_text_dark));
//			btn_week.setBackgroundResource(R.color.transparent);
//			btn_month.setTextColor(getResources().getColor(android.R.color.secondary_text_dark));
//			btn_month.setBackgroundResource(R.color.transparent);
			//demo
//			BarData d1 = generateData("5月1日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
//			BarData d2 = generateData("5月2日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
//			BarData d3 = generateData("5月3日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
//			BarData d4 = generateData("5月4日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
//			BarData d5 = generateData("5月5日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));Color.rgb(192, 255, 140), Color.rgb(255, 247, 140)
//			LineData d1 = generateDataLine("5月1日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY), Color.rgb(192, 255, 140));
//			LineData d2 = generateDataLine("5月2日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY), Color.rgb(255, 247, 140));
//			LineData d3 = generateDataLine("5月3日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY), Color.rgb(192, 255, 140));
//			LineData d4 = generateDataLine("5月4日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY), Color.rgb(255, 247, 140));
//			LineData d5 = generateDataLine("5月5日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY), Color.rgb(192, 255, 140));
//			
////			list_day  = new ArrayList<BarData>();
//			list_day = new ArrayList<LineData>();
//			list_day.add(d5);
//			list_day.add(d4);
//			list_day.add(d3);
//			list_day.add(d2);
//			list_day.add(d1);
			
//			BarData w1 = generateData("5月第1周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK));
//			BarData w2 = generateData("5月第2周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK));
//			BarData w3 = generateData("5月第3周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK));
//			list_week = new ArrayList<BarData>();
//			LineData w1 = generateDataLine("5月第1周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK), Color.rgb(192, 255, 140));
//			LineData w2 = generateDataLine("5月第2周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK), Color.rgb(255, 247, 140));
//			LineData w3 = generateDataLine("5月第3周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK), Color.rgb(192, 255, 140));
//			list_week = new ArrayList<LineData>();
//			list_week.add(w3);
//			list_week.add(w2);
//			list_week.add(w1);
			
//			BarData m1 = generateData("2015年5月", 31, 100, getXLabels(XAXIS_LABEL_TYPE_MONTH));
//			list_month = new ArrayList<BarData>();
//			list_month.add(m1);
//			LineData m1 = generateDataLine("2015年5月", 31, 100, getXLabels(XAXIS_LABEL_TYPE_MONTH), Color.rgb(192, 255, 140));
//			list_month = new ArrayList<LineData>();
//			list_month.add(m1);
//			mAdapter = new ChartListAdapter(StatisticsFragment.this.getActivity().getApplicationContext(), list_day);
			
			int type = getArguments().getInt(EXTRA_ARG);
			switch(type){
			case 0:
				LineData d1 = generateDataLine("5月1日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY), Color.rgb(192, 255, 140));
				LineData d2 = generateDataLine("5月2日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY), Color.rgb(255, 247, 140));
				LineData d3 = generateDataLine("5月3日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY), Color.rgb(192, 255, 140));
				LineData d4 = generateDataLine("5月4日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY), Color.rgb(255, 247, 140));
				LineData d5 = generateDataLine("5月5日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY), Color.rgb(192, 255, 140));
				
//				list_day  = new ArrayList<BarData>();
				list_day = new ArrayList<LineData>();
				list_day.add(d5);
				list_day.add(d4);
				list_day.add(d3);
				list_day.add(d2);
				list_day.add(d1);
				mAdapter = new LineChartListAdapter(StatisticsFragment.this.getActivity().getApplicationContext(), list_day);
				
				break;
			case 1:
				LineData w1 = generateDataLine("5月第1周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK), Color.rgb(192, 255, 140));
				LineData w2 = generateDataLine("5月第2周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK), Color.rgb(255, 247, 140));
				LineData w3 = generateDataLine("5月第3周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK), Color.rgb(192, 255, 140));
				list_week = new ArrayList<LineData>();
				list_week.add(w3);
				list_week.add(w2);
				list_week.add(w1);
				mAdapter = new LineChartListAdapter(StatisticsFragment.this.getActivity().getApplicationContext(), list_week);
				break;
			case 2:
				LineData m1 = generateDataLine("2015年5月", 31, 100, getXLabels(XAXIS_LABEL_TYPE_MONTH), Color.rgb(192, 255, 140));
				list_month = new ArrayList<LineData>();
				list_month.add(m1);
				mAdapter = new LineChartListAdapter(StatisticsFragment.this.getActivity().getApplicationContext(), list_month);
				break;
			}
			mListView.setAdapter(mAdapter);
			
//			generateDemoData();
//		     XAxis xAxis = bc_statistics.getXAxis();
//	         xAxis.setPosition(XAxisPosition.BOTTOM);
//	         xAxis.setDrawGridLines(false);
//	         
//	         
//	         YAxis leftAxis = bc_statistics.getAxisLeft();
//	         leftAxis.setLabelCount(5);
//	         leftAxis.setSpaceTop(15f);
//	         data = generateData("Data of Day", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
	// //        bc_statistics.setData(data);
		}
		
		Log.d(LOG_TAG, "onCreateView is called");
		return rootView;
	}
	
	/**
	 * for demo purpose
	 */
//	private void generateDemoData(){
//		//for demo purpose
//				new Thread(new Runnable(){
//
//					@Override
//					public void run() {
//						// TODO Auto-generated method stub
//						BarData d1 = generateData("5月1日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
//						BarData d2 = generateData("5月2日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
//						BarData d3 = generateData("5月3日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
//						BarData d4 = generateData("5月4日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
//						BarData d5 = generateData("5月5日", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
//						list_day  = new ArrayList<BarData>();
//						list_day.add(d5);
//						list_day.add(d4);
//						list_day.add(d3);
//						list_day.add(d2);
//						list_day.add(d1);
//						
//						BarData w1 = generateData("5月第1周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK));
//						BarData w2 = generateData("5月第2周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK));
//						BarData w3 = generateData("5月第3周", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK));
//						list_week = new ArrayList<BarData>();
//						list_week.add(w3);
//						list_week.add(w2);
//						list_week.add(w1);
//						
//						BarData m1 = generateData("2015年5月", 31, 100, getXLabels(XAXIS_LABEL_TYPE_MONTH));
//						list_month = new ArrayList<BarData>();
//						list_month.add(m1);
//						mHandler.sendEmptyMessage(0);
//					}}).start();
//	}
	
	Handler mHandler=  new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			
			
		}
		
	};
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
//		bc_statistics.setData(data);
//		bc_statistics.animateY(500);
//		bc_statistics.setDescription("");
		Log.d(LOG_TAG, "onResume");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	/**
	 * event listeners
	 */	
//	private OnClickListener btnListener = new OnClickListener(){
//
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			switch(v.getId()){
//			case R.id.btn_day://Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120)
//				btn_day.setBackgroundColor(Color.rgb(217, 80, 138));
//				btn_day.setTextColor(getResources().getColor(R.color.white));
//				btn_week.setBackgroundResource(R.color.transparent);
//				btn_week.setTextColor(getResources().getColor(android.R.color.secondary_text_dark));
//				btn_month.setBackgroundResource(R.color.transparent);
//				btn_month.setTextColor(getResources().getColor(android.R.color.secondary_text_dark));
//				mAdapter.setList(list_day);
////				data = generateData("Data of Day", 24, 100, getXLabels(XAXIS_LABEL_TYPE_DAY));
//				break;
//			case R.id.btn_week:
//				btn_day.setBackgroundResource(R.color.transparent);
//				btn_week.setBackgroundColor(Color.rgb(254, 149, 7));
//				btn_week.setTextColor(getResources().getColor(R.color.white));				
//				btn_month.setBackgroundResource(R.color.transparent);
////				data = generateData("Data of Week", 7, 100, getXLabels(XAXIS_LABEL_TYPE_WEEK));
//				btn_month.setTextColor(getResources().getColor(android.R.color.secondary_text_dark));
//				btn_day.setTextColor(getResources().getColor(android.R.color.secondary_text_dark));
//				mAdapter.setList(list_week);
//				
//				break;
//			case R.id.btn_month:
//				btn_day.setBackgroundResource(R.color.transparent);
//				btn_week.setBackgroundResource(R.color.transparent);
//				btn_month.setBackgroundColor( Color.rgb(64, 89, 128));
//				btn_month.setTextColor(getResources().getColor(R.color.white));		
////				data = generateData("Data of Month", 31, 100, getXLabels(XAXIS_LABEL_TYPE_MONTH));
//				btn_day.setTextColor(getResources().getColor(android.R.color.secondary_text_dark));
//				btn_week.setTextColor(getResources().getColor(android.R.color.secondary_text_dark));
//				mAdapter.setList(list_month);
//				break;				
//			}
////			bc_statistics.setData(data);
////			bc_statistics.animateY(500);
//		}};

	/**
	 * Local methods
	 */
	
	
	private BarData generateData(String label, int xCount, int yMax, List<String> xList) {

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

        for (int i = 0; i < xCount; i++) {
            entries.add(new BarEntry((int) (Math.random() * yMax) , i));
        }

        BarDataSet d = new BarDataSet(entries, label);    
        d.setBarSpacePercent(2f);
        d.setColors(ColorTemplate.VORDIPLOM_COLORS);
        d.setBarShadowColor(Color.rgb(203, 203, 203));
        
        ArrayList<BarDataSet> sets = new ArrayList<BarDataSet>();
        sets.add(d);
        
        BarData cd = new BarData(xList, sets);
        return cd;
    }
	
	  private LineData generateDataLine(String label, int xCount, int yMax, List<String> xList, int color) {

	        ArrayList<Entry> entries = new ArrayList<Entry>();

	        for (int i = 0; i < xCount; i++) {
	            entries.add(new Entry((int) (Math.random() * yMax), i));
	        }

	        LineDataSet dataSet = new LineDataSet(entries, label);
	        dataSet.setLineWidth(2.5f);
	        dataSet.setCircleSize(3f);		        
	        dataSet.setCircleColor(Color.WHITE);
	        dataSet.setHighLightColor(Color.WHITE);
	        dataSet.setColor(Color.WHITE);
	        dataSet.setDrawValues(false);
	      
	        ArrayList<LineDataSet> sets = new ArrayList<LineDataSet>();
	        sets.add(dataSet);	       
	        LineData cd = new LineData(xList, sets);
	        return cd;
	    }

	
	private List<String> getXLabels( int type ){
		List<String> labels = new ArrayList<String>();
		switch(type){
		case XAXIS_LABEL_TYPE_DAY:{
			for(int i = 0; i < 24; i++){
				labels.add(String.valueOf(i));
			}
		}			
			break;
		case XAXIS_LABEL_TYPE_WEEK:
			for(int i = 0; i<7; i++){
				labels.add(WEEK[i]);
			}
			break;
		case XAXIS_LABEL_TYPE_MONTH:
			for(int i = 0; i < 31; i++){
				labels.add(String.valueOf(i));
			}
			break;
		}
		
		return labels;
	}
	
//	class ChartListAdapter extends ArrayAdapter<BarData>{
//		private List<BarData> dataList;
//		public ChartListAdapter(Context c, List<BarData> l){
//			super(c,0, l);
//			dataList = l;
//			
//		}
//		@Override
//		public int getCount() {
//			// TODO Auto-generated method stub
//			return dataList.size();
//		}
//
//		@Override
//		public BarData getItem(int position) {
//			// TODO Auto-generated method stub
//			return dataList.get(position);
//		}
//
//		@Override
//		public long getItemId(int position) {
//			// TODO Auto-generated method stub
//			return position;
//		}
//		
//		public void setList( List<BarData> l){
//			dataList = l;
//			notifyDataSetChanged();
//		}
//
//		@Override
//		public View getView(int position, View convertView, ViewGroup parent) {
//			// TODO Auto-generated method stub
//			  BarData data = dataList.get(position);
//
//	            ViewHolder holder = null;
//
//	            if (convertView == null) {
//
//	                holder = new ViewHolder();
//	                convertView = LayoutInflater.from(getContext()).inflate(
//	                        R.layout.list_item_chart, null);               	
//					
//					holder.chart = (BarChart) convertView.findViewById(R.id.bc_statistics);	
//	                convertView.setTag(holder);
//
//	            } else {
//	                holder = (ViewHolder) convertView.getTag();
//	            }
//
//	            // apply styling
//	            holder.chart.setDescription("");
//	            holder.chart.setDrawGridBackground(false);
//	            holder.chart.clearAnimation();
//	            holder.chart.destroyDrawingCache();	            
//	            data.setValueTextColor(Color.WHITE);
//
//	            XAxis xAxis = holder.chart.getXAxis();
//	            xAxis.setPosition(XAxisPosition.BOTTOM);	        
//	            xAxis.setDrawGridLines(false);
//	            xAxis.setAxisLineWidth(10.0f);
//	            xAxis.setTextSize(18f);
//	           
//	            YAxis leftAxis = holder.chart.getAxisLeft();	      
//	            leftAxis.setLabelCount(5);
//	            leftAxis.setSpaceTop(15f); 
//	            leftAxis.setTextColor(Color.WHITE);
//	            leftAxis.setAxisLineWidth(10.0f);
//	            leftAxis.setTextSize(18f);
//	            // set data
//	            holder.chart.setData(data);
//	            
//	            // do not forget to refresh the chart
//	            holder.chart.invalidate();
//	            holder.chart.animateY(700);
//			return convertView;
//		}
//		
//		 private class ViewHolder {
//
//	            BarChart chart;
//	        }
//		
//	}
	
	class LineChartListAdapter extends ArrayAdapter<LineData>{
		private List<LineData> dataList;
		private List<View> views;
		private int[] mColors = new int[] {
				Color.rgb(255, 102, 0), 
	            Color.rgb(240, 240, 30), 
	            Color.rgb(89, 199, 250),
	            Color.rgb(250, 104, 104)
	    };
		public LineChartListAdapter(Context c, List<LineData> l){
			super(c,0, l);
			dataList = l;
			
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return dataList.size();
		}

		@Override
		public LineData getItem(int position) {
			// TODO Auto-generated method stub
			return dataList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}
		
		public void setList( List<LineData> l){
			dataList = l;
			notifyDataSetChanged();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			  LineData data = dataList.get(position);

	            ViewHolder holder = null;

	            if (convertView == null) {

	                holder = new ViewHolder();
	                convertView = LayoutInflater.from(getContext()).inflate(
	                        R.layout.list_item_linechart, null);               	
					
					holder.chart = (LineChart) convertView.findViewById(R.id.bc_statistics);	
	                convertView.setTag(holder);	               
		            
	            } else {
	                holder = (ViewHolder) convertView.getTag();
	            }
	            // apply styling
	            holder.chart.setDescription("");
	            holder.chart.setDrawGridBackground(false);
	            holder.chart.setBackgroundColor(mColors[position%4]);
	            Legend l = holder.chart.getLegend();
	            l.setTextSize(12f);
	            l.setForm(LegendForm.CIRCLE);
	            l.setFormSize(6f);
	            l.setTextColor(Color.WHITE);	            
	            data.setValueTextColor(Color.WHITE);

	            XAxis xAxis = holder.chart.getXAxis();
	            xAxis.setPosition(XAxisPosition.BOTTOM);	        
	            xAxis.setDrawGridLines(false);
	            xAxis.setTextColor(Color.WHITE);
//	            xAxis.setAxisLineWidth(10.0f);
	            xAxis.setTextSize(12f);
	            
	            YAxis leftAxis = holder.chart.getAxisLeft();	      
	            leftAxis.setLabelCount(5);
	            leftAxis.setSpaceTop(15f); 
	            leftAxis.setTextColor(Color.WHITE);
//	            leftAxis.setAxisLineWidth(10.0f);
	            leftAxis.setTextSize(12f);
	            
	            YAxis rightAxis = holder.chart.getAxisRight();
	            rightAxis.setTextColor(Color.TRANSPARENT);
	            
	            
	            // set data
	            holder.chart.setData(data);
	            
	            // do not forget to refresh the chart
//	            holder.chart.invalidate();
	            holder.chart.animateX(700);
	          
	            
			return convertView;
		}
		
		 private class ViewHolder {

	            LineChart chart;
	        }
		
	}
}
