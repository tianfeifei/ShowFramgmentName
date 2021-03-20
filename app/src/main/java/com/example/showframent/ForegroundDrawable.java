package com.example.showframent;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ForegroundDrawable extends Drawable {
    private Paint mPaint;
    String mText;

    public ForegroundDrawable(int color,String text) {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(color);
        mPaint.setTextSize(60);
        mPaint.setStrokeWidth(4);
        mPaint.setStyle(Paint.Style.FILL);

        mText=text;
    }

    @Override
    public void draw(Canvas canvas) {
//        final Rect r = getBounds();
//        float cx = r.exactCenterX();
//        float cy = r.exactCenterY();
//        canvas.drawCircle(cx, cy, Math.min(cx, cy), mPaint);


        canvas.drawText(mText, 200, 400, mPaint);

    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
        mPaint.setColorFilter(cf);
        invalidateSelf();
    }

    @Override
    public int getOpacity() {
        // not sure, so be safe
        return PixelFormat.TRANSLUCENT;
    }
}
