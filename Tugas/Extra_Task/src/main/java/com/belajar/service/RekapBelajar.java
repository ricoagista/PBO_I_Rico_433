package com.belajar.service;

import com.belajar.model.SesiBelajar;
import java.util.List;

public class RekapBelajar implements HitungDurasi {

    @Override
    public int hitungTotalDurasi(List<SesiBelajar> daftar) {
        int total = 0;
        for (SesiBelajar sesi : daftar) {
            total += sesi.getDurasi();
        }
        return total;
    }
}