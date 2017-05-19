package com.bawei.lvwenjing.tuiactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by muhanxi on 17/5/15.
 */

public class CanvasView extends View {

    Paint mPaint ;
int mWidth ;
    int mHeight ;

    Picture mPicture = new Picture();

    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();


    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // 2.录制内容方法
    private void recording() {
        // 开始录制 (接收返回值Canvas)
        Canvas canvas = mPicture.beginRecording(500, 500);
        // 创建一个画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        // 在Canvas中具体操作
        // 位移
        canvas.translate(250,250);
        // 绘制一个圆
        canvas.drawCircle(0,0,100,paint);

        mPicture.endRecording();

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mWidth = getWidth() ;
        mHeight = getHeight() ;
        // 将坐标系原点移动到画布正中心
               recording();    // 调用录制
        mPicture.draw(canvas);


    }
}
