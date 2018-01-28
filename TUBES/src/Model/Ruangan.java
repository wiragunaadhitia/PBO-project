/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author USer
 */
import java.util.*;

public class Ruangan {

    private int id;
    private String nama_ruangan;
    private int harga;
    private String status;

    public Ruangan(String nama_ruangan, int harga, String status) {
        this.nama_ruangan = nama_ruangan;
        this.harga = harga;
        this.status = status;
    }

    public Ruangan() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ruangan(String nama_ruangan, int harga) {
        this.nama_ruangan = nama_ruangan;
        this.harga = harga;
    }

    public String getNama_ruangan() {
        return nama_ruangan;
    }

    public int getHarga() {
        return harga;
    }

    public String getStatus() {
        return status;
    }

    public void setNama_ruangan(String nama_ruangan) {
        this.nama_ruangan = nama_ruangan;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
