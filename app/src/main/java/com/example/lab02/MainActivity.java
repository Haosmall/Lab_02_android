package com.example.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.abhinav.passwordgenerator.PasswordGenerator;

public class MainActivity extends AppCompatActivity {
    EditText txtPassLength;
    CheckBox cbLowerCase, cbUpperCase, cbNumber, cbSpecialSymbol;
    TextView txtPassword;
    Button btnGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_2d);

        txtPassLength = findViewById(R.id.length);
        cbLowerCase = findViewById(R.id.lowcase);
        cbUpperCase = findViewById(R.id.upcase);
        cbNumber = findViewById(R.id.number);
        cbSpecialSymbol = findViewById(R.id.specialSymbol);
        txtPassword = findViewById(R.id.password);
        btnGenerate = findViewById(R.id.btnGenerate);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length;
                try {
                    length = Integer.parseInt(txtPassLength.getText().toString());

                boolean isUpperCase = cbUpperCase.isChecked();
                boolean isLowerCase = cbLowerCase.isChecked();
                boolean isSymbols = cbSpecialSymbol.isChecked();
                boolean isNumbers = cbNumber.isChecked();

                PasswordGenerator generator = new PasswordGenerator(length, isUpperCase, isLowerCase, isSymbols, isNumbers);

                txtPassword.setText(generator.generatePassword());

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Password length must be a digit", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}