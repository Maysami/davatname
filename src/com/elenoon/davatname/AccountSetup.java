package com.elenoon.davatname;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.ArrayList;

public class AccountSetup extends Activity  implements View.OnClickListener {

    @Override
    public void onClick(View view) {

    }

    private EditText mEmailView;
    private EditText mPasswordView;
    private Button mActivateButton;
    private Button mSignButton;


  /*  public static void actionNewAccount(Context context) {
        Intent i = new Intent(context, AccountSetup.class);
        context.startActivity(i);
    }*/


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_setup);

        getActionBar().hide();
        mEmailView = (EditText) findViewById(R.id.account_username);
        mPasswordView = (EditText) findViewById(R.id.account_password);
        mActivateButton= (Button) findViewById(R.id.activate);
        mSignButton = (Button) findViewById(R.id.signin);

        findViewById(R.id.password_forgoten).setOnClickListener(this);

        mEmailView.setOnClickListener(this);
        mPasswordView.setOnClickListener(this);
        mActivateButton.setOnClickListener(this);




        mSignButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

              String  password = mPasswordView.getText().toString();
              String  username = mEmailView.getText().toString();

                com.google.gson.JsonObject json = new JsonObject();
                Ion.with(AccountSetup.this)
                        .load("http://id.elenoon.ir/cas/appLogin?username="+username+"&password="+password)
                        .asString()
                        .withResponse()
                        .setCallback(new FutureCallback<Response<String>>() {
                            @Override
                            public void onCompleted(Exception e, Response<String> stringResponse) {
                                if (e != null) {
                                    Toast.makeText(getApplicationContext(),"NOK appLogin",Toast.LENGTH_LONG).show();
                                } else {
                                    String tgt = stringResponse.getHeaders().getHeaders().get("tgt");
                                    Ion.with(AccountSetup.this)
                                            .load("https://id.elenoon.ir/cas/tgtValidate?tgt="+tgt)
                                            .asString()
                                            .withResponse()
                                            .setCallback(new FutureCallback<Response<String>>() {
                                                @Override
                                                public void onCompleted(Exception e, Response<String> stringResponse) {
                                                    if (e != null) {
                                                        Toast.makeText(getApplicationContext(),"NOK",Toast.LENGTH_LONG).show();
                                                    } else {
                                                        String attributes = stringResponse.getHeaders().getHeaders().get("attributes");
                                                        try {
                                                            JSONObject a = new JSONObject(attributes);
                                                            String username = a.getString("username");
                                                            String name = a.getString("name");
                                                            Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
                                                        } catch (Exception e1) {

                                                        }
                                                    }
                                                }
                                            });
                                }
                            }
                        });
            }
        });

    }
/*    private void activate() {

        String smsNumber = "10003737";
        String hotkey = getString(R.string.activate_account_hotkey);
        String smsText = hotkey + " " + passowrdEt.getText().toString();

        Uri uri = Uri.parse("smsto:" + smsNumber);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", smsText);
        startActivity(intent);
    }*/



}