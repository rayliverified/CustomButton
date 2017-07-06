package stream.custombutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

public class CustomButton extends android.support.v7.widget.AppCompatTextView {
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


    public CustomButton(Context context) {
        this(context,null,0,0);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        this(context,attrs, 0,0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init(context, attrs,defStyleAttr,defStyleRes);
    }

    private void init(Context context, AttributeSet attrs,int defStyleAttr, int defStyleRes) {
        resources = getResources();
        if (gradientDrawable == null) {
            gradientDrawable = new GradientDrawable();
        }

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomButton, defStyleAttr, defStyleRes);
        textColor = typedArray.getColor(R.styleable.CustomButton_btn_textColor, Color.GRAY);
        textSelectColor = typedArray.getColor(R.styleable.CustomButton_btn_textSelectColor, Color.WHITE);
        mButtonColor = typedArray.getColor(R.styleable.CustomButton_btn_buttonColor, Color.WHITE);
        mButtonSelectColor = typedArray.getColor(R.styleable.CustomButton_btn_buttonSelectColor, Color.GRAY);
        mStrokeColor = typedArray.getColor(R.styleable.CustomButton_btn_strokeColor, Color.GRAY);
        mStrokeSelectColor = typedArray.getColor(R.styleable.CustomButton_btn_strokeSelectColor, Color.GRAY);
        mStrokeWidth = typedArray.getDimensionPixelSize(R.styleable.CustomButton_btn_strokeWidth, 2);
        mCornerRadius = typedArray.getDimensionPixelSize(R.styleable.CustomButton_btn_cornerRadius, 40);
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(mButtonColor);
        gradientDrawable.setStroke(mStrokeWidth, mStrokeColor, 0, 0);
        gradientDrawable.setCornerRadius(mCornerRadius);

        setButtonBackgroud();
        typedArray.recycle();

        setGravity(Gravity.CENTER);
        setTextColor(textColor);

        setOnTouchListener(new OnButtonTouchListener());
    }

    private void setButtonBackgroud() {
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
        setButtonBackgroud();
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

        setButtonBackgroud();
    }

    public void setDrawableRightText(int text, int imgResId) {
        setDrawableRightText(resources.getString(text), imgResId);
    }

    public void setDrawableRightText(CharSequence text, int imgResId) {
        Drawable drawable = resources.getDrawable(imgResId);
        setDrawableRightText(text, drawable);
    }

    public void setDrawableRightText(CharSequence text, Drawable drawable) {
        setText("");
        SpannableString ss = new SpannableString("pics");

        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        ss.setSpan(span, 0, ss.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        append(text);
        append(" ");
        append(ss);
    }

    public void setDrawableLeftText(int text, int imgResId) {
        setDrawableLeftText(resources.getString(text), imgResId);
    }

    public void setDrawableLeftText(CharSequence text, int imgResId) {
        Drawable drawable = resources.getDrawable(imgResId);
        setDrawableLeftText(text,drawable);
    }

    public void setDrawableLeftText(CharSequence text, Drawable drawable){
        setText("");
        SpannableString ss = new SpannableString("pics");
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
        ss.setSpan(span, 0, ss.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        append(ss);
        append(" ");
        append(text);
    }

    public void setColor(int textnormal, int textpressed, int buttonunpressed, int buttonpressed, int stroke)
    {
        textColor = textnormal;
        textSelectColor = textpressed;
        mButtonColor = buttonunpressed;
        mButtonSelectColor = buttonpressed;
        mStrokeColor = stroke;
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        gradientDrawable.setColor(mButtonColor);
        gradientDrawable.setStroke(mStrokeWidth, mStrokeColor, 0, 0);
        gradientDrawable.setCornerRadius(mCornerRadius);
        setButtonBackgroud();
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