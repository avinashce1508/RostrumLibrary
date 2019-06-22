package main;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import admin.AdminLogin;
import dimen.Dimen;
import librarian.LibrarianLogin;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private JButton btnAdmin;
	private JButton btnLibrarian;
	private JLabel title;
	private JLabel imageIcon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Dimen.SCREEN_WIDTH, Dimen.SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setBackground(Color.white);
		contentPane.setBounds(0, 0, Dimen.SCREEN_WIDTH, Dimen.SCREEN_HEIGHT);
		setContentPane(contentPane);
		
		imageIcon = new JLabel();
		imageIcon.setBounds(Dimen.SCREEN_WIDTH/2-70, 100 , 100 , 100);
		imageIcon.setIcon(new ImageIcon("/home/avinash/workspace/Library Management System/images/library.png"));
		contentPane.add(imageIcon);
		
		title = new JLabel("<HTML><CENTER><B><FONT >Library Management System</FONT></B></CENTER></HTML>");
		title.setBounds(Dimen.SCREEN_WIDTH/2-250, 180, 600, 100);
		title.setFont(new Font("SansSerif ", Font.PLAIN, 28));
		title.setForeground(new Color(230, 0, 57));
		contentPane.add(title);
		Icon adminicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/admin.png");
		btnAdmin = new JButton( "<HTML><CENTER><B><FONT >Administrator</FONT></B></CENTER></HTML>" , adminicon);
		btnAdmin.setBounds(Dimen.SCREEN_WIDTH/2-300, Dimen.SCREEN_HEIGHT/2, 200, 100);
		btnAdmin.setBackground(new Color(230, 0, 57));
		btnAdmin.setFocusable(false);
		btnAdmin.setForeground(Color.WHITE);

		btnAdmin.setBorder(null);
		contentPane.add(btnAdmin);

		btnAdmin.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnAdmin.setBackground(new Color(179, 0, 45));
			}

			public void mouseExited(MouseEvent e) {
				btnAdmin.setBackground(new Color(230, 0, 57));
			}

		}); // end of Login button mouse listener

		btnAdmin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				btnAdmin_OnClick_Action_Performed();

			}

		});// end of Login button action listener
		
		Icon librarianicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/librarian.png");
		btnLibrarian = new JButton("<HTML><CENTER><B><FONT >Librarian</FONT></B></CENTER></HTML>" , librarianicon);
		btnLibrarian.setBounds(Dimen.SCREEN_WIDTH/2+50, Dimen.SCREEN_HEIGHT/2, 200, 100);
		btnLibrarian.setBackground(new Color(230, 0, 57));
		btnLibrarian.setFocusable(false);
		btnLibrarian.setForeground(Color.WHITE);

		btnLibrarian.setBorder(null);
		contentPane.add(btnLibrarian);

		btnLibrarian.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnLibrarian.setBackground(new Color(179, 0, 45));
			}

			public void mouseExited(MouseEvent e) {
				btnLibrarian.setBackground(new Color(230, 0, 57));
			}

		}); // end of Login button mouse listener

		btnLibrarian.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				btnLibrarian_OnClick_Action_Performed();

			}

		});// end of Login button action listener

	}

	protected void btnLibrarian_OnClick_Action_Performed() {
		new LibrarianLogin();
		dispose();
	}

	protected void btnAdmin_OnClick_Action_Performed() {
		
		new AdminLogin();	
		dispose();
	}

}
