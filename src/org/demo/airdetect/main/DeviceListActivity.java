package org.demo.airdetect.main;

import java.util.ArrayList;
import java.util.List;

import org.demo.airdetect.models.HCHCDevice;

import com.dexafree.materialList.cards.SimpleCard;
import com.dexafree.materialList.cards.SmallImageCard;
import com.dexafree.materialList.model.CardItemView;
import com.dexafree.materialList.view.MaterialListView;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DeviceListActivity extends Activity {
//constants
	private static final String LOG_TAG = "DeviceListActivity";
	
	//widgets
//	private ListView lv_devices;
	private MaterialListView lv_devices;
	//local members
	private BaseAdapter mAdapter;
	//demo data
//	private String[] demo_devices = new String[]{"模拟设备001"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//set up title on action bar
		ActionBar actionBar = getActionBar();
		actionBar.setTitle(R.string.devicelist_title);	
		
		setContentView(R.layout.activity_devicelist);
		initWidgets();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater  inflater =  getMenuInflater();
		inflater.inflate(R.menu.dl_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.action_add:
			Intent i = new Intent(this, ScanActivity.class);
			startActivity(i);
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	/*
	 * local methods
	 */
	private void initWidgets(){
		lv_devices = (MaterialListView) findViewById(R.id.lv_devices);
		//for demo purpose
		HCHCDevice d1 = new HCHCDevice("客厅的检测仪", "123456574", "192.168.1.101", 12314, 3233);
		HCHCDevice d2 = new HCHCDevice("卧室的检测仪", "1234574", "192.168.1.102", 12314, 3233);
		SimpleCard card1 = new SmallImageCard(this);
		card1.setTitle(d1.getName());
		card1.setDescription("IP地址：" + d1.getIP());
		card1.setDrawable(R.drawable.icon_device);		
		
		SimpleCard card2 = new SmallImageCard(this);
		card2.setTitle(d2.getName());
		card2.setDescription("IP地址：" + d2.getIP());
		card2.setDrawable(R.drawable.icon_device);	
		lv_devices.add(card1);		
		lv_devices.add(card2);
		
//		List<HCHCDevice> list = new ArrayList<HCHCDevice>();
//		list.add(d1);
//		list.add(d2);
//		mAdapter = new DeviceAdapter(list);
//		lv_devices.setAdapter(mAdapter);
		lv_devices.addOnItemTouchListener(new com.dexafree.materialList.controller.RecyclerItemClickListener.OnItemClickListener() {
			
			@Override
			public void onItemLongClick(CardItemView view, int position) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onItemClick(CardItemView view, int position) {
				// TODO Auto-generated method stub
				Intent i = new Intent(DeviceListActivity.this, MainActivity.class);
				startActivity(i);
			}
		});
//		lv_devices.setOnItemClickListener(new OnItemClickListener() {
//
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view,
//					int position, long id) {
//				// TODO Auto-generated method stub
//				//demo data
////				String deviceName =  (String) mAdapter.getItem(position);
////				String deviceID = "123456789";
////				String IP = "192.168.1.123";
////				int TCPPort = 1234;
////				int UDPPort = 5678;
//
//				
////				i.putExtra(MainActivity.EXTRA_DEVICE_NAME, deviceName);
////				i.putExtra(MainActivity.EXTRA_DEVICE_ID, deviceID);
////				i.putExtra(MainActivity.EXTRA_DEVICE_IP, IP);
////				i.putExtra(MainActivity.EXTRA_DEVICE_TCPPORT, TCPPort);
////				i.putExtra(MainActivity.EXTRA_DEVICE_UDPPORT, UDPPort);
//				
////				finish();
//			}
//		
//		});
		
	}
	
	class DeviceAdapter extends BaseAdapter{
		private List<HCHCDevice> mList;
		public DeviceAdapter(List<HCHCDevice> l){
			mList = l;
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mList.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return mList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			HCHCDevice device = mList.get(position);
			ViewHolder holder = null;
			if(convertView == null){
				convertView  = LayoutInflater.from(DeviceListActivity.this).inflate(R.layout.list_item_device, null);
				holder = new ViewHolder();
				holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
				holder.tv_ip = (TextView) convertView.findViewById(R.id.tv_ip);
				convertView.setTag(holder);
			}else{
				holder = (ViewHolder) convertView.getTag();
			}
			holder.tv_name.setText(device.getName());
			holder.tv_ip.setText(device.getIP());
			return convertView;
		}
		
		class ViewHolder{
			public TextView tv_name;
			public TextView tv_ip;
		}
		
	}
	
}
