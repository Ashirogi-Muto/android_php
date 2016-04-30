package com.example.ashirogimuto.phpdb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Ashirogi Muto on 4/29/2016.
 */
public class Register extends AppCompatActivity {

    EditText etName, etUname, etUpass;
    String name, uname, upass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        etName = (EditText)findViewById(R.id.etName);
        etUname = (EditText)findViewById(R.id.etUname);
        etUpass = (EditText)findViewById(R.id.etUpass);


    }
    public void userReg(View view)
    {
        name = etName.getText().toString();
        uname = etUname.getText().toString();
        upass = etUpass.getText().toString();

        String method = "register";
        BackgroundTask bt = new BackgroundTask(this);
        bt.execute(method,name,uname,upass);
        finish();
    }
}
