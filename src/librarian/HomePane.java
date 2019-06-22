package librarian;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import database.DatabaseConnectivity;
import dimen.Dimen;

public class HomePane extends JPanel {

	private JTextField tfIsbn;
	private JButton btnSearch;
	private JLabel libraryName;

	public HomePane() {
		setLayout(null);
		setSize((Dimen.SCREEN_WIDTH), (Dimen.SCREEN_HEIGHT-120));
		setBackground(Color.WHITE);
		
		libraryName = new JLabel();
		

		tfIsbn = new JTextField();
		tfIsbn.setBounds(300, Dimen.SCREEN_HEIGHT/2-25 , 500 , 50);
		tfIsbn.setColumns(10);
		tfIsbn.setFont(new Font("Tahoma" , Font.PLAIN , 20));
		add(tfIsbn);

		btnSearch = new JButton("Search book", new ImageIcon("/home/avinash/workspace/Library Management System/images/search.png"));
		btnSearch.setBackground(Color.white);
		btnSearch.setBorder(null);
		btnSearch.setFocusable(false);
		btnSearch.setForeground(Color.white);
		btnSearch.setFont(new Font("Tahoma" , Font.PLAIN , 20));
		btnSearch.setBackground(new Color(255, 102, 0));
		btnSearch.setBounds(850, Dimen.SCREEN_HEIGHT/2-25 , 200 , 50);
		add(btnSearch);

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					DatabaseConnectivity dbconnect = new DatabaseConnectivity();
					Connection connection = dbconnect.getConnection();
					String isbnNo = tfIsbn.getText().toString();
					PreparedStatement pst = connection.prepareStatement("Select * from books where isbn = ?");
					pst.setString(1, isbnNo);
					
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null , "Book is available" , "Library" , JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Book is not availabel", "Library", JOptionPane.INFORMATION_MESSAGE);
					}
					
				}catch(SQLException sqle) {
					sqle.printStackTrace();
				}
			}
		});

	}
}