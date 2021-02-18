package com.example.demoapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ImageButton del;

    ArrayList<String> list;
    ArrayList<String> fnamelist;
    ArrayAdapter<String> adapter;
    UserData fds;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        fds=new UserData();

        listView=view.findViewById(R.id.listview);

        database=FirebaseDatabase.getInstance();
        ref=database.getReference("UserData");

        list=new ArrayList<>();
        fnamelist=new ArrayList<>();
        adapter=new ArrayAdapter<String>(getContext(),R.layout.user_info_text,R.id.userInfo,list);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    fds=ds.getValue(UserData.class);
                    String fn=fds.getFname();
                    list.add("  "+fn.toString()+" "+fds.getLname().toString()+"\n Age :"+fds.getAge().toString()+" | Gender "+fds.getGender().toString()+"\n Country:"+fds.getCountry().toString());
                    fnamelist.add(fds.getFname());
                }
                listView.setAdapter(adapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        del=view.findViewById(R.id.del);

        listView.setOnItemClickListener(new  AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                list.remove(position);
                adapter.notifyDataSetChanged();

            }
        });
//        del.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final int position = listView.getPositionForView((View) v.getParent());
//                String rmvitem=fnamelist.get(position);
//                DatabaseReference Item=FirebaseDatabase.getInstance().getReference("UserData").child(rmvitem);
//                Item.removeValue();
//
//
//            }
//        });


        return view;

    }



}
