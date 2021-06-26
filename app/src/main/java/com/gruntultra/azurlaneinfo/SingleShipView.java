package com.gruntultra.azurlaneinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SingleShipView extends AppCompatActivity {
    Ship ship;
    TextView shipName;
    TextView factionName;
    TextView hullType;
    TextView health;
    ImageView shipImage;
    HorizontalBarChart statChart;
    ListView lstView;
    ListView skinView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_ship_view);
        ship = (Ship) getIntent().getSerializableExtra("Ships");
        shipName = (TextView) findViewById(R.id.shipName);
        factionName = (TextView) findViewById(R.id.factionName);
        shipImage = (ImageView) findViewById(R.id.shipImg);
        hullType = (TextView) findViewById(R.id.hullType);
        health = (TextView) findViewById(R.id.health);
        statChart = (HorizontalBarChart) findViewById(R.id.barStats);
        shipName.setText(ship.getNames().getEn());
        factionName.setText(ship.getNationality());
        health.setText("HP: " + ship.getStats().getLevel120().getHealth());
        hullType.setText(ship.getHullType());
        String url = ship.getSkins().get(0).getImage();
        Picasso.get().load(url).into(shipImage);
        BarDataSet barDataSet1 = new BarDataSet(dataValues(), "Ship Stats");
        BarData barData = new BarData();
        float barWidth = 0.20f;
        barData.setBarWidth(barWidth);
        barData.addDataSet(barDataSet1);
        String[] xAxisLabels = new String[]{"Firepower", "Torpedo", "Evasion", "AntiAir","Aviation",
        "Reload", "AntiSubWarfare", "Luck"};
        Collections.reverse(Arrays.asList(xAxisLabels));
        statChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(xAxisLabels));
        statChart.getAxisLeft().setDrawGridLines(false);
        statChart.setScaleEnabled(false);
        statChart.getAxisLeft().setEnabled(false);
        statChart.getAxisRight().setEnabled(false);
        statChart.getXAxis().setDrawAxisLine(false);
        statChart.getXAxis().setDrawGridLines(false);
        statChart.getDescription().setEnabled(false);
        statChart.getLegend().setEnabled(false);
        statChart.getAxisRight().setDrawGridLines(false);
        statChart.setData(barData);
        statChart.invalidate();
        lstView = (ListView) findViewById(R.id.skillView);
        SkillAdapter adapter = new SkillAdapter(this, R.layout.adapter_view_skill_layout, ship.getSkills());
        lstView.setAdapter(adapter);
        skinView = (ListView) findViewById(R.id.skinView);
        SkinAdapter sAdapter = new SkinAdapter(this,R.layout.adapter_view_skin_layout, ship.getSkins());
        skinView.setAdapter(sAdapter);
        skinView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(SingleShipView.this, SkinView.class);
                intent.putExtra("urlImg",ship.getSkins().get(i).getImage());
                startActivity(intent);
            }
        });
    }

    private ArrayList<BarEntry> dataValues() {
        ArrayList<BarEntry> dataval = new ArrayList<>();
        int firepower;
        int torpedo;
        int evasion;
        int antiair;
        int aviation;
        int reload;
        int antisubmarine;
        int luck;
        if(ship.getStats().getLevel120Retrofit() == null){
            firepower = Integer.parseInt(ship.getStats().getLevel120().getFirepower());
            torpedo = Integer.parseInt(ship.getStats().getLevel120().getTorpedo());
            evasion = Integer.parseInt(ship.getStats().getLevel120().getEvasion());
            antiair = Integer.parseInt(ship.getStats().getLevel120().getAntiair());
            aviation = Integer.parseInt(ship.getStats().getLevel120().getAviation());
            reload = Integer.parseInt(ship.getStats().getLevel120().getReload());
            antisubmarine = Integer.parseInt(ship.getStats().getLevel120().getAntisubmarineWarfare());
            luck = Integer.parseInt(ship.getStats().getLevel120().getLuck());
        } else {
            firepower = Integer.parseInt(ship.getStats().getLevel120Retrofit().getFirepower());
            torpedo = Integer.parseInt(ship.getStats().getLevel120Retrofit().getTorpedo());
            evasion = Integer.parseInt(ship.getStats().getLevel120Retrofit().getEvasion());
            antiair = Integer.parseInt(ship.getStats().getLevel120Retrofit().getAntiair());
            aviation = Integer.parseInt(ship.getStats().getLevel120Retrofit().getAviation());
            reload = Integer.parseInt(ship.getStats().getLevel120Retrofit().getReload());
            antisubmarine = Integer.parseInt(ship.getStats().getLevel120Retrofit().getAntisubmarineWarfare());
            luck = Integer.parseInt(ship.getStats().getLevel120Retrofit().getLuck());
        }
        dataval.add(new BarEntry(7, firepower));
        dataval.add(new BarEntry(6, torpedo));
        dataval.add(new BarEntry(5, evasion));
        dataval.add(new BarEntry(4, antiair));
        dataval.add(new BarEntry(3, aviation));
        dataval.add(new BarEntry(2, reload));
        dataval.add(new BarEntry(1, antisubmarine));
        dataval.add(new BarEntry(0, luck));
        return dataval;
    }
}