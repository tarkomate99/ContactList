package com.example.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import com.example.contactlist.Adapter.ContactAdapter;
import com.example.contactlist.Models.Contact;

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


        //loadDataInListView();

        for(int i=0; i<20; i++){
            Contact contact = new Contact();
            contact.setName("Tarkó Máté");
            contact.setEmail("tarkomate99@gmail.com");
            contact.setAddress("Cegléd, Mező utca 27.");
            contact.setImageUrl("https://scontent-vie1-1.xx.fbcdn.net/v/t39.30808-6/324076280_852729242626815_9216464839830012081_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=dVB9Y0CZQuEAX8qkN5_&_nc_ht=scontent-vie1-1.xx&oh=00_AfA1OOXflNK8NtSW0qhrtDHw0m2rOKWOiMryLymYFAay8w&oe=63F9DA87");
            data.add(contact);
        }

        adapter = new ContactAdapter(ContactListActivity.this, data);
        contacts.setAdapter(adapter);
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





/*
                    JSONObject contact = jsonArray.getJSONObject(0);
                    String f_name = contact.getString("name.first");
                    String l_name = contact.getString("name.last");

                    Integer s_number = contact.getInt("location.street.number");
                    String s_name = contact.getString("location.street.name");
                    String city = contact.getString("location.city");

                    String email = contact.getString("email");

                    String pic = contact.getString("picture.thumbnail");

                    Contact contact1 = new Contact();
                    contact1.setName(l_name+" "+f_name);
                    contact1.setAddress(city+", "+s_name+" "+s_number);
                    contact1.setEmail(email);
                    contact1.setImageUrl(pic);
                    data.add(contact1);
*/



        adapter = new ContactAdapter(ContactListActivity.this, data);
        contacts.setAdapter(adapter);
    }


}