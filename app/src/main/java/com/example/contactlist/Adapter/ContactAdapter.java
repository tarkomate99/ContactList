package com.example.contactlist.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.contactlist.Models.Contact;
import com.example.contactlist.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(@NonNull Context context, ArrayList<Contact> data){
        super(context, 0, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if(convertView == null){
            convertView = ((Activity)getContext()).getLayoutInflater().inflate(R.layout.contact_item, parent, false);
        }

        ImageView contactImageView = (ImageView) convertView.findViewById(R.id.contactImage);
        TextView nameTextView = (TextView) convertView.findViewById(R.id.contact_name);
        TextView emailTextView = (TextView) convertView.findViewById(R.id.contact_email);
        TextView addressTextView = (TextView) convertView.findViewById(R.id.contact_city);

        Contact contact = getItem(position);

        Picasso.get().load(contact.getImageUrl()).into(contactImageView);
        nameTextView.setText(contact.getName());
        emailTextView.setText(contact.getEmail());
        addressTextView.setText(contact.getAddress());

        return convertView;
    }

}
