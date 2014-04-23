package com.andraft.game;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

	private boolean running;
	private CanvasFactory factory;
	private SurfaceHolder holder;

	public GameThread(SurfaceHolder holder, Resources resources,CanvasFactory factory) {
		Log.d("myLogs", "GameThread constructor");
		this.factory=factory;
		this.holder = holder;

	}

	public void setRunning(boolean run) {
		Log.d("myLogs", "GameThread run:" + run);
		running = run;
	}

	public void run() {
		while (running) {
			Canvas canvas = null;
			try {
				canvas = holder.lockCanvas();
				synchronized (holder) {
					factory.Draw(canvas);
				}
			} catch (Exception e) {
				Log.d("myLogs", "Exception");
			} finally {
				if (canvas != null)
					holder.unlockCanvasAndPost(canvas);
			}
		}
	}

}
