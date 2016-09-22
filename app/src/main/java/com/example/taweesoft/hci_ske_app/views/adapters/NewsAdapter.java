package com.example.taweesoft.hci_ske_app.views.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.taweesoft.hci_ske_app.R;
import com.example.taweesoft.hci_ske_app.models.News;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TAWEESOFT on 9/22/2016 AD.
 */

public class NewsAdapter extends ArrayAdapter<News>{

    @BindView(R.id.txt_header)
    TextView txtHeader;

    @BindView(R.id.txt_desc)
    TextView txtDesc;

    public NewsAdapter(Context context, int resource, List<News> newsList) {
        super(context, resource, newsList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.news_model,null);
            ButterKnife.bind(this, convertView);
            News news = getItem(position);
            txtHeader.setText(news.getHeader());
            txtDesc.setText(news.getDescription());
        }
        return convertView;
    }
}
