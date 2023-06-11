package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.DatabaseViewer;

public class View {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DatabaseViewer s = new DatabaseViewer();

		String url = "jdbc:mysql://localhost:3306/swing2", uname = "root", pass = "abc123";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
		Statement st = con.createStatement();

		JFrame f = new JFrame("Student Info");

		JLabel label1 = new JLabel(" * Insert");
		label1.setFont(new Font("Algerian", Font.BOLD, 20));
		label1.setBounds(140, 5, 130, 60);

		JTextField t1 = new JTextField();
		t1.setFont(new Font("Algerian", Font.BOLD, 17));
		t1.setBounds(130, 50, 100, 40);
		JLabel l1 = new JLabel("Roll : - ");
		l1.setFont(new Font("Algerian", Font.BOLD, 17));
		l1.setBounds(60, 50, 100, 40);

		JTextField t2 = new JTextField();
		t2.setFont(new Font("Algerian", Font.BOLD, 17));
		t2.setBounds(130, 110, 100, 40);
		JLabel l2 = new JLabel("Name : - ");
		l2.setFont(new Font("Algerian", Font.BOLD, 17));
		l2.setBounds(60, 110, 90, 40);

		JTextField t3 = new JTextField();
		t3.setFont(new Font("Algerian", Font.BOLD, 17));
		t3.setBounds(130, 170, 100, 40);
		JLabel l3 = new JLabel("Add : - ");
		l3.setFont(new Font("Algerian", Font.BOLD, 17));
		l3.setBounds(60, 170, 100, 40);

		JButton b1 = new JButton("Insert");
		b1.setFont(new Font("Algerian", Font.BOLD, 17));
		b1.setBounds(50, 230, 230, 40);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int roll = Integer.parseInt(t1.getText());
				String name = t2.getText();
				String add = t3.getText();

				try {
					int a = st.executeUpdate("Insert into sw2 values(" + roll + ",'" + name + "','" + add + "')");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(b1, "DATA -INSETED");
				t1.setText("");
				t2.setText("");
				t3.setText("");

			}
		});

		JLabel label2 = new JLabel(" * UPDATE NAME");
		label2.setFont(new Font("Algerian", Font.BOLD, 20));
		label2.setBounds(110, 280, 200, 40);

		JTextField t11 = new JTextField();
		t11.setFont(new Font("Algerian", Font.BOLD, 17));
		t11.setBounds(130, 330, 100, 40);
		JLabel l11 = new JLabel("Roll : - ");
		l11.setFont(new Font("Algerian", Font.BOLD, 17));
		l11.setBounds(60, 330, 100, 40);

		JTextField t22 = new JTextField();
		t22.setFont(new Font("Algerian", Font.BOLD, 17));
		t22.setBounds(130, 380, 100, 40);
		JLabel l22 = new JLabel("Name : - ");
		l22.setFont(new Font("Algerian", Font.BOLD, 17));
		l22.setBounds(60, 380, 100, 40);

		JButton b2 = new JButton("Update");
		b2.setFont(new Font("Algerian", Font.BOLD, 17));
		b2.setBounds(50, 440, 230, 40);

		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int roll = Integer.parseInt(t11.getText());
				String name = t22.getText();

				try {

					int b = st.executeUpdate("update sw2 set Name='" + name + "' where Roll=" + roll + "");

				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(b2, "DATA- UPDATE");

			}
		});

		JLabel label3 = new JLabel(" * UPDATE ADDRESS");
		label3.setFont(new Font("Algerian", Font.BOLD, 20));
		label3.setBounds(100, 500, 200, 40);

		JTextField t111 = new JTextField();
		t111.setFont(new Font("Algerian", Font.BOLD, 17));
		t111.setBounds(130, 550, 100, 40);
		JLabel l111 = new JLabel("Roll : - ");
		l111.setFont(new Font("Algerian", Font.BOLD, 17));
		l111.setBounds(60, 550, 100, 40);

		JTextField t222 = new JTextField();
		t222.setFont(new Font("Algerian", Font.BOLD, 17));
		t222.setBounds(130, 600, 100, 40);
		JLabel l222 = new JLabel("Add : - ");
		l222.setFont(new Font("Algerian", Font.BOLD, 17));
		l222.setBounds(60, 600, 100, 40);

		JButton b22 = new JButton("Update");
		b22.setFont(new Font("Algerian", Font.BOLD, 17));
		b22.setBounds(50, 650, 230, 40);

		b22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int roll = Integer.parseInt(t111.getText());
				String add = t222.getText();

				try {

					int c = st.executeUpdate("update sw2 set Address='" + add + "' where Roll=" + roll + "");

				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(b22, "DATA- UPDATE");

			}
		});

		JLabel label4 = new JLabel(" * DELETE DATA -OR- SEARCH");
		label4.setFont(new Font("Algerian", Font.BOLD, 20));
		label4.setBounds(100, 710, 300, 40);

		JTextField del = new JTextField();
		del.setFont(new Font("Algerian", Font.BOLD, 17));
		del.setBounds(130, 760, 130, 40);
		JLabel d1 = new JLabel("Roll : - ");
		d1.setFont(new Font("Algerian", Font.BOLD, 17));
		d1.setBounds(60, 760, 100, 40);

		JButton D1 = new JButton("DELETE");
		D1.setFont(new Font("Algerian", Font.BOLD, 17));
		D1.setBounds(50, 810, 130, 40);

		JButton ser = new JButton("SEARCH");
		ser.setFont(new Font("Algerian", Font.BOLD, 17));
		ser.setBounds(210, 810, 130, 40);

		D1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int roll = Integer.parseInt(del.getText());

				try {

					int c = st.executeUpdate("delete from sw2 where Roll=" + roll + "");
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(D1, "DATA DELETE");

			}
		});

		ser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int roll = Integer.parseInt(del.getText());

				try {

					boolean found = false;
					ResultSet rs = st.executeQuery("Select* from sw2 where Roll=" + roll + "");
					while (rs.next()) {
						System.out.println("SEARCH ~");

						System.out.println("Roll : " + rs.getInt(1) + " ,Name :" + rs.getString(2) + " ,Address :"
								+ rs.getString(3));
						found = true;
					}
					if (!found) {
						System.out.println("Student not found ~ ");
					}
				}

				catch (SQLException e1) {
					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(ser, "DATA -SEARCH");

			}
		});

		JLabel label5 = new JLabel(" * SHOW -DATA");
		label5.setFont(new Font("Algerian", Font.BOLD, 20));
		label5.setBounds(100, 860, 200, 40);

		JButton S1 = new JButton("SHOW");
		S1.setFont(new Font("Algerian", Font.BOLD, 17));
		S1.setBounds(50, 900, 230, 40);
		S1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					s.Show();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});

		f.add(label1);// INSERT
		f.add(label2);// UPDATE NAME
		f.add(label3);// UPDATE ADDRESS
		f.add(label4);// delete
		f.add(label5);// show

		f.add(t1);
		f.add(l1);
		f.add(t2);
		f.add(l2);
		f.add(t3);
		f.add(l3);
		f.add(b1);
		f.add(b2);

		// Name
		f.add(t11);
		f.add(l11);
		f.add(t22);
		f.add(l22);
		// Address
		f.add(t111);
		f.add(l111);
		f.add(t222);
		f.add(l222);
		f.add(b22);// address update button
		// DELETE
		f.add(del);
		f.add(d1);
		f.add(d1);
		f.add(D1);
		// SHOW
		f.add(S1);
		// SEARCH
		f.add(ser);

		f.setSize(600, 1000);
		f.setLayout(null);
		f.setVisible(true);

	}

}
