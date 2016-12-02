package com.example.top.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        inbt();
        onbt();

    }
    public void inbt(){
        final Button button = (Button)this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)second.this.findViewById(R.id.editText2);
                String money = editText.getText().toString();

                Intent intent = new Intent(second.this,saving.class);
                intent.putExtra("money",money);
                second.this.startActivityForResult(intent,second.RESULT_OK);
            }
        });
    }
    public void onbt(){
        final Button button = (Button)this.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText)second.this.findViewById(R.id.editText2);
                String money = editText.getText().toString();

                Intent intent = new Intent(second.this,Fixed.class);
                intent.putExtra("money",money);
                second.this.startActivityForResult(intent,second.RESULT_OK);
            }
        });
    }
}
