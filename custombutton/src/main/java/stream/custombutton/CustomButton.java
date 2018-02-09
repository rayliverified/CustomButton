package stream.custombutton;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

public class CustomButton extends android.support.v7.widget.AppCompatTextView {

    private String mText;
    private GradientDrawable gradientDrawable;
    private int mButtonSelectColor;
    private int mButtonColor;
    private int mStrokeColor;
    private int mStrokeSelectColor;
    private int textColor;
    private int textSelectColor;
    private int mStrokeWidth;
    private int mCornerRadius;
    private Resources resources;
    private int showDrawable;
    private Drawable drawable;
    private Context mContext;

    public CustomButton(Context context) {
        this(context, null, 0, 0);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0, 0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {

        mContext = context;

        resources = getResources();
        if (gradientDrawable == null) {
            gradientDrawable = new GradientDrawable();
        }

        int[] set = {
                android.R.attr.text
        };
        TypedArray a = context.obtainStyledAttributes(attrs, set);
        mText = String.valueOf(a.getText(0));
        a.recycle();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButton, defStyleAttr, defStyleRes);
        textColor = typedArray.getColor(R.styleable.CustomButton_btn_textColor, Color.GRAY);
        textSelectColor = typedArray.getColor(R.styleable.CustomButton_btn_textSelectColor, textColor);
        mButtonColor = typedArray.getColor(R.styleable.CustomButton_btn_buttonColor, Color.WHITE);
        mButtonSelectColor = typedArray.getColor(R.styleable.CustomButton_btn_buttonSelectColor, mButtonColor);
        mStrokeColor = typedArray.getColor(R.styleable.CustomButton_btn_strokeColor, Color.GRAY);
        mStrokeSelectColor = typedArray.getColor(R.styleable.CustomButton_btn_strokeSelectColor, mStrokeColor);
        mStrokeWidth = typedArray.getDimensionPixelSize(R.styleable.CustomButton_btn_strokeWidth, 2);
        mCornerRadius = typedArray.getDimensionPixelSize(R.styleable.CustomButton_btn_cornerRadius, 40);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(mButtonColor);
        gradientDrawable.setStroke(mStrokeWidth, mStrokeColor, 0, 0);
        gradientDrawable.setCornerRadius(mCornerRadius);

        setButtonBackground();
        typedArray.recycle();

        setGravity(Gravity.CENTER);
        setTextColor(textColor);

        setOnTouchListener(new OnButtonTouchListener());
    }

    private void setText(String text) {
        mText = text;
        super.setText(text);
    }

    private void setButtonBackground() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            setBackground(gradientDrawable);
        else
            setBackgroundDrawable(gradientDrawable);
    }

    private class OnButtonTouchListener implements OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    setPressStatus(true);
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    setPressStatus(false);
                    break;
            }

            return false;
        }
    }

    public void setPressStatus(boolean isPress) {
        if (isPress) {
            setTextColor(textSelectColor);
            gradientDrawable.setColor(mButtonSelectColor);
            gradientDrawable.setStroke(mStrokeWidth, mStrokeSelectColor);
        } else {
            setTextColor(textColor);
            gradientDrawable.setColor(mButtonColor);
            gradientDrawable.setStroke(mStrokeWidth, mStrokeColor);
        }
        setButtonBackground();
    }


    public void setButtonStatus(boolean isEnable) {
        if (isEnable) {
            setTextColor(textSelectColor);
            gradientDrawable.setColor(mButtonSelectColor);
            gradientDrawable.setStroke(mStrokeWidth, mStrokeSelectColor);
        } else {
            setTextColor(textColor);
            gradientDrawable.setColor(mButtonColor);
            gradientDrawable.setStroke(mStrokeWidth, mStrokeColor);
        }

        setButtonBackground();
    }

    public void setDrawableLeft(int imgResId) {
        setDrawableLeft(imgResId, getLineHeight(), getLineHeight());
    }

    public void setDrawableLeft(int imgResId, int width, int height) {
        String originalText = mText;
        setText("");
        SpannableString ss = new SpannableString("pics");
        Drawable drawable = ContextCompat.getDrawable(mContext, imgResId);
        drawable.setBounds(0, 0, width, height);
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        ss.setSpan(span, 0, ss.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        append(ss);
        append(" ");
        append(originalText);
        mText = originalText;
    }

    public void setDrawableRight(int imgResId) {
        setDrawableRight(imgResId, getLineHeight(), getLineHeight());
    }

    public void setDrawableRight(int imgResId, int width, int height) {
        SpannableString ss = new SpannableString("pics");
        Drawable drawable = ContextCompat.getDrawable(mContext, imgResId);
        drawable.setBounds(0, 0, width, height);
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        ss.setSpan(span, 0, ss.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        setText(mText + " ");
        append(ss);
    }


    public void setColor(int textnormal, int textselected, int buttonnormal, int buttonselected, int strokenormal, int strokeselected) {
        textColor = textnormal;
        textSelectColor = textselected;
        mButtonColor = buttonnormal;
        mButtonSelectColor = buttonselected;
        mStrokeColor = strokenormal;
        mStrokeSelectColor = strokeselected;
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(mButtonColor);
        gradientDrawable.setStroke(mStrokeWidth, mStrokeColor, 0, 0);
        gradientDrawable.setCornerRadius(mCornerRadius);
        setButtonBackground();
        setTextColor(textColor);
    }

    /**
     * 颜色加深处理
     *
     * @param RGBValues RGB的值，由alpha（透明度）、red（红）、green（绿）、blue（蓝）构成，
     *                  Android中我们一般使用它的16进制，
     *                  例如："#FFAABBCC",最左边到最右每两个字母就是代表alpha（透明度）、
     *                  red（红）、green（绿）、blue（蓝）。每种颜色值占一个字节(8位)，值域0~255
     *                  所以下面使用移位的方法可以得到每种颜色的值，然后每种颜色值减小一下，在合成RGB颜色，颜色就会看起来深一些了
     * @return
     */
    private int colorBurn(int RGBValues) {
        //int alpha = RGBValues >> 24;
        int red = RGBValues >> 16 & 0xFF;
        int green = RGBValues >> 8 & 0xFF;
        int blue = RGBValues & 0xFF;
        red = (int) Math.floor(red * (1 - 0.1));
        green = (int) Math.floor(green * (1 - 0.1));
        blue = (int) Math.floor(blue * (1 - 0.1));
        return Color.rgb(red, green, blue);
    }
}