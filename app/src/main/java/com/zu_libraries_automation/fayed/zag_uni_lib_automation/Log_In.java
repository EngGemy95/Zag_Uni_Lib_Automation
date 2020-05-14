package com.zu_libraries_automation.fayed.zag_uni_lib_automation;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Log_In extends AppCompatActivity implements BackgroundWorker.GetListenerLogin{

    EditText mail, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log__in);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.welcom_page, (ViewGroup) findViewById(R.id.welcom_page));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(view);
        toast.show();

        mail = (EditText) findViewById(R.id.loginText);
        pass = (EditText) findViewById(R.id.passText);
    }

    public void login(View view) {
        String email = mail.getText().toString();
        String passward = pass.getText().toString();
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.getListenerLogin=this;
        backgroundWorker.execute(type, email, passward);
    }

    public void goRegister(View view)
    {
        startActivity(new Intent(this, Register.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.about, menu);
        return true;
    }


    @Override
    public void onGetStatusLogin(String response) {
        if (response.equals("0")) {
            Toast.makeText(this, "E-mail or Password Not Correct !", Toast.LENGTH_SHORT).show();
        }else {
            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("result");

                JSONObject finalObject = jsonArray.getJSONObject(0);
                String user_id = finalObject.getString("id");
                String username = finalObject.getString("username");
                String e_mail = finalObject.getString("e_mail");
                String faculty_name = finalObject.getString("faculty_name");

            } catch (JSONException e) {
                e.printStackTrace();
            }

            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Home.class));
        }
        //Intent intent = new Intent(this,Home.class);
        //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //startActivity(intent);
        //this.finish();
    }

}
