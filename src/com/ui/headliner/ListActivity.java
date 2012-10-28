package com.ui.headliner;

import java.util.ArrayList;
import java.util.HashMap;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ListActivity extends CustomerActivity {

	SimpleAdapter listItemAdapter;
	ArrayList<HashMap<String, Object>> listItem;
	ListView newsList;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);

		listItem = new ArrayList<HashMap<String, Object>>();
		listItemAdapter = new SimpleAdapter(this, listItem, R.layout.listitem,
				new String[] { "Title", "Abstract", "Share" }, new int[] {
						R.id.ItemTitle, R.id.ItemAbstract, R.id.ItemShare });
		newsList = (ListView) findViewById(R.id.news_list);
		newsList.setAdapter(listItemAdapter);

		String Abstract = "abstract";
		for (int i = 0; i < 5; i++) {
			Abstract += Abstract;
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("Title", "title " + i);
			map.put("Abstract", Abstract);
			map.put("Share", "Share");
			listItem.add(map);
		}
		listItemAdapter.notifyDataSetChanged();

		newsList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				// TODO Auto-generated method stub
				HashMap<String, Object> map = listItem.get(position);
				Log.d("list", (String) map.get("Abstract"));
				Uri webpage = Uri.parse("http://www.android.com");
				Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
				startActivity(webIntent);
			}
		});
		
		registerForContextMenu(newsList);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
	                                ContextMenuInfo menuInfo) {
	    super.onCreateContextMenu(menu, v, menuInfo);
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.context_menu, menu);
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
	    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
	    switch (item.getItemId()) {
	        case R.id.facebook: {
	            Log.d("contextMenu", info.id + "");
	            Toast toast = Toast.makeText(getApplicationContext(), "share in facebook",
	            	     Toast.LENGTH_SHORT);
	            toast.setGravity(Gravity.CENTER, 0, 0);
	            toast.show();
	            return true;
	        }
	        case R.id.twitter: {
	        	Log.d("contextMenu", info.id + "");
	        	Toast toast = Toast.makeText(getApplicationContext(), "share in twitter",
	        		     Toast.LENGTH_SHORT);
	        	toast.setGravity(Gravity.CENTER, 0, 0);
	        	toast.show();
	            return true;
	        }
	        case R.id.context_favorite: {
	        	Log.d("contextMenu", info.id + "");
	        	Toast toast = Toast.makeText(getApplicationContext(), "put it in favorite",
	        		     Toast.LENGTH_SHORT);
	        	toast.setGravity(Gravity.CENTER, 0, 0);
	        	toast.show();
	            return true;
	        }
	        default:
	            return super.onContextItemSelected(item);
	    }
	}

}
