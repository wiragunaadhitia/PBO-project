/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.table.AbstractTableModel;
import Database.Database;
import java.util.List;
import java.util.ArrayList;
import Model.Ruangan;

/**
 *
 * @author USer
 */

public class PeminjamanTabelModel extends AbstractTableModel {

    Database data;
    List<Ruangan> daftar = new ArrayList<>();

    public PeminjamanTabelModel() {
        data = new Database();
        lihatRuangan();
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
                return daftar.get(rowIndex).getNama_ruangan();
            case 1:
                return daftar.get(rowIndex).getHarga();
            case 2:
                return daftar.get(rowIndex).getStatus();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama Ruangan";
            case 1:
                return "Harga";
            case 2:
                return "Status";
            default:
                return null;
        }
    }

    public void lihatRuangan() {
        daftar = data.getRuanganbyStatus("Available");
        fireTableDataChanged();
    }
}
