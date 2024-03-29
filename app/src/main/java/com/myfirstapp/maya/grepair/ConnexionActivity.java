package com.myfirstapp.maya.grepair;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.request.RequestOptions;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class ConnexionActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    private LoginButton loginButton;
    private TextInputEditText txtmdp, txtEmail;
    private Button mbtnins, mBtnconn;

    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        databaseHelper = new DatabaseHelper(getApplicationContext());

        loginButton=findViewById(R.id.btnfcbklog);
        txtEmail=findViewById(R.id.txtEmailLog);
        txtmdp=findViewById(R.id.txtmdp);
        mbtnins=findViewById(R.id.btnins);
        mBtnconn=findViewById(R.id.btnConn);


        mbtnins.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent (ConnexionActivity.this, InscriptionActivity.class);
                startActivity(i);
            }
        });
        mBtnconn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (databaseHelper.isUserAuth(txtEmail.getText().toString(), txtmdp.getText().toString())){
                    Intent intent = new Intent(ConnexionActivity.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }

            }
        });
        callbackManager=CallbackManager.Factory.create();
        loginButton.setReadPermissions(Arrays.asList("email","public_profile"));
        CheckLoginStatus();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    AccessTokenTracker accessTokenTracker=new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {

            if(currentAccessToken==null){
                txtEmail.setError("");
                txtmdp.setError("");
                Toast.makeText(ConnexionActivity.this,"UserActivity Logged out",Toast.LENGTH_LONG).show();
            }
            else
                loadUserProfil(currentAccessToken);
        }
    };

    private void loadUserProfil(AccessToken newAccessToken){

        GraphRequest request= GraphRequest.newMeRequest(newAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {

                try {
                    String email=object.getString("email");
                    String motdepasse=object.getString("motdepasse");

                    txtEmail.setError(email);
                    txtmdp.setError(motdepasse);
                    RequestOptions requestOptions=new RequestOptions();
                    requestOptions.dontAnimate();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        Bundle parameters= new Bundle();
        parameters.putString("fields","email,motdepasse");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void CheckLoginStatus(){
        if(AccessToken.getCurrentAccessToken()!=null){
            loadUserProfil(AccessToken.getCurrentAccessToken());
        }
    }

}
