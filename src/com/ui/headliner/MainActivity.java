package com.ui.headliner;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends CustomerActivity {

	private ViewPager myViewPager;
	private PagerTitleStrip mPagerTitleStrip;
	final ArrayList<String> titles = new ArrayList<String>();

	private MyPagerAdapter myAdapter;

	private LayoutInflater mInflater;
	private List<View> mListViews;
	private View layout1 = null;
	private View layout2 = null;
	private View layout3 = null;
	
	private LinearLayout linearLayout;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  
        
        initPageViewer();
//        initMainTopics();
    }
    
    public void initPageViewer() {
        myAdapter = new MyPagerAdapter();
		myViewPager = (ViewPager) findViewById(R.id.viewpagerLayout);
		myViewPager.setAdapter(myAdapter);

		mListViews = new ArrayList<View>();
		mInflater = getLayoutInflater();
		layout1 = mInflater.inflate(R.layout.layout1, null);
		layout2 = mInflater.inflate(R.layout.layout2, null);
		layout3 = mInflater.inflate(R.layout.layout3, null);
		mListViews.add(layout1);
		mListViews.add(layout2);
		mListViews.add(layout3);

		mPagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pagerTitle);

		titles.add("tab1");
		titles.add("tab2");
		titles.add("tab3");

		myViewPager.setCurrentItem(0);
    }

//    public void initMainTopics() {
//    	linearLayout = (LinearLayout) findViewById(R.id.mainTopicLinearLayout);
//		List<ImageView> imageViews = new ArrayList<ImageView>();		 
//		for (int i = 0; i < 4; i++) {
//			ImageView imageView = new ImageView(this);
//			imageView.setImageResource(R.drawable.kuroshiro);
//			imageView.setFadingEdgeLength(10);
//			imageView.setId(i);
//			imageView.setPadding(1, 1, 1, 1);
//			imageViews.add(imageView);
//			linearLayout.addView(imageView);
//		}
//    }
    
    private class MyPagerAdapter extends PagerAdapter {
		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			Log.d("k", "destroyItem");
			((ViewPager) arg0).removeView(mListViews.get(arg1));
		}

		@Override
		public void finishUpdate(View arg0) {
			Log.d("k", "finishUpdate");
		}

		@Override
		public int getCount() {
			Log.d("k", "getCount");
			return mListViews.size();
		}

		@Override
		public Object instantiateItem(View arg0, int arg1) {
			Log.d("k", "instantiateItem");
			((ViewPager) arg0).addView(mListViews.get(arg1), 0);
			return mListViews.get(arg1);
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			Log.d("k", "isViewFromObject");
			return arg0 == (arg1);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return titles.get(position);
		}

		@Override
		public void restoreState(Parcelable arg0, ClassLoader arg1) {
			Log.d("k", "restoreState");
		}

		@Override
		public Parcelable saveState() {
			Log.d("k", "saveState");
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
			Log.d("k", "startUpdate");
		}

	}

}
