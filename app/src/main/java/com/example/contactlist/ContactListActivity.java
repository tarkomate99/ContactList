package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.contactlist.Adapter.ContactAdapter;
import com.example.contactlist.Models.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ListView contacts;
    ArrayList<Contact> data;
    ContactAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contactlist);
        toolbar=findViewById(R.id.ToolBar);
        toolbar.setTitle("CodeYard");
        setSupportActionBar(toolbar);

        contacts = findViewById(R.id.contactList);
        data = new ArrayList<>();


        loadDataInListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return true;
    }

    private void loadDataInListView(){
        
        RequestQueue volleyQueue = Volley.newRequestQueue(ContactListActivity.this);

        String url = "https://randomuser.me/api/?results=20";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                (Response.Listener<JSONObject>) res -> {
                    String f_name;
                    String l_name;
                    String email;
                    String city;
                    Integer number;
                    String street;
                    String imageUrl;
                    String mobile;
                    String work;
                    try {

                        JSONArray jsonArray = res.getJSONArray("results");
                        for(int i=0;i<jsonArray.length();i++){
                            JSONObject contact = jsonArray.getJSONObject(i);
                            f_name = contact.getJSONObject("name").getString("first");
                            l_name = contact.getJSONObject("name").getString("last");
                            email = contact.getString("email");
                            city = contact.getJSONObject("location").getString("city");
                            number = contact.getJSONObject("location").getJSONObject("street").getInt("number");
                            street = contact.getJSONObject("location").getJSONObject("street").getString("name");
                            imageUrl = contact.getJSONObject("picture").getString("large");
                            mobile = contact.getString("phone");
                            work = contact.getString("cell");

                            Contact contact1 = new Contact();
                            contact1.setId(i);
                            contact1.setName(f_name+" "+l_name);
                            contact1.setAddress(city+", "+street+" "+number);
                            contact1.setEmail(email);
                            contact1.setImageUrl(imageUrl);
                            contact1.setMobile(mobile);
                            contact1.setWork(work);
                            data.add(contact1);
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },


                (Response.ErrorListener) error -> {
                    Toast.makeText(ContactListActivity.this, "Error! Cannot fetch!", Toast.LENGTH_LONG).show();

                    Log.e("ContactListActivity","error: ${error.localizedMessage}");
                }
        );

        volleyQueue.add(jsonObjectRequest);

        adapter = new ContactAdapter(ContactListActivity.this, data);
        contacts.setAdapter(adapter);

        contacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ContactListActivity.this, ContactDetailActivity.class);
                TextView name = view.findViewById(R.id.contact_name);
                TextView email = view.findViewById(R.id.contact_email);
                ImageView image = view.findViewById(R.id.contactImage);
                Contact contact = data.get(i);
                intent.putExtra("name", contact.getName());
                intent.putExtra("email", contact.getEmail());
                intent.putExtra("imageUrl", contact.getImageUrl());
                intent.putExtra("mobile", contact.getMobile());
                intent.putExtra("work", contact.getWork());

                startActivity(intent);
            }
        });
    }


}