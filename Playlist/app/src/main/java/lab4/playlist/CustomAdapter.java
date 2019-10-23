package lab4.playlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private LayoutInflater lInflator;
    private List<ItemObject> listStorage;

    public CustomAdapter(Context context,List<ItemObject>customizedListView) {
        lInflator =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }
}
