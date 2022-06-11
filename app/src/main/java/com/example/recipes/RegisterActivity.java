package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recipes.ui.login.LoginActivity;
import com.example.recipes.ui.login.LoginViewModel;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //get password and username variables from screen
        final EditText firstNameEditText = (EditText) findViewById(R.id.editTextFirstName);
        final EditText lastNameEditText = (EditText) findViewById(R.id.editTextLastName);
        final EditText emailEditText = (EditText) findViewById(R.id.text_mail);
        final EditText passwordEditText = (EditText) findViewById(R.id.editPassword);
        final EditText confirmedpasswordEditText = (EditText) findViewById(R.id.editConfirmedPassword);

        Toast errorToastEmail = Toast.makeText(RegisterActivity.this, "Error, email must contain @", Toast.LENGTH_SHORT);;
//        Toast errorToastName =  Toast.makeText(RegisterActivity.this, "Error, name must not be empty", Toast.LENGTH_SHORT);
        Toast errorToastpwd =   Toast.makeText(RegisterActivity.this, "Error, password must contain more than 5 characters", Toast.LENGTH_SHORT);
        Toast errorToast = Toast.makeText(RegisterActivity.this, "Error, password and confirmed password must be identical", Toast.LENGTH_SHORT);

        // Checks in TextChanged events with password and email

        //Check Confirmed password identical to password
        confirmedpasswordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (passwordEditText.getText().toString() != confirmedpasswordEditText.getText().toString()) {
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
        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!emailEditText.toString().contains("@")) {
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
        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (passwordEditText.getText().toString().length() < 5) {
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