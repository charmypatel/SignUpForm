package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.util.Patterns;


public class FormActivity extends AppCompatActivity {

    //declaring variables for EditText input boxes & Button
    EditText inputName;
    EditText inputEmail;
    EditText inputPassword;
    EditText inputConfirmPassword;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //changes the title in green bar at top
        getSupportActionBar().setTitle("Sign Up Form");

        //sets input in the boxes equal to the variables declared
        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        signup = findViewById(R.id.signupbutton);

        //called when button is clicked
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //converting the inputs to string and saving them in variables
                String enteredName = inputName.getText().toString();
                String enteredEmail = inputEmail.getText().toString();
                String enteredPassword = inputPassword.getText().toString();
                String enteredConfirmPassword = inputConfirmPassword.getText().toString();


                //checking to make sure name is entered
                if (enteredName.isEmpty())
                {
                    Toast.makeText(FormActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }

                //checking to make sure email is entered
                else if (enteredEmail.isEmpty()) {
                        Toast.makeText(FormActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                }

                //validates entered email to make sure its in correct email format
                else if(!(Patterns.EMAIL_ADDRESS.matcher(enteredEmail).matches()))
                {
                    Toast.makeText(FormActivity.this, "Please enter a valid email. Example: bob@gmail.com", Toast.LENGTH_SHORT).show();
                }

                //checking to make sure password is entered
                else if (enteredPassword.isEmpty() )
                {
                    Toast.makeText(FormActivity.this, "Please enter your password", Toast.LENGTH_SHORT).show();
                }

                //checking to make sure password is retyped
                else if (enteredConfirmPassword.isEmpty())
                {
                    Toast.makeText(FormActivity.this, "Please retype your password", Toast.LENGTH_SHORT).show();

                }

                //checking to make sure passwords match
                else if (!(enteredPassword.equals(enteredConfirmPassword)))
                {
                    Toast.makeText(FormActivity.this, "Please make sure your passwords match", Toast.LENGTH_SHORT).show();
                }

                //welcomes user to app with message including the entered name
                else
                    Toast.makeText(FormActivity.this, "Welcome, " + enteredName + ", to the SignUpForm App!", Toast.LENGTH_SHORT).show();
            }

        });
    }
}

