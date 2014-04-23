package com.andraft.pers;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.andraft.game.GameView;

public class Player
{

         
        //спрайт
    Bitmap bmp;

    //х и у координаты рисунка
    int x;
    int y;

        //конструктор	
    public Player(Bitmap bmp,Rect rect)
    {

        this.bmp = bmp;                    //возвращаем рисунок
        
        this.x = rect.centerX();                        //отступ по х нет
        this.y = rect.centerY(); //делаем по центру
    }

    //рисуем наш спрайт
    public void Draw(Canvas c)
    {
        c.drawBitmap(bmp, x, y, null);
    }
}
