package com.example.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText editText;
    Spinner spinner;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=findViewById(R.id.editText);
        spinner=findViewById(R.id.spinner);
        button=findViewById(R.id.button);

        ArrayAdapter branchArrayAdapter=new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.branches));
        branchArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(branchArrayAdapter);
        spinner.setOnItemSelectedListener(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();
                String branch=spinner.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(),name+"|"+branch,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId()==R.id.spinner){
            String selectedSubject=parent.getItemAtPosition(position).toString();
            Toast.makeText(MainActivity.this,selectedSubject,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}