package com.example.p6calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    TextView tv;
    Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        tv = findViewById(R.id.tv);
        btn1 = findViewById(R.id.b1);
        btn2 = findViewById(R.id.b2);
        btn3 = findViewById(R.id.b3);
        btn4 = findViewById(R.id.b4);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleEmptyFields();
                int a = Integer.parseInt(e1.getText().toString());
                int b = Integer.parseInt(e2.getText().toString());
                int c = a + b;
                tv.setText(String.valueOf(c));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleEmptyFields();
                int a = Integer.parseInt(e1.getText().toString());
                int b = Integer.parseInt(e2.getText().toString());
                int c = a - b;
                tv.setText(String.valueOf(c));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleEmptyFields();
                int a = Integer.parseInt(e1.getText().toString());
                int b = Integer.parseInt(e2.getText().toString());
                int c = a * b;
                tv.setText(String.valueOf(c));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleEmptyFields();
                int a = Integer.parseInt(e1.getText().toString());
                int b = Integer.parseInt(e2.getText().toString());
                if (b == 0) {
                    tv.setText("Cannot divide by 0");
                } else {
                    int c = a / b;
                    tv.setText(String.valueOf(c));
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void handleEmptyFields() {
        if (e1.getText().toString().length() == 0) {
            e1.setText("0");
        }
        if (e2.getText().toString().length() == 0) {
            e2.setText("0");
        }
    }
}
