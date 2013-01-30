package com.example.canvasbitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

public class MyView extends View {
	Drawable drawable;
	Canvas canvas;
	Paint paint;
	Bitmap bitmap;

	public MyView(Context context) {
		super(context);

		// drawable = getResources().getDrawable(R.drawable.a);
		// // drawable.setBounds(100,100, drawable.getIntrinsicWidth(),
		// drawable.getIntrinsicHeight());
		// drawable.setBounds(100,100, drawable.getIntrinsicWidth()*5,
		// drawable.getIntrinsicHeight()*5);
		// Resources res = getResources();
		// Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.a);

	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
//		drawable.draw(canvas);
//		canvas.drawBitmap(bitmap, matrix, paint)

//		bitmap = BitmapFactory.decodeResource(getResources(), 0);
		
		  Resources res = getResources();
		  Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.a);
		  canvas.drawBitmap(bmp, 100, 100, null);
	}
}
