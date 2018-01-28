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
import Database.Database;
import Controller.ControllerLogin;

public class Aplikasi {

    private List<Ruangan> DaftarRuangan = new ArrayList<>();
    private List<Peminjam> DaftarPeminjam = new ArrayList<>();
    private List<Peminjaman> DaftarPeminjaman = new ArrayList<>();
    private Database data;

    public Aplikasi() {
        this.data = new Database();
        data.connect();
    }

    public void showRuangan() {
        for (Object o : DaftarRuangan) {
            System.out.println(o);
        }
    }

    public void Login(String username, String password) {
        for (int i = 0; i < DaftarPeminjam.size(); i++) {
            if ((username == this.DaftarPeminjam.get(i).getUsername()) && password == this.DaftarPeminjam.get(i).getPassword()) {
                System.out.println("Login berhasil");
                break;
            }

        }

    }

    public Peminjam LoginPeminjam(String username, String password) {
        Peminjam p = data.getPeminjam(username, password);
        if (p != null) {

            return p;
        } else {

            return null;
        }
    }

    public Admin LoginAdmin(String username, String password) {
        Admin a = data.getAdmin(username, password);
        if (a != null) {
            return a;
        } else {
            return null;
        }
    }

    public void RegisterPeminjam(Peminjam p) {
        data.savePeminjam(p);
        DaftarPeminjam.add(p);
    }

    public void RegisterPeminjaman(List<Ruangan> r, Peminjaman p, Peminjam pe) {
        for (Ruangan o : r) {
            p.setRuanganDipinjam(o.getNama_ruangan());
            data.updateStatusRuangan(o, "Not Available");
            data.savePeminjaman(p, pe);
            DaftarPeminjaman.add(p);
        }

    }

    public void ubahStatusRuangan(Ruangan r, String s) {
        data.updateStatusRuangan(r, s);
    }

    public Ruangan searchRuanganbyNama(String nama) {
        Ruangan r = data.getRuanganbyNama(nama);
        System.out.println(r.getNama_ruangan());
        return r;
    }

    public void hapusPeminjaman(Peminjaman pe) {
        data.deletePeminjaman(pe);
        ubahStatusRuangan(searchRuanganbyNama(pe.getRuanganDipinjam()), "Available");
      
    }

    public void addRuangan(Ruangan r) {
        data.saveRuangan(r);
        DaftarRuangan.add(r);

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

    public void ubahDataPeminjam(Peminjam p, int id) {
        data.updatePeminjam(p, id);
    }
    public void ubahDataRuangan(Ruangan r){
        data.updateDataRuangan(r);
    }
    public void cekPeminjaman(Ruangan r){
        data.deletePeminjamanbyRuangan(r);
    }
    public static void main(String[] args) {
        Aplikasi a = new Aplikasi();
        new ControllerLogin(a);
    }

}
