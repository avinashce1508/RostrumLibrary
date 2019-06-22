package admin;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import dimen.Dimen;


public class AddLibrarianPane extends JPanel {
	private JTextField tfName;
	private JLabel lblname, lblAddress, lblCity;
	private JLabel lblContactNo;

	private JFormattedTextField contact_no;
	private JButton btnSubmit, btnReset;
	private JLabel invalid_message;
	private JLabel lblemailid;
	private JTextField tfemailid;
	private JLabel lblpassword;
	private JTextField tfpassword;
	private JLabel lblUpload;
	private JLabel lblFilePath;
	private JButton btnUpload;
	private ImageChooser ic;
	private String path;
	private JLabel logo_image;
	private JTextField tfaddress;
	private JTextField tfCity;
	private JLabel lblAddLibrarian;

	public AddLibrarianPane() {

		setLayout(null);
		setSize(Dimen.SCREEN_WIDTH , (Dimen.SCREEN_HEIGHT - 120));
		setBackground(Color.WHITE);

		logo_image = new JLabel("");
		logo_image.setBounds((Dimen.SCREEN_WIDTH/2-50) , 50 , 100 , 50);
		add(logo_image);
		logo_image.setIcon(new ImageIcon("/home/avinash/workspace/Library Management System/images/addlibrarian.png"));
		
		lblAddLibrarian = new JLabel("ADD LIBRARIAN");
		lblAddLibrarian.setBounds(560, 50, 250, 30);
		lblAddLibrarian.setFont(new Font("Tahoma" , Font.BOLD , 25));
		add(lblAddLibrarian);

		lblname = new JLabel("Name");
		lblname.setBounds(300, 150, 100, 30);
		add(lblname);

		tfName = new JTextField();
		tfName.setBounds(420, 150, 500, 30);
		tfName.setColumns(10);
		add(tfName);
		
		lblemailid = new JLabel("Emp ID ");
		lblemailid.setBounds(300, 190, 100, 30);
		add(lblemailid);

		tfemailid = new JTextField();
		tfemailid.setBounds(420, 190, 500, 30);
		tfemailid.setColumns(10);
		add(tfemailid);

		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(300, 230, 100, 30);
		add(lblAddress);

		tfaddress = new JTextField();
		tfaddress.setColumns(30);
		tfaddress.setBounds(420, 230, 500, 30);
		add(tfaddress);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(300, 270, 100, 30);
		add(lblCity);

		tfCity = new JTextField();
		tfCity.setColumns(30);
		tfCity.setBounds(420, 270, 500, 30);
		add(tfCity);

		lblContactNo = new JLabel("Contact No");
		lblContactNo.setBounds(300, 310, 100, 30);
		add(lblContactNo);

		contact_no = new JFormattedTextField();
		contact_no.setColumns(10);
		contact_no.setBounds(420, 310, 500, 30);
		add(contact_no);
		

		lblpassword = new JLabel("Password");
		lblpassword.setBounds(300, 350, 100, 30);
		add(lblpassword);

		tfpassword = new JTextField();
		tfpassword.setBounds(420, 350, 500, 30);
		tfpassword.setColumns(10);
		add(tfpassword);

		lblUpload = new JLabel("upload ");
		lblUpload.setBounds(300, 390, 100, 30);
		add(lblUpload);

		lblFilePath = new JLabel("");
		lblFilePath.setBounds(420, 390, 450, 30);
		add(lblFilePath);

		btnUpload = new JButton("", new ImageIcon("/home/avinash/workspace/Library Management System/images/upload.png"));
		btnUpload.setBackground(Color.white);
		btnUpload.setBorder(null);
		btnUpload.setFocusable(false);
		btnUpload.setBounds(870, 390, 50 , 50);
		add(btnUpload);

		btnUpload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ic = new ImageChooser();
				path = ic.getImagePath();
				lblFilePath.setText(path);

			}
		});

		invalid_message = new JLabel("");
		invalid_message.setBounds(420, 460, 600, 15);
		add(invalid_message);

		// login credential panel
		
	
		btnSubmit = new JButton("SUBMIT" , new ImageIcon("/home/avinash/workspace/Library Management System/images/submit.png"));
		btnSubmit.setBounds(440 , 500 , 200 , 40);
		btnSubmit.setBackground(new Color(230, 0, 57));
		btnSubmit.setForeground(Color.white);
		btnSubmit.setFocusable(false);
		btnSubmit.setBorder(null);
		add(btnSubmit);

		btnSubmit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnSubmit.setBackground(new Color(179, 0, 45));
			}

			public void mouseExited(MouseEvent e) {
				btnSubmit.setBackground(new Color(230, 0, 57));
			}

		});
		btnSubmit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					btnSubmit_OnClicked_Action_Performed();
				} catch (IOException | ClassNotFoundException e1) {

					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnReset = new JButton("RESET" , new ImageIcon("/home/avinash/workspace/Library Management System/images/reset.png"));
		btnReset.setBounds(690 , 500 , 200 , 40);
		btnReset.setBackground(new Color(230, 0, 57));
		btnReset.setForeground(Color.WHITE);
		btnReset.setFocusable(false);
		btnReset.setBorder(null);
		add(btnReset);

		btnReset.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnReset.setBackground(new Color(179, 0, 45));
			}

			public void mouseExited(MouseEvent e) {
				btnReset.setBackground(new Color(230, 0, 57));
			}

		});
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnReset_OnClicked_Action_Performed();

			}
		});

	}

	private void btnSubmit_OnClicked_Action_Performed() throws IOException, ClassNotFoundException, SQLException {

		if (tfName.getText().equals("") || tfaddress.getText().equals("") || contact_no.getText().equals("")||tfemailid.getText().trim().equals("") || tfpassword.getText().trim().equals("")) {

			invalid_message.setText("<HTML><FONT COLOR = RED> Please , fill the all field in personal info</FONT></HTML>");

			Timer t = new Timer(2000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					invalid_message.setText(null);
				}
			}); // end of Timer action listener
			t.start();
			t.setRepeats(false);
			return;

		} else {
			String name = tfName.getText().trim();
			String address = tfaddress.getText().trim();
			String email = tfemailid.getText().trim();
			String city = tfCity.getText().trim(); 
			long contact_No = 0;

			if (contact_no.getText().trim().length() < 10 || contact_no.getText().trim().length() > 10) {
				invalid_message
				.setText("<HTML><FONT COLOR = RED> Please , fill the correct mobile number</FONT></HTML>");

				Timer t = new Timer(2000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						invalid_message.setText(null);
					}
				}); // end of Timer action listener
				t.start();
				t.setRepeats(false);
				return;
			} else if (Integer.parseInt(contact_no.getText().trim().substring(0, 2)) < 70) {
				invalid_message
				.setText("<HTML><FONT COLOR = RED> Please , fill the correct mobile number</FONT></HTML>");

				Timer t = new Timer(2000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						invalid_message.setText(null);
					}
				}); // end of Timer action listener
				t.start();
				t.setRepeats(false);
				return;
			} else {
				contact_No = Long.parseLong(contact_no.getText().trim());
			}
			String password = tfpassword.getText().trim();
			String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";
			if (!password.matches(pattern)) {
				invalid_message
				.setText("<HTML><FONT COLOR = RED> Please ,password must contain atleast number,lowercase,uppercase and symbols </FONT></HTML>");

				Timer t = new Timer(2000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						invalid_message.setText(null);
					}
				}); // end of Timer action listener
				t.start();
				t.setRepeats(false);
				return;

			}

			File file = new File(path);
			byte[] byte_array_of_images = null;
			try {
				FileInputStream fis = new FileInputStream(file);
				byte_array_of_images = new byte[100000];
				fis.read(byte_array_of_images, 0, byte_array_of_images.length);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			LibrarianInfoUpload uploadInfo = new LibrarianInfoUpload(name, password, email, address, city, contact_No, byte_array_of_images);
			if (uploadInfo.uploadInfoToDatabase()) {
				JOptionPane.showMessageDialog(null, "Librarian information is successfully added", "Add Librarian",
					JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Librarian information is not added", "Add Librarian",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		
	}

	private void btnReset_OnClicked_Action_Performed() {

		tfName.setText("");
		tfaddress.setText("");
		contact_no.setText("");
		tfemailid.setText(null);
		tfpassword.setText(null);

	}
}