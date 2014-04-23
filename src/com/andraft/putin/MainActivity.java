package com.andraft.putin;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

import com.andraft.game.GameView;

public class MainActivity extends Activity implements OnTouchListener {
	
	private GameView surf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		surf = new GameView(this);

		setContentView(surf);	
		Log.d("myLogs","onCreate Activity,setContent");
		surf.setOnTouchListener(this);

	}

	@Override
	public boolean onTouch(View v, MotionEvent m) {
		Log.d("myLogs",m.getX()+" and "+m.getY());
		surf.getFactory().Touch(m, this);
		return false;
	}

}
