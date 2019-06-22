package librarian;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import dimen.Dimen;
import login.ForgetPassword;
import login.LoginVerification;
import main.MainPage;

public class LibrarianLogin extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogin;
	private JCheckBox cbxShowPassword;
	private JLabel lblUsername;
	private JTextField tfUsername;
	private JSeparator userseparator;
	private JLabel lblPassword;
	private JPasswordField pfpassword;
	private JSeparator passseparator;
	private JButton btnForgetPassword;
	private JPanel loginpane;
	private JButton btnLogin;
	private JLabel lblInvalidMessage;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianLogin frame = new LibrarianLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public LibrarianLogin() {

		setVisible(true);
		setBounds(0, 0, Dimen.SCREEN_WIDTH, Dimen.SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		contentPane.setBounds(0, 0, Dimen.SCREEN_WIDTH, Dimen.SCREEN_HEIGHT);
		setContentPane(contentPane);
		
		

		loginpane = new JPanel();
		loginpane.setBounds((Dimen.SCREEN_WIDTH / 2 - 352), (Dimen.SCREEN_HEIGHT / 2 - 200), 600, 400);
		loginpane.setBackground(Color.WHITE);
		loginpane.setVisible(true);
		contentPane.add(loginpane);
		loginpane.setLayout(null);
		
		lblLogin = new JLabel(" LOGIN ");
		lblLogin.setFont(new Font("Tahoma" , Font.BOLD , 25));
		lblLogin.setBounds(235, 20, 150, 30);
		lblLogin.setForeground(new Color(230, 0, 57));
		loginpane.add(lblLogin);
		
		btnLogin = new JButton("<HTML><CENTER><B><FONT >LOGIN</FONT></B></CENTER></HTML>");
		btnLogin.setBounds(100, 304, 400, 35);
		btnLogin.setBackground(new Color(230, 0, 57));
		btnLogin.setFocusable(false);
		btnLogin.setForeground(Color.WHITE);
		getRootPane().setDefaultButton(btnLogin);

		btnLogin.setBorder(null);
		loginpane.add(btnLogin);

		btnLogin.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(179, 0, 45));
			}

			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(new Color(230, 0, 57));
			}

		}); // end of Login button mouse listener

		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				btnLogin_OnClick_Action_Performed();

			}

		});// end of Login button action listener

		lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(100, 83, 132, 15);
		loginpane.add(lblUsername);

		tfUsername = new JTextField();
		tfUsername.setBounds(100, 110, 400, 35);
		tfUsername.setColumns(10);
		tfUsername.setFont(new Font("Arial", Font.BOLD, 15));
		tfUsername.setMargin(new Insets(5, 15, 5, 15));
		// tfUsername.setUI(new );
		tfUsername.setBorder(null);
		loginpane.add(tfUsername);

		userseparator = new JSeparator();
		userseparator.setBounds(100, 145, 400, 2);

		loginpane.add(userseparator);

		tfUsername.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {

				userseparator.setForeground(new Color(255, 26, 83));
			}

			public void mouseExited(MouseEvent e) {
				userseparator.setForeground(UIManager.getColor(userseparator));
			}
		}); // end of mouse listener for Username field

		lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(100, 169, 132, 15);
		loginpane.add(lblPassword);

		pfpassword = new JPasswordField();
		pfpassword.setColumns(10);
		pfpassword.setBorder(null);
		pfpassword.setFont(new Font("Arial", Font.BOLD, 15));
		pfpassword.setMargin(new Insets(5, 15, 5, 15));
		pfpassword.setBounds(100, 196, 400, 35);
		loginpane.add(pfpassword);

		pfpassword.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				passseparator.setForeground(new Color(255, 26, 83));
			}

			public void mouseExited(MouseEvent e) {
				passseparator.setForeground(UIManager.getColor(passseparator));
			}
		}); // end of mouse listener for password field

		passseparator = new JSeparator();
		passseparator.setBounds(100, 231, 400, 2);
		loginpane.add(passseparator);

		btnForgetPassword = new JButton("<HTML><CENTER><B><FONT >FORGET PASSWORD ?</FONT></B></CENTER></HTML>");
		btnForgetPassword.setBounds(330, 240, 200, 20);
		btnForgetPassword.setBackground(Color.WHITE);
		btnForgetPassword.setFocusable(false);
		btnForgetPassword.setBorderPainted(false);
		btnForgetPassword.setContentAreaFilled(false);
		btnForgetPassword.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent e) {

				btnForgetPassword.setForeground(Color.RED);
			}

			public void mouseExited(MouseEvent e) {
				btnForgetPassword.setForeground(Color.BLACK);
			}
		}); // end of mouse listener for forget password

		loginpane.add(btnForgetPassword);

		btnForgetPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				btnForgetPassword_OnClick_Action_Performed();

			}

		});// end of forget password button action listener

		cbxShowPassword = new JCheckBox("<HTML><CENTER><B><FONT >SHOW PASSWORD</FONT></B></CENTER></HTML>");
		cbxShowPassword.setBackground(Color.white);
		cbxShowPassword.setBounds(100, 240, 200, 20);
		cbxShowPassword.setFocusable(false);
		loginpane.add(cbxShowPassword);

		cbxShowPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				cbxShowPassword_OnChecked_Action_Performed();
			}

		}); // end of cbxShowPassword action listener

		lblInvalidMessage = new JLabel("");
		lblInvalidMessage.setBounds(100, 270, 400, 20);
		loginpane.add(lblInvalidMessage);
		
		JLabel background = new JLabel();	
		background.setLayout(null);
		background.setBounds(0 , 0 ,(Dimen.SCREEN_WIDTH), (Dimen.SCREEN_HEIGHT) );
		add(background);
		background.setIcon(new ImageIcon("/home/avinash/workspace/Library Management System/images/library2.jpg"));
	}

	protected void btnLogin_OnClick_Action_Performed() {
		String Username = tfUsername.getText().trim();
		char[] pass = pfpassword.getPassword();
		String password = String.copyValueOf(pass);

		// Now we have to check the credentials are valid or not
		if (Username.equals("") || password.equals("")) {

			lblInvalidMessage.setText("<HTML><B><FONT COLOR = RED >Fill the empty fields..</FONT></B></HTML>");
			lblInvalidMessage.setVisible(true);

			Timer t = new Timer(2000, new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					lblInvalidMessage.setText(null);
				}
			}); // end of Timer action listener
			t.start();
			t.setRepeats(false);

		} else {
			try {
				LoginVerification loginVerification = new LoginVerification(Username, password);
				if (loginVerification.verifyUser()) {
					new LibrarianMainPage();
					tfUsername.setText(null);
					pfpassword.setText(null);
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "login unsuccessful , please try again");
				} // end of if-else block

			} catch (Exception e) {
				// System.out.println("cannot bind the connection " + e.getMessage());
				e.printStackTrace();
				// System.exit(1);
			}

		} // end of if-else block


	}

	protected void cbxShowPassword_OnChecked_Action_Performed() {

		if (cbxShowPassword.isSelected()) {
			pfpassword.setEchoChar((char) 0);
		} else {
			pfpassword.setEchoChar((char) '*');
		}

	}

	protected void btnForgetPassword_OnClick_Action_Performed() {
		new ForgetPassword();
	}

}


