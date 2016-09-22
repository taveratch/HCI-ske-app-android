package com.example.taweesoft.hci_ske_app.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TAWEESOFT on 9/22/2016 AD.
 */

public class NewsStorage {
    public List<News> generateNews() {
        List<News> news = new ArrayList<>();
        news.add(new News("HCI class cancelled", "HCI class on 23 Friday has been cancelled"));
        news.add(new News("Formal uniform on 26 Monday Sep 2016", "Examination"));
        news.add(new News("Bring laptop to Data-com class", "Don\'t forget your laptop"));
        news.add(new News("เก็บค่าภาคเดือนกันยายน", "500 บาท"));
        return news;
    }
}
