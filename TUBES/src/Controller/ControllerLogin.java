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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.User;
import view.Login;
import javax.swing.JOptionPane;
import Model.Peminjam;
import Model.Ruangan;
import Model.Admin;
import Model.Peminjaman;

public class ControllerLogin implements ActionListener {

    private Aplikasi model;
    private Login view;

    public ControllerLogin(Aplikasi model) {
        this.model = model;
        view = new Login();
        view.setVisible(true);
        view.addListener(this);
    }

    public ControllerLogin() {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(view.getBtnLogin())) {
            if (view.getUsername().equals("") || view.getPassword().equals("")) {
                JOptionPane.showMessageDialog(view, "Semua data harus terisi");
            } else {
                String username = view.getUsername();
                String password = view.getPassword();
                if (model.LoginPeminjam(username, password) != null) {
                    Peminjam p = model.LoginPeminjam(username, password);
                    JOptionPane.showMessageDialog(view, "Anda Berhasil Login");
                    new ControllerPeminjaman(model,p);
                    view.dispose();
                } else if (model.LoginAdmin(username, password) != null) {
                    Admin a = model.LoginAdmin(username, password);
                    JOptionPane.showMessageDialog(view, "Anda Berhasil Login");
                    new ControllerFormAdmin(model);
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(view, "Username/password salah");

                }
                view.refresh();
            }
        } else if (source.equals(view.getBtnRegister())) {
            new ControllerRegister(model);
            view.dispose();
        }
    }

}
