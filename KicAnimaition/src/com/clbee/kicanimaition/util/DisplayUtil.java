package com.clbee.kicanimaition.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

public class DisplayUtil {
	private int Measuredwidth = 0;
	private int Measuredheight = 0;
	Point size;
	Activity mContext;
	WindowManager w;

	public DisplayUtil(Context context) {
		mContext = (Activity) context;
		w = mContext.getWindowManager();
		size = new Point();
		getSize();
	}

	public Point getSize() {

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			w.getDefaultDisplay().getSize(size);
			Measuredwidth = size.x;
			Measuredheight = size.y;
		} else {
			Display d = w.getDefaultDisplay();
			Measuredwidth = d.getWidth();
			Measuredheight = d.getHeight();
		}
		return size;
	}
	
	public int getMeasuredwidth() {
		return Measuredwidth;
	}
	
	public int getMeasuredheight() {
		return Measuredheight;
	}

}
