/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author USer
 */
public class DaftarPeminjamanModel extends AbstractTableModel {

    Database data;
    Peminjam pem;
    List<Peminjaman> daftar = new ArrayList<>();

    public DaftarPeminjamanModel(Peminjam p) {
        data = new Database();
        pem = p;
        lihatPeminjaman();
    }

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0:
                return daftar.get(rowIndex).getId_peminjaman();
            case 1:
                return daftar.get(rowIndex).getId_peminjam();
            case 2:
                return daftar.get(rowIndex).getRuanganDipinjam();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Peminjaman";
            case 1:
                return "Id Peminjam";
            case 2:
                return "Nama Ruangan";
            default:
                return null;
        }
    }

    public void lihatPeminjaman() {
        System.out.println(pem.getId());
        daftar = data.getPeminjamanbyIdPeminjam(pem.getId());
        fireTableDataChanged();
    }
}
