package com.andraft.game;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;

import com.andraft.pers.Bullet;
import com.andraft.pers.Player;
import com.andraft.putin.R;
import com.andraft.res.GraficResourses;
import com.andraft.res.GraficResourses.COLORPAINTS;

public class CanvasFactory {
	private Context context;
	public List<Kwadrat> pole;
	Rect rect;
	int dif = 0;

	public CanvasFactory(Context context) {
		Log.d("myLogs", "CanvasFactory constructor");
		this.context = context;
		if (pole == null) {
			pole = new ArrayList<Kwadrat>();
			for (int i = 0; i < 48; i++) {
				pole.add(new Kwadrat());
			}
		}

	}



	public void Touch(MotionEvent me, Context context) {
		for (Kwadrat kw : pole)
			kw.touch((int) me.getX(), (int) me.getY(), context);

	}

	public void init(Rect rect) {
		dif = (rect.height() - rect.width()) / 2;
		Log.d("myLogs", "CanvasFactory init");
		this.rect = new Rect(-dif, 0, rect.width(), rect.height());
		for (Kwadrat k : pole)
			k.init(this,context);
		GraficResourses.res().setShirinaKletki(this.rect.width() / 8);

	}

	public void Draw(Canvas canvas) {
		canvas.drawPaint(GraficResourses.res().getPaint(COLORPAINTS.fon));
        for(int i = 47;i>=0;i--){
        	pole.get(i).draw(canvas);
        }
	}



}
