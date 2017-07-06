package stream.custombuttonapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import stream.custombuttonapp.R;
import stream.custombutton.CustomButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Select Single Image - When image is selected, gallery immediately closes and returns image.
        CustomButton btn1 = (CustomButton) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        //Select Multiple Images - User can select multiple images and click Select to confirm.
        CustomButton btn2 = (CustomButton) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        //Image Preview Select - Clicking on image opens Image Preview. Must click select icon to select image.
        CustomButton btn3 = (CustomButton) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
