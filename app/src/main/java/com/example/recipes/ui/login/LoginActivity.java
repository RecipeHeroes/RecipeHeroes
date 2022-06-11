package com.example.recipes.ui.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recipes.R;
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
        final EditText username = (EditText) findViewById(R.id.username);
        final EditText password = (EditText) findViewById(R.id.password);
        final Button loginButton = (Button) findViewById(R.id.login);

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
                if (username.getText().toString().contains("@") == false ) {
                    runOnUiThread(new Runnable() {
                        public void run() {
                                Toast errorToast = Toast.makeText(LoginActivity.this, "Error, username must contain @", Toast.LENGTH_SHORT);
                                errorToast.show();

                        }
                    });
                }
                if(username.toString().isEmpty() == true){
                    runOnUiThread(new Runnable() {
                        public void run() {
                            Toast errorToast = Toast.makeText(LoginActivity.this, "Error, username must not be true", Toast.LENGTH_SHORT);
                            errorToast.show();

                        }
                    });
                }
                if(password.getText().toString().length() < 5){
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
        username.addTextChangedListener(afterTextChangedListener);
        password.addTextChangedListener(afterTextChangedListener);

        // Create OnEditorActionListener for login password and username
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(username.getText().toString(),
                            password.getText().toString());
                }
                return false;
            }
        });
    }
}