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

    public static final String USER_NAME = "itmd455"; public static final String PASS_WORD = "itmd455"; public static final int TRIALS = 3;
    Button button; TextView textViewIssues; EditText login; EditText password;
    public void dataInsertion() {
        button = findViewById(R.id.button);
        textViewIssues = findViewById(R.id.textViewIssues);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password); }

    Button button;
    TextView textViewIssues;
    EditText login;
    EditText password;

    public void dataInsersion() {
        button = findViewById(R.id.button); textViewIssues = findViewById(R.id.textViewIssues); login = findViewById(R.id.login); password = findViewById(R.id.password); }
    @Override protected void onCreate(Bundle savedInstanceState) {
        final Integer[] attempt = {TRIALS};
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_login);
        dataInsersion();
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                if(loginValid()){
                    Toast.makeText(getApplicationContext(), "Playlist",
                            Toast.LENGTH_LONG).show();

                    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }




}
