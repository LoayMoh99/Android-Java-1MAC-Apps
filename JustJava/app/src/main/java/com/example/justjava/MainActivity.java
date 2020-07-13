package com.example.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    //get the spinner from the xml.
    private Spinner dropdown ;
    //create a list of items for the spinner.
    private static String[] items = new String[]{"Latte $5 ", "Espresso $7 ", "Capiccino $3 "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dropdown=findViewById(R.id.spinner1);
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                priceVal=5;
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                priceVal=7;
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                priceVal=3;
                break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //  Auto-generated method stub
        priceVal=0;
    }
    String name="";
    public String getName(){
        EditText nameET = findViewById(R.id.name_view);
        return nameET.getText().toString();
    }

    boolean whiteCream=false;
    boolean chocolate=false;
    //Another way to get the object of the CheckBoxes by there Id and call the isCheckedMethod .. which i think is better..
    /**
     * This method is called when the white cream's checkBox is selected.
     */
    public void whiteCreamAdd(View view) {
        whiteCream=!whiteCream;
        if(whiteCream)priceVal+=1;
        else priceVal-=1;
    }

    /**
     * This method is called when the chocolate's checkBox is selected.
     */
    public void chocolateAdd(View view) {
        chocolate=!chocolate;
        if(chocolate)priceVal+=2;
        else priceVal-=2;
    }

    int noOrder=2;
    int priceVal=0;
    /**
     * This method is called when the + button is clicked.
     */
    public void addOrder(View view) {
        if(noOrder<100)noOrder++;
        else noOrder=100;
        display(noOrder);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void removeOrder(View view) {
        if(noOrder>1)noOrder--;
        else noOrder=1;
        display(noOrder);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        String price;
//        int total =calcPrice(noOrder,priceVal);
//        price=createOrderSummary(total,noOrder);
//        displayPrice(price);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee Order of "+getName());
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(calcPrice(noOrder,priceVal),noOrder));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calcPrice(int ord,int price){
        return ord*price;
    }

    private String createOrderSummary(int total,int ordNo){
        return "Name: "+getName()+"\nWhite Cream Topping->"+whiteCream+"\nChocolate Topping->"+chocolate+"\nQuantity: "+ordNo+"\nTotal: $"+ total +"\nThank you!";
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}
