package com.andraft.res;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
public final class GraficResourses{


private int  shirinaKletki=0; 

 
private Paint paint[]=new Paint[COLORPAINTS.values().length];

private static GraficResourses res;

public static synchronized  GraficResourses res() {
    if (res == null) {
        res = new GraficResourses(); 
    }
    return res;
}
GraficResourses(){
	 for (int i = 0; i < COLORPAINTS.values().length; i++) 
		 paint[i] = new Paint(Paint.ANTI_ALIAS_FLAG); 
	paint[0].setColor(Color.rgb(154,72,72));//коричневый
	paint[1].setColor(Color.rgb(240,230,80));//желтый
	paint[3].setColor(Color.rgb(240,230,80));//желтый
	paint[2].setColor(Color.GREEN);//fon
    paint[3].setStyle(Style.STROKE);//text end
	}
 
public Paint getPaint(COLORPAINTS cp ) {
	return paint[cp.ordinal()];
}
 

public int getShirinaKletki() {
	return shirinaKletki;
}

public void setShirinaKletki(int shirinaKletki) {
	if(this.shirinaKletki != shirinaKletki) {
	this.shirinaKletki = shirinaKletki;
	
	}
}
public enum COLORPAINTS{brown,yellow,fon, yellowstroke}

}
 
