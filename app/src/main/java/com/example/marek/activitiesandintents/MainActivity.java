package com.example.marek.activitiesandintents;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //once the activity is created let's assign some code to the Button when it is clicked
        Button msgButton = (Button)findViewById(R.id.a2_button);
        //assign code to the onClickListener by defining
        //an anonymous subclass of OnClickListener and overriding its onClickMethod
        //notice here we are calling new and passing the created OnClickListener to the "setOnClickListener" method instead of storing the reference as a variable
        //while at the same time overriding the onClick method. This is a common pattern seen in Java "in the wild"
        msgButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent msg_intent = new Intent("com.seneca.lab2b.Matt");
                startActivityForResult(msg_intent, 1);
            }
        });
        Button a3Button = (Button)findViewById(R.id.a3_button);
        a3Button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // When sending an explicit intent use the intent(context, intent) constructor
                Intent msg_intent = new Intent(v.getContext(),ThirdActivity.class);
                startActivity(msg_intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = "RESULT NOT SET";

        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                result = data.getStringExtra("message");
            }else if(resultCode == Activity.RESULT_CANCELED){

            }
        }
        else{
            Log.e("lab2", "SOMETHING WENT WRONG");
        }
        TextView text = (TextView)findViewById(R.id.textView);
        text.setText(result);
    }
}
