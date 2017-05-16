package luongvo.com.contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Contact contact = (Contact)getIntent().getSerializableExtra("Contact");
        TextView name = (TextView)findViewById(R.id.name);
        TextView email = (TextView)findViewById(R.id.email);
        TextView phone = (TextView)findViewById(R.id.phone);

        name.setText("Name: " + contact.name);
        email.setText("Mail: " + contact.email);
        phone.setText("Phone: " + contact.phoneNumber);
    }
}
