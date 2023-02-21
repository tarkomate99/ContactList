package com.example.contactlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ContactDetailActivity extends AppCompatActivity {

    ImageView detailImage;
    TextView emailText;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        toolbar=findViewById(R.id.toolBar2);
        setSupportActionBar(toolbar);
        detailImage = findViewById(R.id.imageView);
        emailText = findViewById(R.id.email_address);
        Picasso.get().load(getIntent().getStringExtra("imageUrl")).into(detailImage);
        detailImage.setAdjustViewBounds(true);
        detailImage.setScaleType(ImageView.ScaleType.FIT_XY);
        emailText.setText(getIntent().getStringExtra("email"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);
    }
}