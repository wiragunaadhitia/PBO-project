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

public class Peminjaman {

    private String RuanganDipinjam;
    private int id_peminjam;
    private int id_peminjaman;
    public Peminjam peminjam;

    public Peminjaman() {

    }

    public String getRuanganDipinjam() {
        return RuanganDipinjam;
    }

    public int getId_peminjam() {
        return id_peminjam;
    }

    public int getId_peminjaman() {
        return id_peminjaman;
    }

    public Peminjam getPeminjam() {
        return peminjam;
    }

    public void setId_peminjaman(int id_peminjaman) {
        this.id_peminjaman = id_peminjaman;
    }

    public void setRuanganDipinjam(String RuanganDipinjam) {
        this.RuanganDipinjam = RuanganDipinjam;
    }

    public void setId_peminjam(int id_peminjam) {
        this.id_peminjam = id_peminjam;
    }

    public boolean isRuangan(List<Ruangan> r, Ruangan r1) {
        boolean isfound = false;
        for (Ruangan o : r) {
            if (o.getNama_ruangan() == r1.getNama_ruangan()) {
                isfound = true;
                break;
            }
        }
        return isfound;
    }

}
