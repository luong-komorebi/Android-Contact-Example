package luongvo.com.contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Contact> contacts = getContactList();
        ContactAdapter contactAdapter = new ContactAdapter(this, contacts);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(contactAdapter);
    }
    public ArrayList<Contact> getContactList() {
        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("vttluong@apcs.vn", "Vo Tran Thanh Luong", "020142141"));
        contacts.add(new Contact("vttluong@apcs.vn", "Dinh Le Vi Du", "0265141"));
        contacts.add(new Contact("vttluong@apcs.vn", "Nguyen Ma Song", "365475468"));
        contacts.add(new Contact("vttluong@apcs.vn", "Tran Dinh Nguyen", "23453468"));
        contacts.add(new Contact("vttluong@apcs.vn", "Ho Van Hue", "1195678"));
        return contacts;
    }
}
