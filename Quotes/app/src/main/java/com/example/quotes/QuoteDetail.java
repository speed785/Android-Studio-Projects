package com.example.quotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class QuoteDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quote_detail);

        Intent i = getIntent();
        int mPosition = i.getIntExtra("position", 0);
        DataSource mDataSource = new DataSource();
        ImageView mImageView = findViewById(R.id.image);
        TextView mQuote = findViewById(R.id.quote);
        mImageView.setImageResource(mDataSource.getmPhotoHdPool().
                                    get(mPosition));
        mQuote.setText(getResources().getString(mDataSource.getmQuotePool()
                .get(mPosition)));
    }
}
