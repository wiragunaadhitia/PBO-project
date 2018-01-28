/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author USer
 */
import Model.Peminjam;
import Model.Peminjaman;

import Model.Ruangan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Model.Admin;

public class Database {

    private String server = "jdbc:mysql://localhost:3306/peminjamanruangan";
    private String dbUser = "root";
    private String dbPwd = "";
    Statement statement;
    Connection connection;

    public Database() {
        connect();
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(server, dbUser, dbPwd);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Tidak Connect");
        }
    }

    public void savePeminjam(Peminjam p) {
        try {
            String query = "INSERT INTO Peminjam(username,password,nama) Values("
                    + "'" + p.getUsername() + "',"
                    + "'" + p.getPassword() + "',"
                    + "'" + p.getNama() + "')";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            p.setId(generatedId);
            JOptionPane.showMessageDialog(null, "Anda Telah Sukses Mendaftar");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Anda Telah Terdafar sebelumnya");
            System.out.println("Semua data harus terisi" + ex.toString());
        }

    }

    public void updatePeminjam(Peminjam p, int id) {
        try {
            String query = "UPDATE PEMINJAM SET username = '" + p.getUsername() + "', password = '" + p.getPassword() + "',"
                    + "nama = '" + p.getNama() + "' where id_peminjam = '" + id + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("update data gagal" + ex);
        }
    }

    public void saveRuangan(Ruangan r) {
        try {
            String query = "INSERT INTO Ruangan(nama_ruangan,harga,status) Values("
                    + "'" + r.getNama_ruangan() + "',"
                    + "'" + r.getHarga() + "',"
                    + "'" + r.getStatus() + "')";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            r.setId(generatedId);
            JOptionPane.showMessageDialog(null, "Ruangan berhasil Ditambahkan");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ruangan ini sudah ada sebelumnya");
            System.out.println("Semua data harus terisi" + ex.toString());
        }
    }

    public void savePeminjaman(Peminjaman p, Peminjam pe) {
        try {
            String query = "INSERT INTO PEMINJAMAN(id_peminjam,nama_ruangan) values ("
                    + "'" + pe.getId() + "',"
                    + "'" + p.getRuanganDipinjam() + "')";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            int generatedId = -1;
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }
            p.setId_peminjaman(generatedId);
        } catch (SQLException ex) {
            System.out.println("Peminjaman gagal" + ex);
        }
    }

    public void updateStatusRuangan(Ruangan r, String s) {
        try {
            String query = "UPDATE RUANGAN SET status = '" + s + "'" + "where nama_ruangan ='"
                    + r.getNama_ruangan() + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("update data gagal" + ex);
        }
    }

    public Peminjam getPeminjam(String username, String password) {
        Peminjam p = null;
        try {

            String query = "SELECT * FROM PEMINJAM where username = '"
                    + username + "' " + "AND password = '" + password + "'";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                p = new Peminjam();
                p.setId(rs.getInt(1));
                p.setUsername(rs.getString(2));
                p.setPassword(rs.getString(3));
                p.setNama(rs.getString(4));

            }

            return p;
        } catch (SQLException ex) {

            System.out.println("Login gagal " + ex);
            return null;

        }
    }

    public Admin getAdmin(String username, String password) {
        Admin a = null;
        try {
            String query = "SELECT * FROM ADMIN where username_admn = '"
                    + username + "' " + "AND password_admn = '" + password + "'";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                a = new Admin();
                a.setId(rs.getInt(1));
                a.setUsername(rs.getString(2));
                a.setPassword(rs.getString(3));
                a.setNama(rs.getString(4));

            }

            return a;
        } catch (SQLException ex) {

            System.out.println("Login gagal " + ex);
            return null;

        }
    }

    public List<Ruangan> getRuangan() {
        List<Ruangan> r = new ArrayList<>();
        try {
            String query = "SELECT * FROM RUANGAN ";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Ruangan r1 = new Ruangan();
                r1.setId(rs.getInt(1));
                r1.setNama_ruangan(rs.getString(2));
                r1.setHarga(rs.getInt(3));
                r1.setStatus(rs.getString(4));
                r.add(r1);
            }
            return r;

        } catch (SQLException ex) {
            System.out.println("Gagal Get Data Ruangan");
            return null;
        }

    }

    public Ruangan getRuanganbyNama(String nama) {
        try {
            Ruangan r1 = null;
            String query = "SELECT * FROM RUANGAN where nama_ruangan ='" + nama + "'";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                r1 = new Ruangan();
                r1.setId(rs.getInt(1));
                r1.setNama_ruangan(rs.getString(2));
                r1.setHarga(rs.getInt(3));
                r1.setStatus(rs.getString(4));

            }

            return r1;

        } catch (SQLException ex) {
            System.out.println("Gagal Get Data Ruangan");
            return null;
        }
    }

    public List<Ruangan> getRuanganbyStatus(String status) {
        List<Ruangan> r = new ArrayList<>();
        try {
            String query = "SELECT * FROM RUANGAN where status ='" + status + "'";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Ruangan r1 = new Ruangan();
                r1.setId(rs.getInt(1));
                r1.setNama_ruangan(rs.getString(2));
                r1.setHarga(rs.getInt(3));
                r1.setStatus(rs.getString(4));
                r.add(r1);
            }
            return r;

        } catch (SQLException ex) {
            System.out.println("Gagal Get Data Ruangan");
            return null;
        }
    }

    public List<Peminjaman> getPeminjamanbyIdPeminjam(int id) {
        List<Peminjaman> daftar = new ArrayList<>();
        try {
            String query = "SELECT * FROM Peminjaman where id_peminjam ='" + id + "'";
            System.out.println(id);
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Peminjaman p = new Peminjaman();
                p.setId_peminjaman(rs.getInt(1));
                p.setId_peminjam(rs.getInt(2));
                p.setRuanganDipinjam(rs.getString(3));
                daftar.add(p);
            }
            return daftar;

        } catch (SQLException ex) {
            System.out.println("Gagal Get Data Peminjaman");
            return null;
        }
    }

    public void deletePeminjaman(Peminjaman pe) {
        try {
            String query = "DELETE FROM Peminjaman WHERE"
                    + " id_peminjaman = '" + pe.getId_peminjaman() + "'";
            statement.execute(query);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data tidak bisa di hapus!");
            System.out.println("Gagal DELETE" + ex);
        }
    }

    public void updateDataRuangan(Ruangan r) {
        try {
            String query = "UPDATE RUANGAN SET nama_ruangan = '" + r.getNama_ruangan() + "'"
                    + ", status = '" + r.getStatus() + "', harga = '" + r.getHarga() + "' where nama_ruangan ='"
                    + r.getNama_ruangan() + "'";
            statement.execute(query);
        } catch (SQLException ex) {
            System.out.println("update data gagal" + ex);
        }
    }

    public void deletePeminjamanbyRuangan(Ruangan r) {
        try {
            String query = "DELETE FROM Peminjaman WHERE"
                    + " nama_ruangan = '" + r.getNama_ruangan() + "'";
            statement.execute(query);
          
        } catch (SQLException ex) {
        }

    }
}
