package com.zu_libraries_automation.fayed.zag_uni_lib_automation;


import android.content.Intent;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements BackgroundWorker.GetListenerRegister {
    EditText username, mail, pass, repass;
    Boolean success = false;
    String value = "aaa";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.username);
        mail = (EditText) findViewById(R.id.eAddress);
        pass = (EditText) findViewById(R.id.pass);
        repass = (EditText) findViewById(R.id.rePassword);

        // getSupportActionBar().setTitle("Register");
    }

    public void register(View view) {

        String st_username = username.getText().toString();
        String st_mail = mail.getText().toString();
        String st_pass = pass.getText().toString();
        String st_repass = repass.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = null;
        backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.getListenerRegister = this;

        String vali = validate(st_username, st_mail, st_pass, st_repass);
        if (vali.equals("1")) {
            backgroundWorker.execute(type, st_username, st_mail, st_pass, st_repass);
        } else {
            Toast.makeText(getBaseContext(), "passward don't match", Toast.LENGTH_LONG).show();
        }
    }

    private String validate(String username, String email, String password, String repassword) {
        if (password.equals(repassword)) {
            return "1";
        } else {
            return "0";
        }

    }

    @Override
    public void onGetStatusRegister(String response) {
        value = response;
        if (response.equals("1")) {
            Toast.makeText(this, "inserted Successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Log_In.class));
        } else if (response.equals("0")) {
            Toast.makeText(this, "Error , please retry again", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "user name exist", Toast.LENGTH_SHORT).show();
        }
    }
}