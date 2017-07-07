package stream.custombuttonapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import stream.custombutton.CustomButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

        CustomButton btn1 = (CustomButton) findViewById(R.id.btn1);
        btn1.setOnClickListener(onClickListener);

        CustomButton btn2 = (CustomButton) findViewById(R.id.btn2);
        btn2.setOnClickListener(onClickListener);

        CustomButton btn3 = (CustomButton) findViewById(R.id.btn3);
        btn3.setOnClickListener(onClickListener);

        CustomButton btn4 = (CustomButton) findViewById(R.id.btn4);
        btn4.setOnClickListener(onClickListener);

        CustomButton btn5 = (CustomButton) findViewById(R.id.btn5);
        btn5.setOnClickListener(onClickListener);
    }
}
