/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minpro2.model;

/**
 *
 * @author LENOVO
 */
public class Ekspedisi {
    private int idEkspedisi;
    private String namaEkspedisi;
    private String jenisLayanan;

    public Ekspedisi(int idEkspedisi, String namaEkspedisi, String jenisLayanan) {
        this.idEkspedisi = idEkspedisi;
        this.namaEkspedisi = namaEkspedisi;
        this.jenisLayanan = jenisLayanan;
    }

    public int getIdEkspedisi() { return idEkspedisi; }
    public String getNamaEkspedisi() { return namaEkspedisi; }
    public String getJenisLayanan() { return jenisLayanan; }
}