/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minpro2.model;

/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;

public class PengelolaPaket extends Person {
    private ArrayList<Paket> daftarPaket;

    public PengelolaPaket(int id, String nama, String nomorHp) {
        super(id, nama, nomorHp);
        this.daftarPaket = new ArrayList<>();
    }

    public void tambahPaket(Paket paket) {
        daftarPaket.add(paket);
    }

    public ArrayList<Paket> getDaftarPaket() {
        return daftarPaket;
    }

    // Tambahan method supaya tidak error
    public Paket cariBerdasarkanId(int id) {
        for (Paket p : daftarPaket) {
            if (p.getIdPaket() == id) {
                return p;
            }
        }
        return null;
    }

    public Paket cariBerdasarkanResi(String resi) {
        for (Paket p : daftarPaket) {
            if (p.getNoResi().equalsIgnoreCase(resi)) {
                return p;
            }
        }
        return null;
    }

    public boolean hapusPaket(int id) {
        Paket target = cariBerdasarkanId(id);
        if (target != null) {
            daftarPaket.remove(target);
            return true;
        }
        return false;
    }
}
