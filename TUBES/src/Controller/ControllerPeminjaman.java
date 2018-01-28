/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author USer
 */
import Model.Aplikasi;
import Model.DaftarPeminjamanModel;
import Model.Peminjam;
import Model.Peminjaman;
import Model.PeminjamanTabelModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.User;
import java.awt.event.MouseAdapter;
import view.PeminjamanForm;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import Model.Ruangan;
import java.util.*;

public class ControllerPeminjaman extends MouseAdapter implements ActionListener {

    private Aplikasi model;
    private PeminjamanForm view;
    private Peminjaman model1;
    private Peminjam peminjam;
    private ArrayList<Ruangan> daftarRuangan;

    public ControllerPeminjaman(Aplikasi model, Peminjam pe) {
        daftarRuangan = new ArrayList<>();
        this.model = model;
        view = new PeminjamanForm();
        view.setVisible(true);
        view.addListener(this);
        view.getTblRuangantTersedia().setModel(new PeminjamanTabelModel());
        view.addMouseListener(this);

        view.refresh();
        peminjam = pe;
        view.getTblDaftarPeminjaman().setModel(new DaftarPeminjamanModel(peminjam));
        System.out.println(peminjam.getId() + "test");
        view.getLabelNama().setText(pe.getNama());
        view.getLabelUsername().setText(pe.getUsername());
        view.getLabelPasswod().setText(pe.getPassword());

    }

    private String[] getDaftarRuangan() {
        String[] daftarNama = new String[daftarRuangan.size()];
        for (int i = 0; i < daftarNama.length; i++) {
            daftarNama[i] = daftarRuangan.get(i).getNama_ruangan();
        }
        return daftarNama;
    }

    private Ruangan getSelectedRuangan(String r) {
        for (Ruangan o : daftarRuangan) {
            if (o.getNama_ruangan() == r) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAddRuangan())) {
            Ruangan r = new Ruangan();
            int row = view.getTblRuangantTersedia().getSelectedRow();
            r.setNama_ruangan(view.getTblRuangantTersedia().getValueAt(row, 0).toString());
            r.setHarga(Integer.parseInt(view.getTblRuangantTersedia().getValueAt(row, 1).toString()));
            r.setStatus(view.getTblRuangantTersedia().getValueAt(row, 2).toString());
            if (model.isRuangan(daftarRuangan, r) == false) {
                daftarRuangan.add(r);
            } else {
                JOptionPane.showMessageDialog(view, "Anda sudah menambahkan Ruangan ini");
            }
            view.refresh();
            view.getListRuanganDipinjam().setListData(getDaftarRuangan());
        } else if (source.equals(view.getBtnDeleteRuangan())) {
            String ruangan = view.getListRuanganDipinjam().getSelectedValue();
            daftarRuangan.remove(getSelectedRuangan(ruangan));
            view.getListRuanganDipinjam().setListData(getDaftarRuangan());
        } else if (source.equals(view.getBtnPinjam())) {
            JOptionPane.showMessageDialog(view, "Anda Berhasil Melakukan Peminjaman");
            Peminjaman p = new Peminjaman();
            model.RegisterPeminjaman(daftarRuangan, p, peminjam);
            view.dispose();
            new ControllerPeminjaman(model, peminjam);
        } else if (source.equals(view.getBtnLogout())) {
            new ControllerLogin(model);
            view.dispose();
        } else if (source.equals(view.getBtnUbah())) {
            if (view.getTfeditNama().equals("") || view.getTfeditPassword().equals("") || view.getTfeditNama().equals("")) {
                JOptionPane.showMessageDialog(null, "Semua data harus terisi");
            } else {
                String username, password, nama;
                username = view.getTfeditUsername();
                password = view.getTfeditPassword();
                nama = view.getTfeditNama();
//                Peminjam p = new Peminjam (username,password,nama)
                peminjam.setNama(nama);
                peminjam.setPassword(password);
                peminjam.setUsername(username);
                model.ubahDataPeminjam(peminjam, peminjam.getId());
                JOptionPane.showMessageDialog(view, "Data Diri Berhasil Diubah");
                view.dispose();
                new ControllerPeminjaman(model, peminjam);
            }
        } else if (source.equals(view.getBtnDelete())) {
            Peminjaman pe = new Peminjaman();
            int row = view.getTblDaftarPeminjaman().getSelectedRow();
            pe.setId_peminjaman(Integer.parseInt(view.getTblDaftarPeminjaman().getValueAt(row, 0).toString()));
            pe.setId_peminjam(Integer.parseInt(view.getTblDaftarPeminjaman().getValueAt(row, 1).toString()));
            pe.setRuanganDipinjam(view.getTblDaftarPeminjaman().getValueAt(row, 2).toString());
            model.hapusPeminjaman(pe);
            view.dispose();
            new ControllerPeminjaman(model,peminjam);
        }

    }
}
