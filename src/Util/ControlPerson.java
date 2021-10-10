/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControlPerson {
	ConnectDB db = new ConnectDB();

	public void insert(ModelPerson mod) throws ClassNotFoundException {
		try {
			db.connect();

			PreparedStatement pst = db.conn.prepareStatement("INSERT INTO person VALUES (?, ?, ?, ?, ?)");

			pst.setString(1, mod.getFirstname());
			pst.setString(2, mod.getLastname());
			pst.setString(3, mod.getOffice());
			pst.setString(4, mod.getDob());
			pst.setInt(5, mod.getId());
			pst.executeUpdate();

			System.out.println("Insert success: " + mod.getFirstname() + " " + mod.getLastname());
			db.disconnect();
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
	}
}
