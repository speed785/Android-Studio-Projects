package com.example.tempconverter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    View view; //create object to manipulate background color
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
                //grab CURRENT result value now in Text Field
                inputValue = Float.parseFloat(text.getText().toString());
                view = findViewById(R.id.activity_main);
                if (inputValue>90)
                    //set hex color to skyblue
                    view.setBackgroundColor(Color.parseColor("#87ceff"));
                    //input value = degrees in fahrenheit
                else if (inputValue<32)
                    //set hex color to fuchsia(magenta)
                    //It's a dangerous red/pink!
                    view.setBackgroundColor(Color.parseColor("#FF00FF"));
                else
                {
                    view.setBackgroundColor(Color.YELLOW);
                }
                break;
        }
    }
}