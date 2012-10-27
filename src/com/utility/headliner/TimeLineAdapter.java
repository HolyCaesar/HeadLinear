package com.utility.headliner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.activities.headliner.*;
import com.entities.headliner.TimeLine;
import com.ui.headliner.R;

public class TimeLineAdapter extends ArrayAdapter<TimeLine>{

	Context context; 
	int layoutResourceId;    
	TimeLine data[] = null;

	public TimeLineAdapter( Context context, int layoutResourceId, TimeLine[] data ) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
	
	@Override
    public View getView( int position, View convertView, ViewGroup parent ) {
		View row = convertView;
		TimeLineHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ( (TimeLineActivity)context ).getLayoutInflater();
            row = inflater.inflate( layoutResourceId, parent, false );
            
            holder = new TimeLineHolder();
            holder.imgIcon = (ImageView)row.findViewById( R.id.imgIcon );
            holder.txtTitle = (TextView)row.findViewById( R.id.txtTitle );
            
            row.setTag(holder);
        }
        else
        {
            holder = (TimeLineHolder)row.getTag();
        }
        
        TimeLine TLActivity = data[ position ];
        holder.txtTitle.setText( TLActivity.title );
        holder.imgIcon.setImageResource( TLActivity.icon );
        
        return row;
    }
    
    static class TimeLineHolder
    {
        ImageView imgIcon;
        TextView txtTitle;
    }
}
