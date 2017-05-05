package com.introtoandroid.stockquotes_bradley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.KeyEvent;
import android.text.TextWatcher;
import android.text.Editable;
import android.widget.Toast;
import android.os.AsyncTask;
import java.io.IOException;

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

    public String currSymbol;
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

        symbolInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }


            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() > 0) {
                    currSymbol = s.toString();
                }
                else {
                    currSymbol = "";
                }
            }
        });

        symbolInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                readStock stockData = new readStock();
                stockData.execute(currSymbol);
                return handled;
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("search", search);
        outState.putString("currSymbol", currSymbol);
        outState.putString("symbol", symbol);
        outState.putString("name", name);
        outState.putString("tradePrice", tradePrice);
        outState.putString("tradeTime", tradeTime);
        outState.putString("change", change);
        outState.putString("range", range);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        search = savedInstanceState.getBoolean("search");
        symbol = savedInstanceState.getString("symbol");
        name = savedInstanceState.getString("name");
        tradePrice = savedInstanceState.getString("tradePrice");
        tradeTime = savedInstanceState.getString("tradeTime");
        change = savedInstanceState.getString("change");
        range = savedInstanceState.getString("range");

        symbolInput.setText(currSymbol);

        symbolOut.setText(symbol);
        nameOut.setText(name);
        tradePriceOut.setText(tradePrice);
        tradeTimeOut.setText(tradeTime);
        changeOut.setText(change);
        rangeOut.setText(range);
    }

    private class readStock extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

        }

        protected String doInBackground(String... params) {
            Stock data = new Stock(currSymbol);
            String done = "done";
            try {
                data.load();
            }
            catch (IOException i) {
            }

            symbol = data.getSymbol();
            name = data.getName();
            tradePrice = data.getLastTradePrice();
            tradeTime = data.getLastTradeTime();
            change = data.getChange();
            range = data.getRange();
            return done;
        }

        @Override
        protected void onPostExecute(String done) {
            super.onPostExecute(done);
            symbolOut.setText(symbol);
            nameOut.setText(name);
            tradePriceOut.setText(tradePrice);
            tradeTimeOut.setText(tradeTime);
            changeOut.setText(change);
            rangeOut.setText(range);


        }
    }
}
