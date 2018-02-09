package stream.custombuttonapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import stream.custombutton.CustomButton;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        btn4.setDrawableRight(R.drawable.icon_check_white);
        btn4.setOnClickListener(onClickListener);

        int iconSize = (int) Units.spToPx(mContext, 22);
        CustomButton btn5 = findViewById(R.id.btn5);
        btn5.setDrawableLeft(R.drawable.icon_close_white, iconSize, iconSize);
        btn5.setOnClickListener(onClickListener);
    }
}
