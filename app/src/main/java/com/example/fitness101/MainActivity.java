package com.example.fitness101;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText wei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        wei =findViewById(R.id.editWeight);
        EditText hei=findViewById(R.id.editHeight);
        TextView tvResults =findViewById(R.id.textResults);
        Button butt=findViewById(R.id.buttonNext);

        Button but = findViewById(R.id.buttonBMI);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismisskeyboard();

                String stringWei=wei.getText().toString();
                float intWei=Float.parseFloat(stringWei);

                String stringHei=hei.getText().toString();
                float intHei=Float.parseFloat(stringHei);

                float bmi;
                bmi=intWei/(intHei*intHei);


                String res = Float.toString(bmi);
                tvResults.setText(res);
                Toast.makeText(MainActivity.this, "This is your BMI", Toast.LENGTH_SHORT).show();
                if(bmi<10){}


            }

        });
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,BMIExplained.class);
                startActivity(intent);
            }
        });
    }

    private void dismisskeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(wei.getWindowToken(), 0);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}