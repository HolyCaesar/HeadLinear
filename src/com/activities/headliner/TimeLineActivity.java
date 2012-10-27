package com.activities.headliner;

import com.entities.headliner.TimeLine;
import com.ui.headliner.R;
import com.ui.headliner.R.layout;
import com.ui.headliner.R.menu;
import com.utility.headliner.TimeLineAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TimeLineActivity extends Activity {

    private ListView mListView;
    private TimeLineAdapter mTLAdapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.print( "Ruan JB shi SB\n" );
        setContentView(R.layout.timeline_listview_container);
        
        // The contents that will be displayed in listview
		TimeLine timeline_data[] = new TimeLine[]
		{
			new TimeLine(R.drawable.ruanjb, "Cloudy"),
		    new TimeLine(R.drawable.ruanjb, "Showers"),
		    new TimeLine(R.drawable.ruanjb, "Snow"),
		    new TimeLine(R.drawable.ruanjb, "Storm"),
		    new TimeLine(R.drawable.ruanjb, "Sunny")
		};
		
		TimeLineAdapter adapter = new TimeLineAdapter( this, R.layout.timeline_listview_content, timeline_data );
		mListView = (ListView)findViewById( R.id.ListContainer );
		
		mListView.setAdapter( adapter );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_time_line, menu);
        return true;
    }
}
