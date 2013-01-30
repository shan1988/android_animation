package com.clbee.kicanimaition;

import java.util.ArrayList;
import java.util.List;


import com.clbee.kicanimaition.PathAni.PathAnimation;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {

	ArrayList<MyAni> aniList;
	ListView aniListView;
	ArrayAdapter<MyAni> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findView();
		init();
		addAniList();
		aniListView.setAdapter(adapter);
		aniListView.setOnItemClickListener(this);

	}

	private void init() {
		aniList = new ArrayList<MyAni>();
		adapter = new MyAdapter(this, 0, aniList);

	}

	private void addAniList() {
		aniList.add(new MyAni(PathAnimation.class, "Path Animation"));
	}

	private void findView() {
		aniListView = (ListView) findViewById(R.id.menuList);
	}

	public class MyAni {
		Class className;
		String caption;

		public MyAni(Class className, String caption) {
			this.className = className;
			this.caption = caption;
		}

		public Class getClassName() {
			return className;
		}

		public void setClassName(Class className) {
			this.className = className;
		}

		public String getCaption() {
			return caption;
		}

		public void setCaption(String caption) {
			this.caption = caption;
		}
	}

	class MyAdapter extends ArrayAdapter<MyAni> {

		LayoutInflater inflater;
		ArrayList<MyAni> myAni;

		public MyAdapter(Context context, int textViewResourceId,
				List<MyAni> objects) {
			super(context, textViewResourceId, objects);
			myAni = (ArrayList) objects;
			inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = inflater.inflate(
						android.R.layout.simple_list_item_1, null);
				holder.tv = (TextView) convertView
						.findViewById(android.R.id.text1);

				convertView.setTag(holder);
			} else {
				convertView.setTag(holder);
			}

			holder.tv.setText(myAni.get(position).getCaption());

			return convertView;
		}
	}

	class ViewHolder {
		TextView tv;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
//		Toast.makeText(this, aniList.get(position).getCaption(),
//				Toast.LENGTH_LONG).show();
		Intent intent = new Intent(this, aniList.get(position).getClassName());
		startActivity(intent);

	}

}
