package com.example.trantouch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.Toast;

public class MainActivity extends Activity implements AnimationListener,
		OnClickListener {

	ImageView target;

	Animation moveAni;
	ArcTranslate arcAni;
	PathAnimation pathAni;
	WindowManager wm;
	LayoutParams params;
	BezierTranslateAnimation  bezierAni;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		findView();
		init();
		setAni();
		setListener();

	}

	private void init() {
		wm = (WindowManager) getApplicationContext().getSystemService(
				Context.WINDOW_SERVICE);
		params = (LayoutParams) target.getLayoutParams();
		// arcAni = new ArcTranslate(1000, Animation.RELATIVE_TO_SELF, 100,
		// Animation.RELATIVE_TO_SELF, 200, Animation.RELATIVE_TO_SELF, 100);

	}

	private void findView() {
		target = (ImageView) findViewById(R.id.android);
	}

	private void setAni() {
		moveAni = new TranslateAnimation(0, 500, 0, 0);
		moveAni.setDuration(10000);
		moveAni.setFillAfter(true);
		moveAni.setFillEnabled(true);
		// target.startAnimation(moveAni);
		arcAni = new ArcTranslate(1, Animation.RELATIVE_TO_SELF, 0,
				Animation.RELATIVE_TO_SELF, 5, Animation.RELATIVE_TO_SELF, 5);
		arcAni.setFillAfter(true);
		arcAni.setDuration(5000);

		Path path = new Path();
		RectF rectF = new RectF();
		rectF.set(200, 200, 400, 400);
		path.addArc(rectF, 0, 360);
		pathAni = new PathAnimation(path);
		pathAni.setDuration(1000);
		pathAni.setFillAfter(true);
		pathAni.setRepeatCount(Animation.INFINITE);
		pathAni.setRepeatMode(Animation.REVERSE);
		
		//(첫시작x,첫시작,y, 중간x, 중간y, 최종 x, 쵸)
		bezierAni = new BezierTranslateAnimation(0, 200, 100, 0, 200, 100);
		bezierAni.setDuration(3000);
		bezierAni.setFillAfter(true);
		bezierAni.setRepeatCount(Animation.INFINITE);
		bezierAni.setRepeatMode(Animation.REVERSE);
		
		Point p = new Point();
		new Point(10,100);
		
		target.startAnimation(bezierAni);

	}

	// arc

	private void setListener() {
		moveAni.setAnimationListener(this);
		target.setOnClickListener(this);

	}

	private void targetRealMove() {

		params.x = 100;
		params.y = 0;
		target.setLayoutParams(params);

	}

	@Override
	public void onAnimationEnd(Animation animation) {

		// targetRealMove();
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		Toast.makeText(this, "이동해도 눌린다~", Toast.LENGTH_LONG).show();
		;

	}

}
