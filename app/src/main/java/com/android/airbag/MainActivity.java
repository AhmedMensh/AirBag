package com.android.airbag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.image);
        imageView.setColorFilter(ContextCompat.getColor( this, R.color.orange), android.graphics.PorterDuff.Mode.MULTIPLY);
    }
}
