package org.merka.mobilelisf;

import org.merka.mobilelisf.graphics.GraphicView;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Bitmap.Config;
import android.graphics.Paint.Style;
import android.graphics.drawable.ShapeDrawable;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity 
{
	
	private Float x1 = 0F;
	private Float y1 = 0F;
	private Float x2 = 100F;
	private float y2 = 100F;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void eseguiClick(View view)
    {
    	GraphicView gView = (GraphicView)findViewById(R.id.view1);
    	gView.update(x1, y1, x2, y2);    	
    	x1 += 10F;
//    	y1 += 10F;
    	x2 -= 10F;
//    	y2 += 10F;
    }
}
