package com.example.taweesoft.hci_ske_app.views;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.taweesoft.hci_ske_app.models.Item;
import com.example.taweesoft.hci_ske_app.R;
import com.example.taweesoft.hci_ske_app.views.adapters.MenuItemAdapter;
import com.example.taweesoft.hci_ske_app.views.fragments.EventsFragment;
import com.example.taweesoft.hci_ske_app.views.fragments.FilesFragment;
import com.example.taweesoft.hci_ske_app.views.fragments.NerdFragment;
import com.example.taweesoft.hci_ske_app.views.fragments.NewsFragment;
import com.example.taweesoft.hci_ske_app.views.fragments.ScheduleFragment;

import net.simonvt.menudrawer.MenuDrawer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements Observer {
    private MenuDrawer menuDrawer;

    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuDrawer = MenuDrawer.attach(this);
        menuDrawer.setContentView(R.layout.activity_main);
        menuDrawer.setMenuView(R.layout.menu_bar);
        ButterKnife.bind(this);
        ButterKnife.bind(menuDrawer.getMenuView());
        List<Item> menuItems = generateMenuItems();
        MenuItemAdapter adapter = new MenuItemAdapter(this,R.layout.menu_bar, menuItems);
        listView.setAdapter(adapter);
        NewsFragment newsFragment = new NewsFragment();
        newsFragment.addObserver(this);
        replaceFragment(newsFragment);
        listView.setOnItemClickListener(getListViewAction());
    }

    public AdapterView.OnItemClickListener getListViewAction() {
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position) {
                    case 0:
                        NewsFragment newsFragment = new NewsFragment();
                        newsFragment.addObserver(MainActivity.this);
                        replaceFragment(newsFragment);
                        break;
                    case 1:
                        EventsFragment eventsFragment = new EventsFragment();
                        eventsFragment.addObserver(MainActivity.this);
                        replaceFragment(eventsFragment);
                        break;
                    case 2:
                        ScheduleFragment scheduleFragment = new ScheduleFragment();
                        scheduleFragment.addObserver(MainActivity.this);
                        replaceFragment(scheduleFragment);
                        break;
                    case 3:
                        FilesFragment filesFragment = new FilesFragment();
                        filesFragment.addObserver(MainActivity.this);
                        replaceFragment(filesFragment);
                        break;
                    case 4:
                        NerdFragment nerdFragment = new NerdFragment();
                        nerdFragment.addObserver(MainActivity.this);
                        replaceFragment(nerdFragment);
                        break;
                }
                menuDrawer.toggleMenu();
            }
        };
    }
    public List<Item> generateMenuItems() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(R.drawable.news_icon, "News"));
        items.add(new Item(R.drawable.events_icon, "Events"));
        items.add(new Item(R.drawable.schedule_icon, "Class Schedule"));
        items.add(new Item(R.drawable.files_icon, "Files"));
        items.add(new Item(R.drawable.nerd_icon, "Nerd Zone"));
        items.add(new Item(R.drawable.signout_icon, "Sign Out"));
        return items;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home) {
            menuDrawer.toggleMenu(true);
        }
        return super.onOptionsItemSelected(item);
    }

    public void replaceFragment(Fragment fragmnet) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragmnet)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("Updated");
        menuDrawer.toggleMenu();
    }
}
