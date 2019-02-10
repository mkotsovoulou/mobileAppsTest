package com.maira.eatcookie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EatCookie (View view){
     ImageView temp = (ImageView) findViewById(R.id.cookieImage);
     temp.setImageResource(R.drawable.after_cookie_en);

     TextView temp2 = (TextView) findViewById(R.id.messageText);
     temp2.setText("I am so Full");

    }
}
