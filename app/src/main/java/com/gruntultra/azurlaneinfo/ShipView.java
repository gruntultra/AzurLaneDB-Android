package com.gruntultra.azurlaneinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ShipView extends AppCompatActivity {
    private static final String File_Name = "ships.json";
    ListView lst;
    private ShipAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_view);
        String data = loadData();
        Gson gson = new Gson();
        final Ship[] ships = gson.fromJson(data, Ship[].class);
        ArrayList<Ship> lstShips = new ArrayList<Ship>(Arrays.asList(ships));
        initSearchWidgets(lstShips);
        lst = (ListView) findViewById(R.id.listview);
        ShipAdapter adapter = new ShipAdapter(this, R.layout.adapter_view_layout, lstShips);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ShipView.this, SingleShipView.class);
                intent.putExtra("Ships", ships[i]);
                startActivity(intent);
            }
        });
    }

    public String loadData() {
        String data = "";
        FileInputStream fis = null;
        try {
            fis = openFileInput(File_Name);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            data = br.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return data;
    }

    private void initSearchWidgets(ArrayList<Ship> iShips) {
        final ArrayList<Ship> ships = iShips;
        SearchView searchView = (SearchView) findViewById(R.id.shipListSearchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<Ship> filteredShips = new ArrayList<Ship>();
                for(Ship ship:ships) {
                    if(ship.getNames().getEn().toLowerCase().contains(s.toLowerCase())) {
                        filteredShips.add(ship);
                    }
                }
                try {
                    final ShipAdapter filAdapter = new ShipAdapter(getApplicationContext(),  R.layout.adapter_view_layout,filteredShips);
                    lst.setAdapter(filAdapter);
                    lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            int actualPosition = ships.indexOf(filAdapter.getItem(i));
                            //System.out.println(ships.indexOf(filAdapter.getItem(i)));
                            Intent intent = new Intent(ShipView.this, SingleShipView.class);
                            intent.putExtra("Ships", ships.get(actualPosition));
                            startActivity(intent);
                        }
                    });
                } catch(Exception ex) {
                }

                return false;
            }
        });
    }

}