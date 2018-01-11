package com.sheygam.masa_2017_g2_11_01_18_actions;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputName, inputEmail, inputPhone;
    private Button okBtn;
    private String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        action = getIntent().getAction();
        Uri uri = getIntent().getData();
        if(uri != null){
            Log.d("MY_TAG", "onCreate: "+uri.toString());;
        }
        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        inputPhone = findViewById(R.id.inputPhone);
        okBtn = findViewById(R.id.okBtn);
        showNeedsEdit();
        okBtn.setOnClickListener(this);
    }

    private void showNeedsEdit() {
        switch (action) {
            case "action.name.edit":
                inputName.setVisibility(View.VISIBLE);
                inputEmail.setVisibility(View.GONE);
                inputPhone.setVisibility(View.GONE);
                break;
            case "action.email.edit":
                inputName.setVisibility(View.GONE);
                inputEmail.setVisibility(View.VISIBLE);
                inputPhone.setVisibility(View.GONE);
                break;
            case "action.phone.edit":
                inputName.setVisibility(View.GONE);
                inputEmail.setVisibility(View.GONE);
                inputPhone.setVisibility(View.VISIBLE);
                break;
        }
    }

    private String getInputData() {
        switch (action) {
            case "action.name.edit":
                return inputName.getText().toString();
            case "action.email.edit":
                return inputEmail.getText().toString();
            case "action.phone.edit":
                return inputPhone.getText().toString();
            default:
                return null;
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.okBtn){
            Intent intent = new Intent();
            intent.putExtra(MainActivity.DATA,getInputData());
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
