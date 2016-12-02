package com.example.top.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class saving extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving);
        init();
    }
    public void  init(){
        Intent intent = this.getIntent();
        String mon = intent.getStringExtra("money");

        TextView textView =(TextView)this.findViewById(R.id.textView);
        TextView textView2 =(TextView)this.findViewById(R.id.textView2);
        TextView textView3 =(TextView)this.findViewById(R.id.textView3);
        TextView textView4 =(TextView)this.findViewById(R.id.textView4);
        TextView textView5 =(TextView)this.findViewById(R.id.textView11);
        try{
            double money = Double.parseDouble(mon);
            if(money <0){
                Intent intent3 = new Intent(this,second.class);
                startActivity(intent3);
            }
            int day = 366;
            double sum1 = money * (0.5 / 100.00) * (day / 366);
            double sum2 = money * (0.5 / 100.00) * (day / 366);
            double sum3 = money * (0.3 / 100.00) * (day / 366);
            double sum4 = money * (0.5 / 100.00) * (day / 366);

            DecimalFormat df = new DecimalFormat("0.000");
            textView.setText(""+ df.format(sum1 + money) + "฿");
            textView2.setText(""+ df.format(sum2 + money)+ "฿");
            textView3.setText(""+ df.format(sum3 + money)+ "฿");
            textView4.setText(""+ df.format(sum1 + money)+ "฿");

            if(sum1>=sum2){
                if(sum1>=sum3){
                    if(sum1>=sum4){
                        textView5.setText("Banks with the best interest: Krungsri bank");
                    }
                }
            }
            if(sum2>=sum1) {
                if (sum2>=sum3){
                    if(sum2>=sum4){
                        textView5.setText("Banks with the best interest: Kasikorn bank");
                    }
                }
            }
            if(sum3>= sum1){
                if (sum3>=sum2){
                    if (sum3>=sum4){
                        textView5.setText("Banks with the best interest: Krungthai bank");

                    }
                }
            }
            if(sum4>=sum1){
                if (sum4>=sum2){
                    if (sum4>=sum3){
                        textView5.setText("Banks with the best interest: SCB Bank");
                    }
                }
            }
        } catch (NumberFormatException e){
            Intent intent1 = new Intent(this, second.class);
            startActivity(intent1);
        }

    }
    }

