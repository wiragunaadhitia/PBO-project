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

public class Peminjam extends User {

    private List<Peminjaman> daftarPeminjaman;
  

    public Peminjam(String username, String password, String nama) {
        super(username, password, nama);
        daftarPeminjaman = new ArrayList<>();
    }

    public Peminjam() {

    }

    public void createPeminjaman() {
        daftarPeminjaman.add(new Peminjaman());
    }

    public Peminjaman getDaftarPeminjaman(int i) {
        return daftarPeminjaman.get(i);
    }

    @Override
    public void setPassword(String password) {

        if (password == super.getPassword()) {
            System.out.println("Ketik ulang password !");
        } else {
            super.setPassword(password);
        }
    }

    @Override
    public String toString() {
        return "Nama : " + getNama() + "username : " + getUsername() + "password : " + getPassword();
    }

}
