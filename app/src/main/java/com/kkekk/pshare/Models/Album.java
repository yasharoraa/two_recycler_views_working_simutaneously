package com.kkekk.pshare.Models;

import android.support.annotation.Nullable;

import java.util.ArrayList;

public class Album {

    @Nullable
    private int imageResource;

    private String AlbumName;

    @Nullable
    private ArrayList<Album> photoArrayList;


    public Album(int imageResource, String albumName,@Nullable ArrayList<Album> photoArrayList) {
        this.imageResource = imageResource;

        this.AlbumName = albumName;
        this.photoArrayList = photoArrayList;
    }


    @Nullable
    public ArrayList<Album> getPhotoArrayList() {
        return photoArrayList;
    }

    @Nullable
    public void setPhotoArrayList(ArrayList<Album> photoArrayList) {
        this.photoArrayList = photoArrayList;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String albumName) {
        AlbumName = albumName;
    }
}
