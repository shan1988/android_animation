package com.clbee.kicanimaition.PathAni;

import java.util.ArrayList;

import com.clbee.kicanimaition.R;
import com.clbee.kicanimaition.util.DisplayUtil;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.EventLog.Event;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.LinearLayout;



public class PathAnimation extends Activity implements OnTouchListener{
    Button mButton;
    AnimatorProxy mButtonProxy;
    PathEvaluator mEvaluator = new PathEvaluator();
    ArrayList<Point> point;
    Point p;
    LinearLayout layout;
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pathanimator);

        mButton = (Button) findViewById(R.id.button);
        layout = (LinearLayout) findViewById(R.id.container);
        layout.setOnTouchListener(this);
        mButtonProxy = AnimatorProxy.wrap(mButton);
        point = new ArrayList<Point>();
       
        
        
        
       
        
        
        
        
        mButton.setOnClickListener(new View.OnClickListener() {
        	
        	
        	
            @Override
            public void onClick(View v) {
            	 AnimatorPath path = new AnimatorPath();
                 path.moveTo(0, 0);
                 path.lineTo(0, 0);
//                 path.curveTo(0, 100, (new DisplayUtil(this).getMeasuredwidth())/2, 300, new DisplayUtil(this).getMeasuredwidth()-100, 350);
                
                 path.curveTo(point.get(0).x, point.get(0).y,point.get(1).x, point.get(1).y,point.get(2).x, point.get(2).y);
                
                 final ObjectAnimator anim = ObjectAnimator.ofObject(this, "buttonLoc",
                         new PathEvaluator(), path.getPoints().toArray());
                 anim.setRepeatCount(5);
                 anim.setDuration(3000);
                anim.start();
                
            }
        });
        
        
        
    }

    /**
     * We need this setter to translate between the information the animator
     * produces (a new "PathPoint" describing the current animated location)
     * and the information that the button requires (an xy location). The
     * setter will be called by the ObjectAnimator given the 'buttonLoc'
     * property string.
     */
    
    
    
    public void setButtonLoc(PathPoint newLoc) {
        mButtonProxy.setTranslationX(newLoc.mX);
        mButtonProxy.setTranslationY(newLoc.mY);
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		if(v.getId() == R.id.container && event.getAction() == MotionEvent.ACTION_UP) {
		
			point.add(new Point((int)event.getX(), (int)event.getY()));
			
		}
		
		return true;
	}

}
