package lab4.playlist;
//import android.animation.Animator;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater lInflater;
    private List<ItemObject> listStorage;

    public CustomAdapter(Context context,List<ItemObject>customizedListView) {
        lInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }
    @Override
    public int getCount(){
        return listStorage.size();
    }
    @Override
    public Object getItem(int position){
        return position; }
    @Override
    public long getItemId(int position){
        return position; }
    @Override
    public View getView(int position, View concertView, ViewGroup parent) {
        TextView Title = null;
        TextView Year = null;
        TextView Artist = null;

        if (concertView == null) {
            concertView = lInflater.inflate(R.layout.list, parent, false);
        }
        Title = concertView.findViewById(R.id.textView);
        Year = concertView.findViewById(R.id.textView2);
        Artist = concertView.findViewById(R.id.textView3);
        Title.setText("Song Title: " + listStorage.get(position).getTitle());
        Year.setText("Song Year: " + listStorage.get(position).getYear());
        Artist.setText("Song Artist: " + listStorage.get(position).getArtist());

        if (position % 2 == 1) {
            concertView.setBackgroundColor(0xffffffff);
        } else {
            concertView.setBackgroundColor(Color.YELLOW);
        }
        return concertView;
    }
    }
