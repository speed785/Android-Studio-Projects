package lab4.playlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button button;
    TextView textViewIssues;
    EditText login;
    EditText password;

    public static final String USER_NAME = "123";
    public static final String PASS_WORD = "123";
    public static final int attempts = 3; //number of times you can get wrong. if not then it will close
                                          //For some reason it closes at 1 though now. I don't know why.


    public void DataInsersion() {
        button = findViewById(R.id.button);
        textViewIssues = findViewById(R.id.textViewIssues);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Integer[] attempt = {attempts};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DataInsersion();
        //error checking for right login credentials below
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loginValid()){
                    Toast.makeText(getApplicationContext(), "Playlist", Toast.LENGTH_LONG).show();
                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(myIntent);

                } else { textViewIssues.setText(String.format("Incorrect Login. \n" + "%d trials left.", attempt[0]));
                attempt[0] = attempt[0] - 1;
                } if (attempt[0] <= 0) {
                    finish();
                }
            }
        });
    }
    private void loginData() {
        login.setText(USER_NAME);
        password.setText(PASS_WORD);
    }
    private String getUserName(){
        return login.getText().toString();
    }
    private String getPassWord(){
        return password.getText().toString();
    }
    public boolean loginValid(){
        return (getUserName().equals(USER_NAME) && getPassWord().equals(PASS_WORD));
    }
}