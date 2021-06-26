package com.gruntultra.azurlaneinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button update;
    Button imgUpdate;
    ImageButton shipView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fetchData updateStart = new fetchData((getBaseContext()));
        updateStart.execute();
        update = (Button) findViewById(R.id.updateButton);
        imgUpdate = (Button) findViewById(R.id.updateImageButton);
        shipView = (ImageButton) findViewById(R.id.shipView);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Downloading....", Toast.LENGTH_SHORT).show();
                fetchData update = new fetchData(getBaseContext());
                update.execute();

                //update
            }
        });

        imgUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(), "Downloading images...", Toast.LENGTH_SHORT).show();

                downloadImg updateImg = new downloadImg(getBaseContext());
                updateImg.loadImage();
                Toast.makeText(getBaseContext(), "Images Done", Toast.LENGTH_SHORT).show();
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