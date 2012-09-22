package org.merka.mobilelisf.graphics;

import android.content.Context;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;

public class GraphicView extends View 
{
	protected Paint paint;
	protected Float x1, x2, y1, y2;

	public Float getX1() {
		return x1;
	}

	public Float getX2() {
		return x2;
	}

	public Float getY1() {
		return y1;
	}

	public Float getY2() {
		return y2;
	}

	public Paint getPaint() {
		return paint;
	}

	public void setPaint(Paint paint) {
		this.paint = paint;
	}

	public GraphicView(Context context) {
		super(context);
		init();
	}
	
	public GraphicView(Context context, AttributeSet attributeSet)
	{
		super(context, attributeSet);
		init();
	}
	
	public GraphicView(Context context, AttributeSet attributeSet, int defStyle)
	{
		super(context, attributeSet, defStyle);
		init();
	}
	
	private void init()
	{
		setPaint(new Paint());
		getPaint().setColor(Color.RED);
		getPaint().setStyle(Style.FILL_AND_STROKE);
	}
	
	public void update(Float x1, Float y1, Float x2, Float y2)
	{
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		
		this.invalidate();
	}

	@Override
	public void onDraw(Canvas canvas)
	{
		canvas.translate(this.getWidth() / 2, (this.getHeight() / 2));
		canvas.scale(1, -1, 0, 0);
//		canvas.drawLine(this.getWidth() / 2, 0F, this.getWidth() / 2, this.getHeight(), getPaint());
//		canvas.drawLine(0F, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2, getPaint());
		
		canvas.drawLine(0F, -this.getHeight() / 2, 0F, this.getHeight() / 2, getPaint());
		canvas.drawLine(-(this.getWidth() / 2), 0, this.getWidth() / 2, 0, getPaint());
		
		if(x1 == null || y1 == null || x2 == null || y2 == null)
		{
			return;
		}
		canvas.drawLine(x1, y1, x2, y2, getPaint());
	}
}