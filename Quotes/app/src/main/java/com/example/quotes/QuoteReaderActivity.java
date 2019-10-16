package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

public class QuoteReaderActivity extends AppCompatActivity {

    public class QuoteAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mDataSource.getDataSourceLength();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView thumbnail;
            TextView quote;

            if(convertView == null) {
                convertView = mInflator.inflate(R.layout.list_item_layout, parent,
                        false);
            }

            thumbnail = convertView.findViewById(R.id.thumb);
            thumbnail.setImageResource(mDataSource.getmPhotoPool().get(position));
            quote = convertView.findViewById(R.id.text);
            quote.setTextSize(mDataSource.getmQuotePool().get(position));

            return convertView;
        }

        private Context mContext;
        private LayoutInflater mInflator;
        private DataSource mDataSource;

        public QuoteAdapter(Context c) {
            mContext = c;
            mInflator = (LayoutInflater)
                    mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            mDataSource = new DataSource();
        }
    }

    /** Called when the activity is first created. */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_reader);
        ListView mListView = findViewById(R.id.quotes_list);
        mListView.setAdapter(new QuoteAdapter(this));
    }
}
