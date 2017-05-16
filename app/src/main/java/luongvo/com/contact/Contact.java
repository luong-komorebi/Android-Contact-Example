package luongvo.com.contact;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by luongvo on 15/05/2017.
 */

class Contact implements Serializable {
    String email;
    String name;
    String phoneNumber;

    public Contact(String email, String name, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


}
