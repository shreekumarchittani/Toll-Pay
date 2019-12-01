package com.mind.loginregisterapps;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import android.support.annotation.NonNull;
import android.util.Patterns;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton btRegister;
    private TextView tvLogin;
    private Button loginButton;
    private EditText emailText,passwordText;

    FirebaseAuth mAuth;
   // EditText emailText, passwordText;

//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    public void loginFunc(View view)
//    {
//        String a=userNameText.getText().toString();
//        String b=passwordText.getText().toString();
//        if (a.equals("abc")&&b.equals("abc"))
//        {
//            Intent intent   = new Intent(SignInActivity.this,homeActivity.class);
//            Pair[] pairs    = new Pair[1];
//            pairs[0] = new Pair<View,String>(tvLogin,"tvLogin");
//            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SignInActivity.this,pairs);
//            startActivity(intent,activityOptions.toBundle());
//        }
//    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_main);
        btRegister  = findViewById(R.id.btRegister);
        tvLogin     = findViewById(R.id.tvLogin);
        loginButton=findViewById(R.id.loginButton);
        emailText=findViewById(R.id.emailText);
        passwordText=findViewById(R.id.passwordText);
        btRegister.setOnClickListener(this);
        loginButton.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.reciept){
            // do something
        }
        return super.onOptionsItemSelected(item);
    }




    private void userLogin() {
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();

        if (email.isEmpty()) {
            emailText.setError("Email is required");
            emailText.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("Please enter a valid email");
            emailText.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            passwordText.setError("Password is required");
            passwordText.requestFocus();
            return;
        }

        if (password.length() < 6) {
            passwordText.setError("Minimum lenght of password should be 6");
            passwordText.requestFocus();
            return;
        }

       // progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    finish();
                    Intent intent = new Intent(SignInActivity.this, homeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

   @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        if (v==btRegister){
            Intent intent   = new Intent(SignInActivity.this,RegisterActivity.class);
            Pair[] pairs    = new Pair[1];
            pairs[0] = new Pair<View,String>(tvLogin,"tvLogin");
            ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SignInActivity.this,pairs);
            startActivity(intent,activityOptions.toBundle());
        }
        if(v.getId()==R.id.loginButton){
            userLogin();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, homeActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        if (!shouldAllowBack()) {
            finishAffinity();
        } else {
            super.onBackPressed();
        }
    }

    private void doSomething() {
    }
    private boolean shouldAllowBack() {
        return false;
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//             case R.id.loginButton:
//                userLogin();
//                break;
//        }
//    }
}
