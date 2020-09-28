package com.gruntultra.azurlaneinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button update;
    ImageButton shipView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchData updateStart = new fetchData((getBaseContext()));
        updateStart.execute();
        update = (Button) findViewById(R.id.updateButton);
        shipView = (ImageButton) findViewById(R.id.shipView);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Downloading...", Toast.LENGTH_SHORT).show();
                fetchData update = new fetchData(getBaseContext());
                update.execute();

                //update
            }
        });

        shipView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShipView();
            }
        });
    }

    public void openShipView() {
        Intent intent = new Intent(this, ShipView.class);
        startActivity(intent);
    }

}