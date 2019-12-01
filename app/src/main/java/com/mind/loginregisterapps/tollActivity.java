package com.mind.loginregisterapps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class tollActivity extends AppCompatActivity implements View.OnClickListener {

    private String location;
    private int route;
    private TextView displaytext;
    private ListView routeList;
    private ArrayList<String>arrayList;
    private Button proceedButton;
    private int id;
    private void work(String a,int i)
    {
        if(a.matches("honnavara"))
        {
            if (i==0)
            {

                arrayList.add("Nelmangala                                                Rs.60");
                arrayList.add("Haveri                                                          Rs.40");
                arrayList.add("Total                                                            Rs.100");
                id=100;

            }
            else
            {

                arrayList.add("Tumkur                                                       Rs.70");
                arrayList.add("Thavare Koppa                                          Rs.40");
                arrayList.add("Shivamogga                                              Rs.30");
                arrayList.add("Total                                                           Rs.140");
                id=140;
            }
        }
        else
        {
            if (i==0)
            {

                arrayList.add("Hosur                                                          Rs.50");
                arrayList.add("Vellore                                                        Rs.40");
                arrayList.add("Kanchipuram                                             Rs.30");
                arrayList.add("Total                                                            Rs.120");
                id=120;
            }
            else
            {

                arrayList.add("Kolar                                                            Rs.30");
                arrayList.add("Chittor                                                          Rs.30");
                arrayList.add("Arcot                                                            Rs.40");
                arrayList.add("Total                                                            Rs.100");
                id=100;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toll);

        proceedButton=findViewById(R.id.ProceedButton);
        arrayList=new ArrayList<String>();
        location=homeActivity.getValue();
        route=paymentActivity.getValue();
        displaytext=findViewById(R.id.displayText);
        displaytext.setText("Bengaluru - "+location);
        routeList=findViewById(R.id.routeList);
        work(location,route);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        routeList.setAdapter(adapter);
        proceedButton.setOnClickListener(this);

    }

    private void proccedtoPayment() {

        String url;
        Intent i=new Intent(Intent.ACTION_VIEW);
        if(id==100){

             url="https://easebuzz.in/quickpay/llprmefgdr";
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        if(id==120){

            url="https://easebuzz.in/quickpay/quujwoqnhy";
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        if(id==140){
            url="https://easebuzz.in/quickpay/bmtlwexvhq";
            i.setData(Uri.parse(url));
            startActivity(i);
        }




    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.ProceedButton)
            proccedtoPayment();
    }
}