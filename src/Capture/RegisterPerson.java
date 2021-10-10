/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capture;

import Util.ConnectDB;

public class RegisterPerson extends javax.swing.JFrame {

	ConnectDB db = new ConnectDB();

	public RegisterPerson() throws ClassNotFoundException {
		initComponents();
		showIdUser();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		txt_id_label = new javax.swing.JLabel();
		jPanel3 = new javax.swing.JPanel();
		txt_office = new javax.swing.JTextField();
		txt_first_name = new javax.swing.JTextField();
		txt_last_name = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		txt_dob = new javax.swing.JFormattedTextField();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Security System - Register Person");
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jPanel1.setBackground(new java.awt.Color(250, 250, 250));
		jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jPanel2.setBackground(new java.awt.Color(255, 255, 255));
		jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		txt_id_label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		txt_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		txt_id_label.setText("ID: 1");
		jPanel2.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 450, -1));

		jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 60));

		jPanel3.setBackground(new java.awt.Color(255, 255, 255));
		jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		jPanel3.add(txt_office, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 150, -1));
		jPanel3.add(txt_first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 150, -1));
		jPanel3.add(txt_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 150, -1));

		jLabel2.setForeground(new java.awt.Color(100, 100, 100));
		jLabel2.setText("Last Name");
		jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

		jLabel3.setForeground(new java.awt.Color(100, 100, 100));
		jLabel3.setText("Dob");
		jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

		jLabel4.setForeground(new java.awt.Color(100, 100, 100));
		jLabel4.setText("Office");
		jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

		jLabel5.setForeground(new java.awt.Color(100, 100, 100));
		jLabel5.setText("First Name");
		jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

		try {
			txt_dob.setFormatterFactory(
					new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
		} catch (java.text.ParseException ex) {
			ex.printStackTrace();
		}
		jPanel3.add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 150, -1));

		jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 470, 160));

		jButton1.setBackground(new java.awt.Color(79, 83, 212));
		jButton1.setForeground(new java.awt.Color(255, 255, 255));
		jButton1.setText("Next");
		jButton1.setContentAreaFilled(false);
		jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		jButton1.setOpaque(true);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});
		jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 90, -1));

		getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));

		setSize(new java.awt.Dimension(485, 333));
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		int id = Integer.parseInt(txt_id_label.getText().replace("ID: ", ""));
		System.out.println("id má»›i:" + id);

		String fName = txt_first_name.getText();
		String lName = txt_last_name.getText();
		String dob = txt_dob.getText();
		String office = txt_office.getText();
		new Capture(id, fName, lName, dob, office).setVisible(true);
		dispose();
	}// GEN-LAST:event_jButton1ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(RegisterPerson.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new RegisterPerson().setVisible(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JFormattedTextField txt_dob;
	private javax.swing.JTextField txt_first_name;
	private javax.swing.JLabel txt_id_label;
	private javax.swing.JTextField txt_last_name;
	private javax.swing.JTextField txt_office;
	// End of variables declaration//GEN-END:variables

	private void showIdUser() throws ClassNotFoundException {
		db.connect();
		try {
			db.executeSQL("SELECT * FROM person ORDER BY id DESC LIMIT 1");
			db.rs.first(); // di chuyá»ƒn con trá»� vÃ o dÃ²ng Ä‘áº§u tiÃªn

			txt_id_label.setText(String.valueOf(db.rs.getInt("id")));
			int id = Integer.parseInt(txt_id_label.getText());
			id++;
			txt_id_label.setText("ID: " + String.valueOf(id));
		} catch (Exception e) {

		}
	}
}
