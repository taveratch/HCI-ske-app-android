package com.example.taweesoft.hci_ske_app.models;

/**
 * Created by TAWEESOFT on 9/22/2016 AD.
 */

public class News {
    private String header;
    private String description;

    public News(String header, String description) {
        this.header = header;
        this.description = description;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
