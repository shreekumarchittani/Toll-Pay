package com.mind.loginregisterapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class paymentActivity extends AppCompatActivity {

    private ListView routeList;
    private HashMap<String,ArrayList>map;
    private ArrayList<String>routes;
    private TextView textView;
    private Button proceed;
    private String locations;
    public static int route;
    public static int getValue() {
        return route;
    }
    private void work(int i)
    {
        if(i==1)
        {
            routes.add("Route 1                                             Rs.100");
            routes.add("Route 2                                             Rs.140");
        }
        else
        {
            routes.add("Route 1                                             Rs.120");
            routes.add("Route 2                                             Rs.100");
        }
    }
    public void myFunc(View view)
    {
        Intent intent = new Intent(paymentActivity.this, tollActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        map=new HashMap<String, ArrayList>();
        routeList=findViewById(R.id.routeList);
        textView=findViewById(R.id.textView);
        proceed=findViewById(R.id.ProceedButton);
        locations=homeActivity.getValue();
        textView.setText(""+locations);
        routes=new ArrayList<String>();
        work(1);
        map.put("honnavara",routes);
        routes=new ArrayList<String>();
        work(2);
        map.put("chennai",routes);

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,map.get(locations));
        routeList.setAdapter(adapter);
        routeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                route=i;
                proceed.setVisibility(View.VISIBLE);
                proceed.setEnabled(true);
            }
        });
    }
}