package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //get password and username variables from screen
        final EditText firstName = (EditText) findViewById(R.id.editTextFirstName);
        final EditText lastName = (EditText) findViewById(R.id.editTextLastName);
        final EditText email = (EditText) findViewById(R.id.text_mail);
        final EditText password = (EditText) findViewById(R.id.editPassword);
        final EditText confirmedpassword = (EditText) findViewById(R.id.editConfirmedPassword);

        Toast errorToastEmail = Toast.makeText(Register.this, "Error, email must contain @", Toast.LENGTH_SHORT);;
//        Toast errorToastName =  Toast.makeText(RegisterActivity.this, "Error, name must not be empty", Toast.LENGTH_SHORT);
        Toast errorToastpwd =   Toast.makeText(Register.this, "Error, password must contain more than 5 characters", Toast.LENGTH_SHORT);
        Toast errorToast = Toast.makeText(Register.this, "Error, password and confirmed password must be identical", Toast.LENGTH_SHORT);

        // Checks in TextChanged events with password and email

        //Check Confirmed password identical to password
        confirmedpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (password.getText().toString() != confirmedpassword.getText().toString()) {
                    errorToast.show();
                } else {
                    errorToast.cancel();
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //check email contains @
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!email.toString().contains("@")) {
                    errorToastEmail.show();
                }
                else {
                    errorToastEmail.cancel();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        // Check if password length greater 5
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (password.getText().toString().length() < 5) {
                    errorToastpwd.show();
                }
                else {
                    errorToastpwd.cancel();
                  }
               }
            }

          );

    }
}