package com.aaron.mooc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dropdown, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button button = findViewById(R.id.button);
        final EditText value1 = findViewById(R.id.value1);
        final EditText value2 = findViewById(R.id.value2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.textView3);
                String string = spinner.getSelectedItem().toString();
                String v1s = value1.getText().toString();
                int v1 = Integer.parseInt(v1s);
                String v2s = value2.getText().toString();
                int v2 = Integer.parseInt(v2s);
                String s = "";
                if (string.equals("Addition")) {
                    s = String.valueOf(v1+v2);
                } else if (string.equals( "Subtraction")) {
                    s = String.valueOf(v1-v2);
                } else if (string.equals("Multiply")) {
                    s = String.valueOf(v1*v2);
                } else if (string.equals("Divide")) {
                    if (v2 == 0) {
                        s = "You can't divide by 0, stupid.";
                    }
                    else s = v1/v2+" R: "+v1%v2;
                }
                textView.setText(s);
            }
        });
    }
}
