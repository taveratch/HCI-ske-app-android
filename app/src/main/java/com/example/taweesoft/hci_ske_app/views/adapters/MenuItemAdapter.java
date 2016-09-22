package com.example.taweesoft.hci_ske_app.views.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taweesoft.hci_ske_app.R;
import com.example.taweesoft.hci_ske_app.models.Item;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TAWEESOFT on 9/19/16 AD.
 */
public class MenuItemAdapter extends ArrayAdapter<Item> {

    @BindView(R.id.menu_img)
    ImageView imgIcon;

    @BindView(R.id.menu_label)
    TextView imgLabel;

    public MenuItemAdapter(Context context, int resource, List<Item> items){
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.menu_item, null, false);
            ButterKnife.bind(this,convertView);
            Item item = getItem(position);
            imgIcon.setImageResource(item.getImage());
            imgLabel.setText(item.getLabel());
        }
        return convertView;
    }
}
