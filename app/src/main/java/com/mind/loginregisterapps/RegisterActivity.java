package com.mind.loginregisterapps;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity  implements View.OnClickListener {

    private RelativeLayout rlayout;
    private Animation animation;
    private TextView tvLogin;
    private FirebaseAuth mAuth;
    private EditText userNameText,passwordText,emailText,vehiclenumberText;
    private Button signup;


    DatabaseReference databaseUser;


//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    public void loginFunc(View view)
//    {
//            Intent intent   = new Intent(RegisterActivity.this,homeActivity.class);
//            startActivity(intent);
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        Toolbar toolbar = findViewById(R.id.bgHeader);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        userNameText = findViewById(R.id.username);
        passwordText = findViewById(R.id.password);
        vehiclenumberText = findViewById(R.id.vehiclenumber);
        emailText = findViewById(R.id.email);



        mAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("users");
        findViewById(R.id.signUpButton).setOnClickListener(this);



//        String uname=userNameText.getText().toString();
//        String password=passwordText.getText().toString();
//        String email = emailText.getText().toString();
//        String vehiclenumeber = vehiclenumberText.getText().toString();
//
//

        rlayout = findViewById(R.id.rlayout);
        animation = AnimationUtils.loadAnimation(this,R.anim.uptodowndiagonal);
        rlayout.setAnimation(animation);
        tvLogin     = findViewById(R.id.tvLogin);
        signup=findViewById(R.id.signUpButton);

        signup.setOnClickListener(this);

        }

    @Override
    public void onBackPressed() {
        if (!shouldAllowBack()) {
            doSomething();
        } else {
            super.onBackPressed();
        }
    }

    private void doSomething() {
    }
    private boolean shouldAllowBack() {
        return true;
    }


    private void registerUser() {
        final String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();
        final String name=userNameText.getText().toString().trim();
        //    String phone=editTextPhone.getText().toString().trim();
        final String vehicleNumber= vehiclenumberText.getText().toString().trim();

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

        if (name.isEmpty()) {
            userNameText.setError("Name is required");
            userNameText.requestFocus();
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


//        if (phone.isEmpty()) {
//            editTextPhone.setError("Phone is required");
//            editTextPhone.requestFocus();
//            return;
//        }

//        if (!Patterns.PHONE.matcher(phone).matches()) {
//            editTextPhone.setError("Please enter a valid phone number");
//            editTextPhone.requestFocus();
//            return;
//        }

        if (vehicleNumber.isEmpty()) {
            vehiclenumberText.setError("Address is required");
            vehiclenumberText.requestFocus();
            return;
        }




        //doing so just so that our data does not get overidden everytime




     //   progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
        //        progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {

                    //    String id=databaseUser.push().getKey();//it will create unique string of the path"users"
                    // creating an unique id for the nodes

                    User newUser = new User(email,name,vehicleNumber);

                    String currentuser = FirebaseAuth.getInstance().getCurrentUser().getUid();


                    databaseUser.child(currentuser).setValue(newUser);//using child(id) to uniquely store the values under that particular id



                    finish();
                    startActivity(new Intent(RegisterActivity.this, homeActivity.class));


                } else {

                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();


                    }

                }
            }
        });




    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.signUpButton)
            registerUser();
    }
}
