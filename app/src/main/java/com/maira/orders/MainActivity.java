package com.maira.orders;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void order(View view) {
        double plainPizza=6;
        double bacon=0.7;
        double cheese=0.5;
        double peppers=0.4;
        double pepperoni=0.6;
        double tomatos=0.3;
        double totalPrice=plainPizza;
        String emailMessage;
        emailMessage = "You ordered a pizza with ";

        String[] address = new String[1];
        EditText e = (EditText) findViewById(R.id.customerEmail);
        EditText n = (EditText) findViewById(R.id.customerName);

        String custName = n.getText().toString();
        String custMail = e.getText().toString();

        Log.i("MAIRA", custName);
        Log.i("MAIRA", custMail);

        CheckBox cheeseCB = (CheckBox) findViewById(R.id.cheese);
        CheckBox baconCB = (CheckBox) findViewById(R.id.bacon);
        CheckBox peppersCB = (CheckBox) findViewById(R.id.peppers);
        CheckBox pepperoniCB = (CheckBox) findViewById(R.id.pepperoni);
        CheckBox tomatosCB = (CheckBox) findViewById(R.id.tomatos);

        if (cheeseCB.isChecked()) {
            totalPrice+=cheese;
            emailMessage += " Cheese ";
        }
        if (baconCB.isChecked()) {
            totalPrice+=bacon;
            emailMessage += " Bacon ";
        }
        if (peppersCB.isChecked()) {
            totalPrice+=peppers;
            emailMessage += " Peppers ";
        }
        if (pepperoniCB.isChecked()) {
            totalPrice+=pepperoni;
            emailMessage += " Pepperoni ";
        }
        if (tomatosCB.isChecked()) {
            totalPrice+=tomatos;
            emailMessage += " Tomatoes ";
        }

        Log.i("MAIRA", totalPrice+"");

        TextView tp = (TextView) findViewById(R.id.totalPriceTV);
        tp.setText(String.format("%12s %5.2f", "Total Cost:" , totalPrice));


        if (custName.length()==0)
            Toast.makeText(getApplicationContext(),"Please type your name first...",Toast.LENGTH_LONG).show();
        else
            if (custMail.length()==0)
            Toast.makeText(getApplicationContext(),"Please type your email first...",Toast.LENGTH_LONG).show();
            else {
                Toast.makeText(getApplicationContext(),"Your Order has been placed",Toast.LENGTH_LONG).show();
                address[0] = custMail;
                emailMessage += String.format(" %n and the total cost is %3.2f",totalPrice);
                composeEmail(address, "Pizza Order", emailMessage);
            }
    }

    public void composeEmail(String[] addresses, String subject, String emailMessage) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
