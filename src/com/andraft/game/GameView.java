package com.andraft.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback {
	private GameThread mThread;
	private CanvasFactory factory;

	public GameView(Context context) {
		super(context);
		this.getHolder().addCallback(this);
		factory = new CanvasFactory(context);
	}
	
	public CanvasFactory getFactory(){
		return factory;
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		Log.d("myLogs","surfaceChanged");
		
		factory.init(getHolder().getSurfaceFrame());

	}
	

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		Log.d("myLogs","surfaceCreated");
		mThread = new GameThread(getHolder(),getResources(),factory);
		mThread.setRunning(true);
		mThread.start();

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		boolean retry = true;
		mThread.setRunning(false);
		while (retry) {
			try {
				mThread.join();
				retry = false;
			} catch (InterruptedException e) {
				Log.d("myLogs", "InterruptedException");
			}
		}

	}


	
}
