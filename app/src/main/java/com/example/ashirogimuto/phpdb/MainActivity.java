package com.example.ashirogimuto.phpdb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText eName, ePass;
    String logName,logPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eName = (EditText)findViewById(R.id.etName);
        ePass = (EditText)findViewById(R.id.etPass);

    }

    public void userLogin(View view)
    {
        logName = eName.getText().toString();
        logPass  = ePass.getText().toString();

        String method = "login";
        BackgroundTask BT = new BackgroundTask(this);
        BT.execute(method,logName,logPass);
    }

    public void userReg(View view)
    {
        startActivity(new Intent(this, Register.class));
    }
}
