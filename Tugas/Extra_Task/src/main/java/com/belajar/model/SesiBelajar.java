package com.belajar.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SesiBelajar {
    private String mataKuliah;
    private int durasi;
    private String tanggal;

    public SesiBelajar(String mataKuliah, int durasi, String tanggal) {
        this.mataKuliah = mataKuliah;
        this.durasi = durasi;
        this.tanggal = tanggal;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public int getDurasi() {
        return durasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public static boolean isValidDate(String dateString) {
        try {
            LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}