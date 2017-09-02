package cl.anpetrus.ejerciciobicicletas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import cl.anpetrus.ejerciciobicicletas.data.Nodes;
import cl.anpetrus.ejerciciobicicletas.models.Bike;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button createBikesBtn = (Button) findViewById(R.id.createBikeBtn);
        createBikesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = new Nodes().bikes().push().getKey();
                Bike bike = new Bike();
                bike.setKey(key);
                bike.setTitle("Bicicleta 1");
                bike.setDescription("Descripcion 1");
                bike.setPhoto("www.bikes.cl/photos/bikes/"+key+".jpg");
                bike.setContactPhone("+56987632323");
                new Nodes().bike(key).setValue(bike);

                key = new Nodes().bikes().push().getKey();
                bike.setKey(key);
                bike.setTitle("Bicicleta 2");
                bike.setDescription("Descripcion 2");
                bike.setPhoto("www.bikes.cl/photos/bikes/"+key+".jpg");
                bike.setContactPhone("+56899593405");
                new Nodes().bike(key).setValue(bike);
            }
        });

        Button motivationalBtn = (Button) findViewById(R.id.motivationalBtn);
        motivationalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Nodes().quote("20170524").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Log.d("FRASE", dataSnapshot.getValue(String.class));
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });
    }


}
