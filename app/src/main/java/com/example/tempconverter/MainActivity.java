package com.example.tempconverter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editText);
    }
    /* this method is called when user clicks the button and is handled
    because we assigned the name to the "OnClick property" of the
    button */
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                RadioButton celsiusButton =
                        findViewById(R.id.radioButton);
                RadioButton fahrenheitButton =
                        findViewById(R.id.radioButton2);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue =
                        Float.parseFloat(text.getText().toString());
                if (celsiusButton.isChecked()) {

                    text.setText(String.valueOf(ConverterUtil.convertCelsiusToFahrenheit(inputValue)));
                    celsiusButton.setChecked(false);
                    fahrenheitButton.setChecked(true);
                }
                else {

                    text.setText(String.valueOf(ConverterUtil.convertFahrenheitToCelsius(inputValue)));
                    fahrenheitButton.setChecked(false);
                    celsiusButton.setChecked(true);
                }
                break;
        }
    }
}