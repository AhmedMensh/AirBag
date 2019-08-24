package com.android.airbag.ui.activities.login;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import com.android.airbag.R;
import com.android.airbag.ui.activities.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextView textView = findViewById(R.id.skip_login_tv);
        SpannableString content = new SpannableString(getResources().getString(R.string.skip_login));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);


    }

    public void signUp(View view) {

        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

}
