package cl.anpetrus.ejerciciobicicletas.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Nodes {
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    public DatabaseReference bikes(){
        return root.child("bikes");
    }

    public DatabaseReference quotes(){
        return root.child("quotes");
    }


    public DatabaseReference bike(String key){
        return bikes().child(key);
    }

    public DatabaseReference quote(String key){
        return quotes().child(key);
    }

}
