package com.mind.loginregisterapps;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class receiptactivity extends AppCompatActivity {

    private TextView recieptno,amount,destination;
    DatabaseReference vnumberdatabse ;//getting vehicle number from "users"
    DatabaseReference receiptdatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiptactivity);

        recieptno=findViewById(R.id.recieptno);
        amount=findViewById(R.id.amount);
        destination=findViewById(R.id.destination);

//        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
//
//        vnumberdatabse = FirebaseDatabase.getInstance().getReference("users");
//
//
//
//
//        DatabaseReference userVehiclNumberRef = vnumberdatabse.child(uid).child("vehicleNumber");
//        final String[] currentVehicleNumber = new String[1];
//
//        userVehiclNumberRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                currentVehicleNumber[0] = dataSnapshot.getValue(String.class);
//                //do what you want with the email
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//
//
//        Log.i("app", "onDataChange: "+ currentVehicleNumber[0]);
//
//
//        receiptdatabase=FirebaseDatabase.getInstance().getReference("receipts");
//
//        receiptdatabase.addListenerForSingleValueEvent(new ValueEventListener()
//        {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                //onDataChange will be executed everytime we will make any changes to the database
//                //used to read the values of FireBase Database.
//                //returns all the values inside the specified references.
//                //it will contain all the data inside the "dataSnapshot" object.
//
//              //  shareItems.clear(); //req. to remove multiple insertions of the same users.
//                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
//                    Receipt receipt = userSnapshot.getValue(Receipt.class);
//                   // shareItems.add(shareItem);
//                    Log.i("app", "onDataChange: "+receipt.getRno());
//
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//
//






    }
}
