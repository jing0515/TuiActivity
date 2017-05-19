package com.bawei.lvwenjing.tuiactivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;


/**
 * Created by muhanxi on 17/5/4.
 */

public class CustomProgressBar extends ProgressBar {

    private int firstColor;
    private int secondColor;
    private int circleWidth;
    private Paint paint;
    private  int progress;
    private int speed ;

    private boolean isNext ;

    private int mProgress;



    //页面关闭 停止运行
    public boolean stop ;


    public CustomProgressBar(Context context) {
        this(context,null);
    }

    public CustomProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public CustomProgressBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar,defStyleAttr,defStyleRes);
        firstColor = typedArray.getColor(R.styleable.CustomProgressBar_firstColor, Color.RED);
        secondColor = typedArray.getColor(R.styleable.CustomProgressBar_secondColor,Color.BLUE);
        circleWidth = typedArray.getDimensionPixelSize(R.styleable.CustomProgressBar_circleWidth, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,16,getResources().getDisplayMetrics()));
        speed = typedArray.getInt(R.styleable.CustomProgressBar_speed,10);

        typedArray.recycle();


        for(int i=0;i<attrs.getAttributeCount();i++){
            System.out.println("attrs = " + attrs.getAttributeName(i));
            System.out.println("attrs = " + attrs.getAttributeValue(i));
        }

        paint = new Paint();
        new Thread(new Runnable() {
            @Override
            public void run() {

                while (!stop) {
                    mProgress++ ;

                    System.out.println("mProgress = " + mProgress);
                    if(mProgress == 360){

                        mProgress = 0 ;
                        int tempColor = firstColor;
                        firstColor = secondColor;
                        secondColor = tempColor;

                    }
                    //子线程 刷新UI
                    postInvalidate();
//                    invalidate(); //区别


                    try {
                        Thread.sleep(100 / speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();

    }


    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int modeSize = MeasureSpec.getMode(widthMeasureSpec);
        int size = MeasureSpec.getSize(widthMeasureSpec);

        int width = 0 ;
        int height = 0 ;
        if(modeSize == MeasureSpec.EXACTLY){
            //
            width = size ;

        } else {

            width = (int) getResources().getDimension(R.dimen.default_width);
        }

        modeSize = MeasureSpec.getMode(heightMeasureSpec);
        size = MeasureSpec.getSize(heightMeasureSpec);
        if(modeSize == MeasureSpec.EXACTLY){
            //
            height = size ;

        } else {

            height = (int) getResources().getDimension(R.dimen.default_height);

        }
        setMeasuredDimension(width,height);

    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //获取圆心X坐标
        int center = getWidth() / 2 ;

        //半径 x坐标 － 圆形的宽度
        int radius = center - circleWidth ;

        // 设置圆环的宽度
        paint.setStrokeWidth(circleWidth);

        //消除锯齿
        paint.setAntiAlias(true);

        // 设置空心
        paint.setStyle(Paint.Style.STROKE);
//        用于定义的圆弧的形状和大小的界限
        RectF oval = new RectF(center - radius,center - radius,center+radius,center+radius);


        //第一个圆颜色的圆， 第二个圆 弧度一致变化
        paint.setColor(firstColor);
        // 画出圆环
        canvas.drawCircle(center,center,radius,paint);
        paint.setColor(secondColor);
        // 根据进度画圆弧
        canvas.drawArc(oval,-90,mProgress,false,paint);




    }
}
