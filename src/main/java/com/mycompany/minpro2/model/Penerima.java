/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minpro2.model;

/**
 *
 * @author LENOVO
 */
public class Penerima extends Person {
    private String alamat;

    public Penerima(int id, String nama, String nomorHp, String alamat) {
        super(id, nama, nomorHp);
        this.alamat = alamat;
    }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
}
