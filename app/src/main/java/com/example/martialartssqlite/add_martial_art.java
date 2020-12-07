package com.example.martialartssqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.martialartssqlite.model.DBHandler;
import com.example.martialartssqlite.model.MartialArt;

public class add_martial_art extends AppCompatActivity implements View.OnClickListener {
    EditText edtName, edtPrice, edtColor;
    Button btnAddMartialArt, btnGoBack;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_martial_art);
        Toast.makeText(add_martial_art.this, "This is add Martial Art Activity", Toast.LENGTH_SHORT).show();
        edtName = (EditText) findViewById(R.id.edtName);
        edtPrice = (EditText) findViewById(R.id.edtPrice);
        edtColor = (EditText) findViewById(R.id.edtColor);

        btnAddMartialArt = (Button) findViewById(R.id.btnAddMartialArt);
        btnGoBack = (Button) findViewById(R.id.btnGoBack);
        dbHandler = new DBHandler(add_martial_art.this);

        btnAddMartialArt.setOnClickListener(add_martial_art.this);
        btnGoBack.setOnClickListener(add_martial_art.this);
    }
    private void addMartialArtToDB(){
        String nameValue = edtName.getText().toString();
        String priceValue = edtPrice.getText().toString();
        String colorValue = edtColor.getText().toString();
        try {
            double priceDoubleValue = Double.parseDouble(priceValue);
            MartialArt martialArt = new MartialArt(0, nameValue, priceDoubleValue, colorValue );
            dbHandler.addMartialArt(martialArt);
            Toast.makeText(add_martial_art.this, martialArt + " is added to the DB",Toast.LENGTH_SHORT).show();




        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAddMartialArt:
                addMartialArtToDB();
                break;
            case R.id.btnGoBack:
                this.finish();
                break;

        }
    }
}