package com.example.review;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    String address="2nd Floor,Hno 12,Road no.37,Back side of MSG hospital, West Punjabi Bagh, Punjabi Bagh,Delhi 110026,India";
    TableRow cooking,picked,onway,delivered;
    Button trackOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cooking=findViewById(R.id.cooking);
        picked=findViewById(R.id.picked);
        onway=findViewById(R.id.onWay);
        delivered=findViewById(R.id.delivered);
        trackOrder= findViewById(R.id.trackOrder);

        trackOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://maps.google.com/maps?daddr="+address;
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,  Uri.parse(url));
                startActivity(intent);
            }
        });

        startProcess();

    }

    public void startProcess()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cooking.setBackgroundColor(Color.RED);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        picked.setBackgroundColor(Color.RED);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                onway.setBackgroundColor(Color.RED);

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        delivered.setBackgroundColor(Color.RED);
                                    }
                                },5000);
                            }
                        },5000);


                    }
                },5000);
            }
        },5000);


    }
}