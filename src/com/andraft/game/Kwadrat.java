package com.andraft.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.andraft.pers.Bullet;
import com.andraft.pers.Player;
import com.andraft.putin.R;
import com.andraft.res.GraficResourses;
import com.andraft.res.GraficResourses.COLORPAINTS;

public class Kwadrat {

	Rect rect;

	private int ryad;
	private int col;
	private CanvasFactory factory;
	private Paint p;
	private Player player;
	private List<Bullet> ball = new ArrayList<Bullet>();	
	private Context context;

	Bitmap players,bul;

	private Integer position() {
		Log.d("myLogs", "position:" + this.factory.pole.indexOf(this));
		return this.factory.pole.indexOf(this);
	}

	public void init(CanvasFactory factory,Context context) {
		this.factory = factory;
		final int shirina = factory.rect.width() / 8;
		this.ryad = position() / 6;
		this.col = position() - ryad * 6;
		this.context = context;
		Log.d("myLogs", col + " " + ryad + "");
		this.rect = new Rect(ryad * shirina - factory.dif, col
				* factory.rect.height() / 6, ryad * shirina + shirina
				- factory.dif, col * factory.rect.height() / 6
				+ factory.rect.height() / 6);

		if (((ryad + col) % 2) == 0)
			p = GraficResourses.res().getPaint(COLORPAINTS.yellow);
		else
			p = GraficResourses.res().getPaint(COLORPAINTS.brown);

	}

	public void draw(Canvas canvas) {
			canvas.drawRect(rect, p);
		if(player!=null){
			player.Draw(canvas);
			
			 Iterator<Bullet> j = ball.iterator();
	          while(j.hasNext()) {
	        	  Bullet b = j.next();
	        		  b.Draw(canvas);

	        	  }
	          }
	
		
        //canvas.drawBitmap(guns, 5, 120, null);
  }

	public void touch(int x, int y, Context context) {
		if (rect.contains(x, y)) {
			players= BitmapFactory.decodeResource(context.getResources(), R.drawable.nindza);
			player= new Player(players,rect);
			ball.add(createSprite(R.drawable.bullet));
			Log.d("myLogs","contains");
		}
	}
	public Bullet createSprite(int resouce) {
   	 Bitmap bmp = BitmapFactory.decodeResource(context.getResources(), resouce);
   	 return new Bullet(bmp,rect);
   }
}
