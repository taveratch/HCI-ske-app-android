package com.example.taweesoft.hci_ske_app.views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.taweesoft.hci_ske_app.R;
import com.example.taweesoft.hci_ske_app.models.Observable;
import com.example.taweesoft.hci_ske_app.models.ObservableInterface;

import java.util.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NerdFragment extends Fragment implements ObservableInterface{
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Observable observable = new Observable();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nerd, container, false);
        ButterKnife.bind(this, view);
        toolbar.setTitle("Nerd Zone");
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                observable.setChanged();
                observable.notifyObservers();
            }
        });
        return view;
    }

    @Override
    public void addObserver(Observer observer) {
        observable.addObserver(observer);
    }
}
