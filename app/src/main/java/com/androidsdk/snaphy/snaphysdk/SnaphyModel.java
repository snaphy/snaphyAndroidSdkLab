package com.androidsdk.snaphy.snaphysdk;


import com.androidsdk.snaphy.snaphyandroidsdk.models.Model;

/**
 * Created by snaphy on 31/1/17.
 */

public class SnaphyModel {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    String title;
    String edition;

    public SnaphyModel(){
    }

    public SnaphyModel(String title, String edition){
        this.title = title;
        this.edition = edition;
    }
}
