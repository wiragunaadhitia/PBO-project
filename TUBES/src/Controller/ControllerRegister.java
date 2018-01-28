/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Database;
import Model.Aplikasi;
import Model.Peminjam;
import Model.Ruangan;
import view.Register;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author USer
 */
public class ControllerRegister implements ActionListener {

    private Aplikasi model;
    private Register view;

    public ControllerRegister(Aplikasi model) {
        this.model = model;
        view = new Register();
        view.setVisible(true);
        view.addListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnRegister())) {
            if (view.getUsername().equals("") || view.getPassword().equals("") || view.getNama().equals("")) {
                JOptionPane.showMessageDialog(null, "Semua data harus terisi");
            } else {
                String nama = view.getNama();
                String username = view.getUsername();
                String password = view.getPassword();
                Peminjam p = new Peminjam(username, password, nama);
                model.RegisterPeminjam(p);
            }
            view.refresh();
            new ControllerLogin(model);
            view.dispose();
        } else if (source.equals(view.getBtnBackLogin())) {
            new ControllerLogin(model);
            view.dispose();
        }

    }

}
