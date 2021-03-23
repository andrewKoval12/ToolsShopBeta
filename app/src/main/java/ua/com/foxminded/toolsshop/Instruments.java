package ua.com.foxminded.toolsshop;

import androidx.annotation.NonNull;

public class Instruments {

    private String title;
    private String info;
    private int imageInfoId;

    public Instruments(String title, String info, int imageInfoId) {
        this.title = title;
        this.info = info;
        this.imageInfoId = imageInfoId;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageInfoId() {
        return imageInfoId;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
