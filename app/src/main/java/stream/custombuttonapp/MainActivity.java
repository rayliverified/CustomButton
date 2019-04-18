package stream.custombuttonapp;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import stream.custombutton.CustomButton;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Button", "Clicked");
            }
        };

        CustomButton btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(onClickListener);

        CustomButton btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(onClickListener);

        CustomButton btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(onClickListener);

        CustomButton btn4 = findViewById(R.id.btn4);
        btn4.setDrawableRight(R.drawable.icon_check_selector);
        btn4.setOnClickListener(onClickListener);

        int iconSize = (int) Units.spToPx(mContext, 22);
        CustomButton btn5 = findViewById(R.id.btn5);
        btn5.setDrawableLeft(R.drawable.icon_close_selector, iconSize, iconSize);
        btn5.setOnClickListener(onClickListener);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            if (hasFocus) {
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
            }
        }
        super.onWindowFocusChanged(hasFocus);
    }
}
