package com.example.example3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.example3.VO.ContactItem;
import com.example.example3.adapter.ContactRecyclerAdapter;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ContactRecyclerAdapter contactRecyclerAdapter;
    private ArrayList<ContactItem> contactItems;

    ImageView phoneImageView;
    TextView contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        recyclerView = findViewById(R.id.recyclerView);

        contactRecyclerAdapter = new ContactRecyclerAdapter();
        recyclerView.setAdapter(contactRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));

        contactItems = new ArrayList<>();
        contactItems.add(new ContactItem("최지수", "010-4277-2298"));
        contactItems.add(new ContactItem("최사원", "010-000-0000"));
        contactRecyclerAdapter.setContactList(contactItems);




    }
}