package stream.custombutton;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class CustomButton extends androidx.appcompat.widget.AppCompatTextView {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

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

        @SuppressLint("ClickableViewAccessibility")
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

    /**
     * @param isPress - set button appearance to selected/unselected state.
     */
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

    /**
     * @param imgResId - drawable ID.
     */
    public void setDrawableLeft(int imgResId) {
        setDrawableLeft(imgResId, getLineHeight(), getLineHeight());
    }

    /**
     * @param imgResId - drawable ID.
     * @param width - drawable width in px.
     * @param height - drawable height in px.
     */
    public void setDrawableLeft(int imgResId, int width, int height) {
        String originalText = mText;
        setText("");
        SpannableString ss = new SpannableString("pics");
        Drawable drawable = ContextCompat.getDrawable(mContext, imgResId);
        assert drawable != null;
        drawable.setBounds(0, 0, width, height);
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        ss.setSpan(span, 0, ss.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        append(ss);
        append(" ");
        append(originalText);
        mText = originalText;
    }

    /**
     * @param imgResId - drawable ID.
     */
    public void setDrawableRight(int imgResId) {
        setDrawableRight(imgResId, getLineHeight(), getLineHeight());
    }

    /**
     * @param imgResId - drawable ID.
     * @param width - drawable width in px.
     * @param height - drawable height in px.
     */
    public void setDrawableRight(int imgResId, int width, int height) {
        SpannableString ss = new SpannableString("pics");
            Drawable drawable = ContextCompat.getDrawable(mContext, imgResId);
        assert drawable != null;
        drawable.setBounds(0, 0, width, height);
        ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        ss.setSpan(span, 0, ss.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        setText(mText + " ");
        append(ss);
    }

    /**
     * @param textnormal - text color.
     * @param textselected - text color when pressed.
     * @param buttonnormal - background color.
     * @param buttonselected - background color when pressed.
     * @param strokenormal - outline color.
     * @param strokeselected - outline color when pressed.
     */
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
     * @param RGBValues Get the darkened version of each color.
     *                  The value of RGB is made up of alpha (transparency), red (red), green (green), blue (blue).
     *                  In Android, RGB is usually represented as a hexadecimal.
     *                  For example: "#FFAABBCC", from the left to the right, every two letters represent
     *                  alpha (transparency), red, green, blue. Each color has a value of 0 to 255.
     *                  This method shifts the color values and darkens the color.
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