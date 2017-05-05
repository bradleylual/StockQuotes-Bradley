package com.introtoandroid.stockquotes_bradley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;

public class StockActivity extends AppCompatActivity {

    private TextView enterText;
    private TextView symbolText;
    private TextView nameText;
    private TextView tradePriceText;
    private TextView tradeTimeText;
    private TextView changeText;
    private TextView rangeText;
    private TextView symbolOut;
    private TextView nameOut;
    private TextView tradePriceOut;
    private TextView tradeTimeOut;
    private TextView changeOut;
    private TextView rangeOut;
    private EditText symbolInput;

    public boolean search = false;

    public String symbol;
    public String name;
    public String tradePrice;
    public String tradeTime;
    public String change;
    public String range;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);

        enterText = (TextView) findViewById(R.id.enterText);
        symbolText = (TextView) findViewById(R.id.symbolText);
        nameText = (TextView) findViewById(R.id.nameText);
        tradePriceText = (TextView) findViewById(R.id.tradePriceText);
        tradeTimeText = (TextView) findViewById(R.id.tradeTimeText);
        changeText = (TextView) findViewById(R.id.changeText);
        rangeText = (TextView) findViewById(R.id.rangeText);
        symbolOut = (TextView) findViewById(R.id.symbolOut);
        nameOut = (TextView) findViewById(R.id.nameOut);
        tradePriceOut = (TextView) findViewById(R.id.tradePriceOut);
        tradeTimeOut = (TextView) findViewById(R.id.tradeTimeOut);
        changeOut = (TextView) findViewById(R.id.changeOut);
        rangeOut = (TextView) findViewById(R.id.rangeOut);
        symbolInput = (EditText) findViewById(R.id.symbolInput);



    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("search", search);
        outState.putString("symbol", symbol);
        outState.putString("name", name);
        outState.putString("tradePrice", tradePrice);
        outState.putString("tradeTime", tradeTime);
        outState.putString("change", change);
        outState.putString("range", range);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        search = savedInstanceState.getBoolean("search");
        symbol = savedInstanceState.getString("symbol");
        name = savedInstanceState.getString("name");
        tradePrice = savedInstanceState.getString("tradePrice");
        tradeTime = savedInstanceState.getString("tradeTime");
        change = savedInstanceState.getString("change");
        range = savedInstanceState.getString("range");

        symbolOut.setText(symbol);
        nameOut.setText(name);
        tradePriceOut.setText(tradePrice);
        tradeTimeOut.setText(tradeTime);
        changeOut.setText(change);
        rangeOut.setText(range);
    }
}
