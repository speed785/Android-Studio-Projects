//James Dumitru
//ITMD 455
package com.example.tempconverter2;
import android.graphics.Color;
import android.view.View;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBar; //declare seekbar object
    TextView textView;
    //TextView textView1;
    //declare member variables for SeekBar
    int discrete = 0;
    int start = 50;
    int start_position = 50; //progress tracker
    int temp = 0;
    //declare objects for ViewStub
    ViewStub stub;
    CheckBox checkBox;
    ListView lv; //declare Listview object
    private int backgroundColor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //declare viewstub object
        stub = findViewById(R.id.viewStub1);
        @SuppressWarnings("unused")
        View inflated = stub.inflate();
        stub.setVisibility(View.INVISIBLE);
        //ViewStub logic
        checkBox = findViewById(R.id.checkBox1);
        //handle checkbox click event
        checkBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                if (isChecked) {
                    //remove objs from parent view to allow for child view objs
                    checkBox.setVisibility(View.GONE);
                    seekBar.setVisibility(View.GONE);
                    textView.setVisibility(View.GONE);
                    stub.setVisibility(View.VISIBLE);
                }
            }
        });
        //seekbar logic
        textView = findViewById(R.id.textview);
        //textView = findViewById(R.id.textview1);
        textView.setText(" Celsius at 0 degrees");
        textView.setTextSize(26);
        //set default view
        seekBar = findViewById(R.id.seekbar);
        seekBar.setProgress(start_position);
        //create event handler for SeekBar
        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (temp == 0) //for initial view result
                    Toast.makeText(getBaseContext(), "Fahrenheit result: 32 degrees",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getBaseContext(), "Fahrenheit result: "
                            + String.valueOf(discrete) +
                            " degrees", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar,
                                          int progress, boolean fromUser) {
                // To convert progress passed as discrete (Fahrenheit) value
                temp = progress - start;
                discrete = (int) Math.round((((temp * 9.0) /
                        5.0) + 32)); //convert C to F temp
                textView.setText(" Celsius at " + temp + " degrees");
            }
        });
        //Listview logic
        setTitle("                   5 Day Chicago Forecast");
        setTitleColor(Color.WHITE);
        //setBackgroundColor(Color.rgb(0x88, 0x33, 0x33));
        String[] wkTemps = new String[]{
                "                    Monday - 26°C High / 19°C Low",
                "                    Tuesday - 21°C High / 14°C Low",
                "                    Wednesday - 22°C High / 13°C Low",
                "                    Thursday - 24°C High / 17°C Low",
                "                    Friday - 22°C High / 13°C Low"};
        lv = findViewById(R.id.listView);
        @SuppressWarnings({"unchecked", "rawtypes"})
        /*
         * To use a basic ArrayAdapter, you just need to initialize the adapter and
         * attach the adapter to the ListView. First, initialize the adapter...:
         *
         */
                ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1, wkTemps);
        // Assign adapter to ListView
        lv.setAdapter(adapter);
    }//end onCreate method

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    // My attempt at making the title background a different color but I could not yet.
    /*
    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }
    */
}

