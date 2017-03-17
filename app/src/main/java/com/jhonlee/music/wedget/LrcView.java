package com.jhonlee.music.wedget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.jhonlee.music.R;
import com.jhonlee.music.listener.LyricListener;
import com.jhonlee.music.pojo.Lyric;

import java.lang.ref.WeakReference;
import java.util.List;

/**
 * Created by JhoneLee on 2017/3/16.
 */

public class LrcView extends View implements LyricListener{


    private float mTextSize;//歌词字体大小
    private float mDividerHeight;//选中歌词的高度
    private long mAnimationDuration;//动画执行时间
    private List<Lyric> mList;
    private float mAnimOffset;//动画偏移量
    private int mCurrentLine = 0;//当前显示行
    private Paint mNomalPaint;
    private Paint mCurrentPaint;    //当前播放的字体的画笔
    private WeakReference<LrcView> lrcViewRef;
    private  LrcHandler mHandler;
    public LrcView(Context context) {
        this(context, null);
    }

    public LrcView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    private void init(){

        lrcViewRef = new WeakReference<LrcView>(this);
        mHandler = new LrcHandler(lrcViewRef);

        TypedArray array = getContext().obtainStyledAttributes(R.styleable.LrcView);
        mTextSize = array.getDimension(R.styleable.LrcView_textSize,48f);
        mDividerHeight = array.getDimension(R.styleable.LrcView_dividerHeight,72f);
        mAnimationDuration = array.getInt(R.styleable.LrcView_animationDuration,
                1000);
        mAnimationDuration = mAnimationDuration < 0 ? 1000 : mAnimationDuration;

        array.recycle();

        mNomalPaint = new Paint();
        mNomalPaint.setColor(Color.WHITE);
        mNomalPaint.setTextSize(mTextSize);

        mCurrentPaint = new Paint();
        mCurrentPaint.setColor(Color.WHITE);
        mCurrentPaint.setTextSize(mTextSize);

        //得到网络歌词
    }
    public void setLyric(List<Lyric> mList){
        this.mList = mList;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mList==null)
            return;
        float centerY = getHeight()/2+mTextSize/2+mAnimOffset;

        String currentStr = mList.get(mCurrentLine).getLyric();

        float currX = (getWidth() - mCurrentPaint.measureText(currentStr)) / 2;

        canvas.drawText(currentStr, currX, centerY, mCurrentPaint);

        // 画当前行上面的
        for (int i = mCurrentLine - 1; i >= 0; i--) {
            String upStr = mList.get(i).getLyric();
            float upX = (getWidth() - mNomalPaint.measureText(upStr)) / 2;
            float upY = centerY - (mTextSize + mDividerHeight)
                    * (mCurrentLine - i);
            canvas.drawText(upStr, upX, upY, mNomalPaint);
        }

        // 画当前行下面的
        for (int i = mCurrentLine + 1; i < mList.size(); i++) {
            String downStr = mList.get(i).getLyric();
            float downX = (getWidth() - mNomalPaint.measureText(downStr)) / 2;
            float downY = centerY + (mTextSize + mDividerHeight)
                    * (i - mCurrentLine);
            canvas.drawText(downStr, downX, downY, mNomalPaint);
        }

    }

    /**
     * 换行动画 Note:属性动画只能在主线程使用
     */
    private void newLineAnim() {
        ValueAnimator animator = ValueAnimator.ofFloat(mTextSize
                + mDividerHeight, 0.0f);
        animator.setDuration(mAnimationDuration);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mAnimOffset = (Float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }


    private long mNextTime = 0l;
    private boolean mIsEnd = false;
    /**
     * 更新进度
     *
     * @param time
     *            当前时间
     */
    public synchronized void updateTime(long time) {
        // 避免重复绘制
        if (time < mNextTime || mIsEnd) {
            return;
        }
        for (int i = 0; i < mList.size(); i++) {
            if (mList.get(i).getTime() > time) {
                Log.i("LrcView", "newline ...");
                mNextTime = mList.get(i).getTime();
                mCurrentLine = i < 1 ? 0 : i - 1;
                // 属性动画只能在主线程使用，因此用Handler转发操作
                mHandler.sendEmptyMessage(0);
                break;
            } else if (i == mList.size() - 1) {
                // 最后一行
                Log.i("LrcView", "end ...");
                mCurrentLine = mList.size() - 1;
                mIsEnd = true;
                // 属性动画只能在主线程使用，因此用Handler转发操作
                mHandler.sendEmptyMessage(0);
                break;
            }
        }
    }

    @Override
    public void playToEnd() {
        mNextTime = 0;
        mCurrentLine = 0;
        mIsEnd = false;
        updateTime(mNextTime);
    }

    @Override
    public void playToPause(final long mt) {
        Log.d("MaskMusic", "mNextTime CurrentTime : " + mt);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行了");
                if (mList.size() > 0 ) {
                    for (int i = 0; i < mList.size() - 1; i++) {
                        if (mt >= mList.get(i).getTime()
                                && mt <= mList.get(i+1).getTime()){
                            Log.d("MaskMusic", mt + " 毫秒的歌词为 "
                                    + mList.get(i).getLyric());
                            mNextTime = mList.get(i).getTime();
                            mCurrentLine = i;
                            updateTime(mNextTime);
                        }
                    }
                }else{
                   // lrcViewToMusicActivity.LrcViewIsLrc(false);
                }
                Log.d("MaskMusic", "playToPause over");
            }
        }, 2000);
    }


    private static class LrcHandler extends Handler {
        private WeakReference<LrcView> mLrcViewRef;

        public LrcHandler(WeakReference<LrcView> lrcViewRef) {
            mLrcViewRef = lrcViewRef;
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    LrcView lrcView = mLrcViewRef.get();
                    if (lrcView != null) {
                        lrcView.newLineAnim();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    }
}
