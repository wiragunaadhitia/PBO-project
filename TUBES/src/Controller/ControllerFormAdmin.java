/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.User;
import javax.swing.JOptionPane;
import Model.Peminjam;
import Model.Ruangan;
import Model.Admin;
import view.FormAdmin;
import Model.RuanganTabelModel;

/**
 *
 * @author USer
 */
public class ControllerFormAdmin implements ActionListener {

    private Aplikasi model;
    private FormAdmin view;

    public ControllerFormAdmin(Aplikasi model) {
        this.model = model;
        view = new FormAdmin();
        view.setVisible(true);
        view.addListener(this);
        view.getTableRuangan().setModel(new RuanganTabelModel());

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnAddRuangan())) {
            if (view.getTfNamaRuangan().equals("")) {
                JOptionPane.showMessageDialog(view, "Semua Data Harus Terisi Semua");

            } else {
                String nama_ruangan = view.getTfNamaRuangan();
                int harga = view.getTfHargaRuangan();
                String status = view.getRadioStatus();
                Ruangan r = new Ruangan(nama_ruangan, harga, status);
                model.addRuangan(r);

                RuanganTabelModel rtm = new RuanganTabelModel();
                rtm.updateRuangan();
                view.getTableRuangan().setModel(rtm);
            }
            view.refresh();
        }
        else if (source.equals(view.getBtnLogout())){
            new ControllerLogin(model);
            view.dispose();
        }
        else if (source.equals(view.getBtnUbah())){
            if (view.getTfHarga().equals("") || view.getTfNRuangan().equals("")) {
                JOptionPane.showMessageDialog(view, "Semua data harus terisi");
            } else {
                String nama_ruangan,status;
                int harga;
                nama_ruangan = view.getTfNRuangan();
                status = view.getCbxStatus();
                harga = view.getHargaEdit();
                Ruangan r = new Ruangan ();
                r.setNama_ruangan(nama_ruangan);
                r.setStatus(status);
                r.setHarga(harga);
                model.ubahDataRuangan(r);
                model.cekPeminjaman(r);
                JOptionPane.showMessageDialog(view, "Data Ruangan Berhasil Diubah");
                view.dispose();
                new ControllerFormAdmin(model);
            }
        }

    }
}
