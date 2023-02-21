package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ContactDetailActivity extends AppCompatActivity {

    ImageView detailImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        detailImage = findViewById(R.id.imageView);
        Picasso.get().load(getIntent().getStringExtra("imageUrl")).into(detailImage);
    }
}