package com.example.taweesoft.hci_ske_app.views.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.taweesoft.hci_ske_app.R;
import com.example.taweesoft.hci_ske_app.models.NewsStorage;
import com.example.taweesoft.hci_ske_app.models.Observable;
import com.example.taweesoft.hci_ske_app.models.ObservableInterface;
import com.example.taweesoft.hci_ske_app.views.adapters.NewsAdapter;

import java.io.File;
import java.util.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TAWEESOFT on 9/19/16 AD.
 */
public class NewsFragment extends Fragment implements ObservableInterface{
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.listView)
    ListView listView;

    private Observable observable = new Observable();
    private NewsStorage newsStorage;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, view);
        toolbar.setTitle("News");
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                observable.setChanged();
                observable.notifyObservers();
            }
        });
        initComponents();
        return view;
    }

    public void initComponents() {
        newsStorage = new NewsStorage();
        NewsAdapter adapter = new NewsAdapter(this.getContext(),R.layout.news_model,newsStorage.generateNews());
        listView.setAdapter(adapter);
    }

    public File readFile(Context context, String fileName) {
        String yourFilePath = context.getFilesDir() + "/" + fileName;
        File yourFile = new File( yourFilePath );
        return yourFile;
    }

    @Override
    public void addObserver(Observer observer) {
        observable.addObserver(observer);
    }
}
