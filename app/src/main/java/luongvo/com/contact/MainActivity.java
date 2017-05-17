package luongvo.com.contact;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

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
        checkCallPermission();

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
    // check for permission
    public final static int REQUEST_CODE_FOR_CALL_PERMISSION = 9999;
    public String[] permissions = new String[] {Manifest.permission.CALL_PHONE};
    public void checkCallPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) return;
        }
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this,
                    permissions,
                    REQUEST_CODE_FOR_CALL_PERMISSION);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == REQUEST_CODE_FOR_CALL_PERMISSION) {
                Toast.makeText(this, "Please Grant Call Access!", Toast.LENGTH_SHORT).show();
                for (int i = 0; i < permissions.length; i++) {
                    String permission = permissions[i];
                    int grantResult = grantResults[i];

                    if(permission.equals(Manifest.permission.CALL_PHONE)) {
                        if (grantResult == PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                        else
                            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_FOR_CALL_PERMISSION);
                    }
                }
            }
    }
}
