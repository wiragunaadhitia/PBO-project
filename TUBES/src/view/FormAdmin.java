/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Model.PeminjamanTabelModel;
import Model.RuanganTabelModel;
import com.sun.glass.ui.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JComboBox;

/**
 *
 * @author USer
 */
public class FormAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FormAdmin
     */
    public FormAdmin() {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        tfHarga.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNamaRuangan = new javax.swing.JTextField();
        tfHargaRuangan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radioAvailable = new javax.swing.JRadioButton();
        radioNAvailable = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        btnAddRuangan = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRuangan = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        lblNamaRuanagan = new javax.swing.JLabel();
        lblHarga = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        tfNRuangan = new javax.swing.JTextField();
        tfHarga = new javax.swing.JTextField();
        btnUbah = new javax.swing.JButton();
        cbxStatus = new javax.swing.JComboBox<>();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(41, 128, 185));

        jPanel1.setBackground(new java.awt.Color(41, 128, 185));

        jLabel1.setText("Add Ruangan");

        jLabel2.setText("Nama");

        jLabel3.setText("Harga");

        buttonGroup1.add(radioAvailable);
        radioAvailable.setText("Available");

        buttonGroup1.add(radioNAvailable);
        radioNAvailable.setSelected(true);
        radioNAvailable.setText("Not Available");

        jLabel4.setText("Status");

        btnAddRuangan.setText("Add");

        btnLogout.setText("Logout");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioAvailable)
                            .addComponent(radioNAvailable)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddRuangan)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfNamaRuangan, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                .addComponent(tfHargaRuangan)))))
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNamaRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfHargaRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioAvailable)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioNAvailable)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddRuangan)
                    .addComponent(btnLogout))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Buat ruangan", jPanel1);

        tblRuangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRuangan);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel5.setText("Daftar Semua Ruangan");

        lblNamaRuanagan.setText("Nama Ruangan :");

        lblHarga.setText("Harga                :");

        lblStatus.setText("Status               :");

        btnUbah.setText("Ubah");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Not Available" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamaRuanagan)
                            .addComponent(lblHarga)
                            .addComponent(lblStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfNRuangan, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                .addComponent(tfHarga))
                            .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUbah)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaRuanagan)
                    .addComponent(tfNRuangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHarga)
                    .addComponent(tfHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUbah)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lihat Semua Ruangan", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public void addListener(ActionListener e) {
        btnAddRuangan.addActionListener(e);
        btnLogout.addActionListener(e);
        btnUbah.addActionListener(e);
    }

    public JButton getBtnAddRuangan() {
        return btnAddRuangan;
    }

    public javax.swing.JTable getTableRuangan() {
        return tblRuangan;
    }

    public int getTfHargaRuangan() {
        return Integer.parseInt(tfHargaRuangan.getText());
    }

    public String getTfNamaRuangan() {
        return tfNamaRuangan.getText();
    }

    public String getRadioStatus() {
        if (radioAvailable.isSelected()) {
            return "Available";
        } else {
            return "Not Available";
        }
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public String getTfHarga() {
        return tfHarga.getText();
    }
    public int getHargaEdit(){
        return Integer.parseInt(tfHarga.getText());
    }
    public String getTfNRuangan() {
        return tfNRuangan.getText();
    }

    public String getCbxStatus() {
        return cbxStatus.getItemAt(cbxStatus.getSelectedIndex()).toString();
    }

  
    public JButton getBtnUbah() {
        return btnUbah;
    }

    public void refresh() {
        tfHargaRuangan.setText("");
        tfNamaRuangan.setText("");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRuangan;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblHarga;
    private javax.swing.JLabel lblNamaRuanagan;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JRadioButton radioAvailable;
    private javax.swing.JRadioButton radioNAvailable;
    private javax.swing.JTable tblRuangan;
    private javax.swing.JTextField tfHarga;
    private javax.swing.JTextField tfHargaRuangan;
    private javax.swing.JTextField tfNRuangan;
    private javax.swing.JTextField tfNamaRuangan;
    // End of variables declaration//GEN-END:variables
}
