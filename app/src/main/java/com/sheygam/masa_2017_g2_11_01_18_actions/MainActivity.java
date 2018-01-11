package com.sheygam.masa_2017_g2_11_01_18_actions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button nameBtn, emailBtn, phoneBtn;
    private TextView nameTxt, emailTxt, phoneTxt;
    public static final String DATA = "DATA";
    public static final int EDIT_NAME = 0x01;
    public static final int EDIT_EMAIL = 0x02;
    public static final int EDIT_PHONE = 0x03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameBtn = findViewById(R.id.name_btn);
        emailBtn = findViewById(R.id.email_btn);
        phoneBtn = findViewById(R.id.phone_btn);
        nameTxt = findViewById(R.id.nameTxt);
        emailTxt = findViewById(R.id.emailTxt);
        phoneTxt = findViewById(R.id.phoneTxt);
        nameBtn.setOnClickListener(this);
        emailBtn.setOnClickListener(this);
        phoneBtn.setOnClickListener(this);

        findViewById(R.id.send_action_btn)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("telran.second.activity.action");
                        startActivity(intent);
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.name_btn:
                startActivityForResult(new Intent("action.name.edit"),EDIT_NAME);
                break;
            case R.id.email_btn:
                startActivityForResult(new Intent("action.email.edit"),EDIT_EMAIL);
                break;
            case R.id.phone_btn:
                startActivityForResult(new Intent("action.phone.edit"),EDIT_PHONE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case EDIT_NAME:
                    nameTxt.setText(data.getStringExtra(DATA));
                    break;
                case EDIT_EMAIL:
                    emailTxt.setText(data.getStringExtra(DATA));
                    break;
                case EDIT_PHONE:
                    phoneTxt.setText(data.getStringExtra(DATA));
                    break;
            }
        }
    }
}
