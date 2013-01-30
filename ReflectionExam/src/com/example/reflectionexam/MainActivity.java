package com.example.reflectionexam;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	private ImageView mImageView;
	private LinearLayout mLinearLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		findView();
		createView();
	}

	private void findView() {
		mLinearLayout = (LinearLayout)findViewById(R.id.layout);

	}

	private void createView() {
		Bitmap originalImage = BitmapFactory.decodeResource(getResources(),
                R.drawable.p2);
		mImageView = new ImageView(this);
		mLinearLayout.addView(mImageView);
		
		mImageView.setImageBitmap(ReflectionUtil.getRefelection(originalImage));

	}
}
