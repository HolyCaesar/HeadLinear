package com.activities.headliner;

import com.ui.headliner.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
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

	/**
	 * @param args
	 */
	private TimeLineListAdapter mListAdapter;
	ListView mTimeLineList;

	@Override
	public void onCreate( Bundle savedInstanceState ) {
		super.onCreate( savedInstanceState );
		
		setContentView(  R.layout.timeline_listview_container );
		
		//Initialize listview
		mTimeLineList = (ListView)findViewById(R.id.ListContainer);
		mListAdapter = new TimeLineListAdapter( this );
		mTimeLineList.setAdapter( mListAdapter );
		
		mTimeLineList.setOnItemClickListener( new AdapterView.OnItemClickListener(){
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id ) {
					// TODO Auto-generated method stub
					Toast.makeText( getApplicationContext(), ( (TextView)view ).getText(), Toast.LENGTH_SHORT ).show();
				}
			});
	}

	/**
	 * This class implement specific list view adapter's actions
	 *
	 * @date July 06, 2011
	 * @author Daniel Deng
	 */
	public static class TimeLineListAdapter extends BaseAdapter
		   implements Filterable{
	
		//mInflater will easier
		private LayoutInflater mInflater;
		private Context mContext;
		
		public TimeLineListAdapter( Context context ) {
			// Cache the LayoutInflate to avoid asking for a new one each time.
			mInflater = LayoutInflater.from(context);
			mContext = context;
		}
		
		public int getCount() {
			// TODO Auto-generated method stub
			return 0;
		}
	
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}
	
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}
	 
		public Filter getFilter() {
			// TODO Auto-generated method stub
			return null;
		}
		
		/**
		 * This class responsible for define which type of view should be held
		 *
		 * @date July 06, 2011
		 * @author Daniel Deng
		 */
		static class ViewHolder{
			public TextView mTextView;
		}
		
		/**
		* Make a view to hold each row.
		*
		* @see android.widget.ListAdapter#getView(int, android.view.View,
		*      android.view.ViewGroup)
		*/
		public View getView( int position, View convertView, ViewGroup parent ){
			// A ViewHolder keeps references to children views to avoid
			// unneccessary calls to findViewById() on each row.
			ViewHolder tmp_holder = null;
			
			// When convertView is not null, we can reuse it directly, there is
			// no need to reinflate it. We only inflate a new View when the convertView
			// supplied by ListView is null.
			if( convertView == null )
			{
				convertView = mInflater.inflate( R.layout.timeline_listview_content, null );
				
				// Create view holder to hold the view
				tmp_holder = new ViewHolder();
				tmp_holder.mTextView = ( TextView )convertView.findViewById( R.id.textLine );
				
				// Register list item onClick listener
				convertView.setOnClickListener( new OnClickListener(){
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Toast.makeText( mContext, "You hit me!!", Toast.LENGTH_SHORT ).show();
					}
				} );
				
				convertView.setTag( tmp_holder );
			}
			else
			{
				// Get the ViewHolder back to get fast access to the TextView
				// and the ImageView.
				tmp_holder = ( ViewHolder )convertView.getTag();
			}
			
			tmp_holder.mTextView.setText( "Honey, I will finish you in a short time" );
			//convertView.setBackgroundColor( R.drawable.listitem_bg );
			return convertView;
		}
	}

}
