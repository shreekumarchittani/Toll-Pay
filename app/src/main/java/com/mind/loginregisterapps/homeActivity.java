package com.mind.loginregisterapps;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;


public class homeActivity extends AppCompatActivity {

    private Button proceedButton;
    private EditText locationText;
    private static String value;
    public static String getValue() {
        return value;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        proceedButton=findViewById(R.id.ProceedButton);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPurple)));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        locationText=findViewById(R.id.LocationText);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.logout){
            // do something
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(this, SignInActivity.class));
        }
        else if(id==R.id.reciept){
            Intent intent = new Intent(homeActivity.this,receiptactivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
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
        return false;
    }

    public void myfunc(View view)
    {
        value=locationText.getText().toString();
        if (value.matches("honnavara")||value.matches("chennai")) {
            Intent intent = new Intent(homeActivity.this, paymentActivity.class);
            startActivity(intent);
        }
        else
        {
            locationText.setError("Enter valid location");
        }
    }
}
