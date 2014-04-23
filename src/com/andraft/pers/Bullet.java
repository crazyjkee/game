package com.andraft.pers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import com.andraft.game.GameView;

public class Bullet
{
    /**Картинка*/
    private Bitmap bmp;
    
    /**Позиция*/
    public int x;
    public int y;
    
    /**Скорость по Х=15*/
    private int mSpeed= 1;
    

      
       /**Конструктор*/
       public Bullet(Bitmap bmp,Rect rect) {
  
             this.bmp=bmp;
             
             this.x = rect.centerX();            //позиция по Х
             this.y = rect.centerY();          //позиция по У
             
       }
 
       /**Перемещение объекта, его направление*/
       private void update() {    
    	   x += mSpeed;
       }



	public void Draw(Canvas canvas) {
		// TODO Auto-generated method stub
		update(); 
		           //говорим что эту функцию нам нужно вызывать для работы класса
            canvas.drawBitmap(bmp, x, y, null);
	}
}
