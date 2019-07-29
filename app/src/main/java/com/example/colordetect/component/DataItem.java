package com.example.colordetect.component;

public class DataItem {

    private String no_responden, nama_perawat;
    private int photo_data;

    public DataItem(String no_responden, String nama_perawat, int photo_data) {
        this.no_responden = no_responden;
        this.nama_perawat = nama_perawat;
        this.photo_data = photo_data;
    }

    public String getNo_responden() {
        return no_responden;
    }

    public void setNo_responden(String name) {
        this.no_responden = name;
    }

    public String getNama_perawat() {
        return nama_perawat;
    }

    public void setNama_perawat(String nama_perawat) {
        this.nama_perawat = nama_perawat;
    }

    public int getPhoto_data() {
        return photo_data;
    }

    public void setPhoto_data(int photo_data) {
        this.photo_data = photo_data;
    }
}
