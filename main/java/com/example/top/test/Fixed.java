package com.example.top.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Fixed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixed);
        init();
    }

    public void init() {
        ArrayList<Double> list = new ArrayList<>();
        Intent intent = this.getIntent();
        String mon = intent.getStringExtra("money");

        TextView textView = (TextView) this.findViewById(R.id.textView5);
        TextView textView2 = (TextView) this.findViewById(R.id.textView6);
        TextView textView3 = (TextView) this.findViewById(R.id.textView7);
        TextView textView4 = (TextView) this.findViewById(R.id.textView8);
        TextView textView5 = (TextView) this.findViewById(R.id.textView10);
        try {
            double money = Double.parseDouble(mon);
            if(money <0){
                Intent intent3 = new Intent(this,second.class);
                startActivity(intent3);
            }
            int day = 366;
            double x = 0.95;
            if (money >= 50000000) {
                x = 1.00;
            }

            double sum1 = money * (0.85 / 100.00) * (day / 366);
            double sum2 = money * (0.85 / 100.00) * (day / 366);
            double sum3 = money * (x / 100.00) * (day / 366);
            double sum4 = money * (0.85 / 100.00) * (day / 366);
            DecimalFormat df = new DecimalFormat("0.000");

            textView.setText("" +  df.format(sum1 + money) + "฿");
            textView2.setText("" + df.format(sum2 + money)+ "฿");
            textView3.setText("" + df.format(sum3 + money) + "฿");
            textView4.setText("" + df.format(sum4 + money) + "฿");
            textView5.setText("Banks with the best interest: ");
            if (sum1 >= sum2) {
                if (sum1 >= sum3) {
                    if (sum1 >= sum4) {
                        textView5.setText("Banks with the best interest: Krungsri bank");
                    }
                }
            }
            if (sum2 >= sum1) {
                if (sum2 >= sum3) {
                    if (sum2 >= sum4) {
                        textView5.setText("Banks with the best interest: Kasikorn bank");
                    }
                }
            }
            if (sum3 >= sum1) {
                if (sum3 >= sum2) {
                    if (sum3 >= sum4) {
                        textView5.setText("Banks with the best interest: Krungthai bank");

                    }
                }
            }
            if (sum4 >= sum1) {
                if (sum4 >= sum2) {
                    if (sum4 >= sum3) {
                        textView5.setText("Banks with the best interest: SCB Bank");
                    }
                }
            }
        } catch (NumberFormatException e) {
            Intent intent2 = new Intent(this, second.class);
            startActivity(intent2);
        }
    }
}
