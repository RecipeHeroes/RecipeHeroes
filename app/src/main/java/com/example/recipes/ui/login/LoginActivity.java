package com.example.recipes.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recipes.Overview;
import com.example.recipes.R;
import com.example.recipes.RegisterActivity;
import com.example.recipes.SettingsActivity;
import com.example.recipes.ui.login.LoginViewModel;
import com.example.recipes.ui.login.LoginViewModelFactory;
import com.example.recipes.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set View activity_login
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_login);

        //get button, password and username variables from screen
        final EditText usernameEditText = (EditText) findViewById(R.id.username);
        final EditText passwordEditText = (EditText) findViewById(R.id.password);
        final Button loginButton = (Button) findViewById(R.id.login);
        final ProgressBar loadingProgressBar = binding.loading;

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            // Check, wether username and password follow restrictions for length and email @ sign
            // Because username must be an email address
            // And if not display error message
            @Override
            public void afterTextChanged(Editable s) {
                if (usernameEditText.getText().toString().contains("@") == false ) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                                Toast errorToast = Toast.makeText(LoginActivity.this, "Error, username must contain @", Toast.LENGTH_SHORT);
                                errorToast.show();

                        }
                    });
                }
                if(usernameEditText.toString().isEmpty() == true){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast errorToast = Toast.makeText(LoginActivity.this, "Error, username must not be true", Toast.LENGTH_SHORT);
                            errorToast.show();

                        }
                    });
                }
                if(passwordEditText.getText().toString().length() < 5){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast errorToast = Toast.makeText(LoginActivity.this, "Error, password must contain more than 5 characters", Toast.LENGTH_SHORT);
                            errorToast.show();

                        }
                    });
                }
            }
        };
        // set afterTextChangedListener in Edit Text fields
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);

        // Create OnEditorActionListener for login password and username
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });
    }
}