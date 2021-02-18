package com.example.demoapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Fragment2 extends Fragment {
    FirebaseDatabase db1;
    DatabaseReference ref;
    EditText t1,t2,t3,t4,t5,t6,t7,t8,t9;
    Button s1;
    String user;

    UserData ud1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        t1 =  view.findViewById(R.id.fname);
        t2= view.findViewById(R.id.lname);
        t3= view.findViewById(R.id.dob);

        t4= view.findViewById(R.id.gender);
        t5= view.findViewById(R.id.country);
        t6=view.findViewById(R.id.state);
        t7=view.findViewById(R.id.hometown);
        t8=view.findViewById(R.id.phnnum);
        t9=view.findViewById(R.id.telnum);
        s1= view.findViewById(R.id.adduser);

        db1=FirebaseDatabase.getInstance();
        ref=db1.getReference();

        ud1=new UserData();
        s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user=t1.getText().toString().trim();
                ud1.setFname(t1.getText().toString().trim());
                ud1.setLname(t2.getText().toString().trim());
                ud1.setAge(t3.getText().toString().trim());
                ud1.setGender(t4.getText().toString().trim());
                ud1.setCountry(t5.getText().toString().trim());
                ud1.setState(t6.getText().toString().trim());
                ud1.setHometown(t7.getText().toString().trim());
                ud1.setPhnnum(t8.getText().toString().trim());
                ud1.setTelnum(t9.getText().toString().trim());


                ref.child("UserData").child(user).setValue(ud1);


                Toast.makeText(getContext(),"User Data Added Successfully",Toast.LENGTH_LONG).show();

            }
        });

        return view;

    }


}
