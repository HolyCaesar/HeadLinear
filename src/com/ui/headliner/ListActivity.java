package com.ui.headliner;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
		
		newsList.setOnItemClickListener(listener)
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_list, menu);
		return true;
	}
}
