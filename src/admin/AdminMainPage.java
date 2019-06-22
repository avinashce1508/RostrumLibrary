package admin;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dimen.Dimen;


public class AdminMainPage extends JFrame {

	private JPanel contentPane , headerPane  , maincontentPane;
	private JButton btnHome , btnAddLibrarian ,btnViewLibrarians , btnLogOut;
	private JLabel logo_image;
	public  AdminMainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Dimen.SCREEN_WIDTH, Dimen.SCREEN_HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setVisible(true);
		setContentPane(contentPane);
	
	    headerPane = new JPanel();
	    headerPane.setLayout(null);
	    headerPane.setBounds(0 , 0 , Dimen.SCREEN_WIDTH , 100);
	    headerPane.setBackground(Color.DARK_GRAY);
	    contentPane.add(headerPane);
	    
	    logo_image = new JLabel("");
		logo_image.setBounds(20 , 1 , 100 , 100);
		headerPane.add(logo_image);
		logo_image.setIcon(new ImageIcon("/home/avinash/workspace/Library Management System/images/librarylogo.png"));
		

//		lblHeader = new JLabel("<HTML><CENTER><B><FONT>ADMINISTRATOR</FONT></B></CENTER>	</HTML>");
//		lblHeader.setBounds(540 , 35 , 400 , 50 );
//		lblHeader.setFont(new Font("Arial" , Font.BOLD , 25));
//		lblHeader.setForeground(new Color(255, 191, 0));
//		headerPane.add(lblHeader);
	    
	    maincontentPane = new JPanel();
	    maincontentPane.setLayout(null);
	    maincontentPane.setBackground(Color.white);
	    maincontentPane.add(new HomePane());
	    maincontentPane.setBounds(0 , 100 , Dimen.SCREEN_WIDTH , Dimen.SCREEN_HEIGHT-120);
	    contentPane.add(maincontentPane);
	   
	    Icon homeicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/Home.png");
	    btnHome = new JButton("<HTML><CENTER><B><FONT >HOME</FONT></B></CENTER></HTML>" , homeicon);
	    btnHome.setBounds(120, 25 , 200, 40);
	    btnHome.setBackground(Color.DARK_GRAY);
	    btnHome.setBorder(null);
	    btnHome.setFocusable(false);
	    btnHome.setForeground(new Color(255, 191, 0));
		headerPane.add(btnHome);
		
		btnHome.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnHome.setBackground(new Color(255, 191, 0));
				btnHome.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnHome.setBackground(Color.DARK_GRAY);
				btnHome.setForeground(new Color(255, 191, 0));
			}
		}); // end of Home button mouse listener
		
	 btnHome.addActionListener(new ActionListener() {

	   @Override
	    public void actionPerformed(ActionEvent event) {
				
	      btnHome_OnClick_Action_Performed();
				
		}
			
	  });// end of Home button action listener
	  Icon addlibrarianicon = new ImageIcon("/home/avinash/workspace/Library Management System/images/addlibrarian.png");
      btnAddLibrarian = new JButton("<HTML><CENTER><B><FONT >Add Librarian</FONT></B></CENTER></HTML>" , addlibrarianicon);
      btnAddLibrarian.setBounds(330, 25 , 200, 40);
      btnAddLibrarian.setBorder(null);
      btnAddLibrarian.setBackground(Color.DARK_GRAY);
      btnAddLibrarian.setFocusable(false);
      btnAddLibrarian.setForeground(new Color(255, 191, 0));
	  headerPane.add(btnAddLibrarian);
			
	  btnAddLibrarian.addMouseListener(new MouseAdapter() {
		  public void mouseEntered(MouseEvent e) {
			  btnAddLibrarian.setBackground(new Color(255, 191, 0));
			  btnAddLibrarian.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnAddLibrarian.setBackground(Color.DARK_GRAY);
				btnAddLibrarian.setForeground(new Color(255, 191, 0));
			}
				
	   }); // end of mouse listener mouse listener
			
	   btnAddLibrarian.addActionListener(new ActionListener() {

			@Override
		    public void actionPerformed(ActionEvent event) {
				try {	
					btnAddLibrarian_OnClick_Action_Performed();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
				
		});// end of add librarian button action listener
	   Icon viewlibrarians = new ImageIcon("/home/avinash/workspace/Library Management System/images/view.png");	
		btnViewLibrarians = new JButton("<HTML><CENTER><B><FONT >View Librarians</FONT></B></CENTER></HTML>" , viewlibrarians);
		btnViewLibrarians.setBounds(540, 25 , 200, 40);
		btnViewLibrarians.setBackground(Color.DARK_GRAY);
		btnViewLibrarians.setBorder(null);
		btnViewLibrarians.setFocusable(false);
		btnViewLibrarians.setForeground(new Color(255, 191, 0));
		headerPane.add(btnViewLibrarians);
				
		btnViewLibrarians.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				btnViewLibrarians.setBackground(new Color(255, 191, 0));
				btnViewLibrarians.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnViewLibrarians.setBackground(Color.DARK_GRAY);
				btnViewLibrarians.setForeground(new Color(255, 191, 0));
			}
					
		}); // end of add librarian button mouse listener
				
		btnViewLibrarians.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
						
				btnView_OnClick_Action_Performed();
						
			}
					
		});// end of view librarian button action listener
	
		Icon logouticon = new ImageIcon("/home/avinash/workspace/Library Management System/images/Logout.png");
		btnLogOut =  new JButton("<HTML><CENTER><B><FONT>LOGOUT</FONT></B></CENTER></HTML>" , logouticon);
		btnLogOut.setBounds(1100 , 25 , 200 , 40);
		btnLogOut.setFocusable(false);
		btnLogOut.setBorder(null);
		btnLogOut.setBackground(Color.DARK_GRAY);
		btnLogOut.setForeground(new Color(255, 191, 0));
		headerPane.add(btnLogOut);
		
		btnLogOut.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				btnLogOut.setBackground(new Color(255, 191, 0));
				btnLogOut.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent e) {
				btnLogOut.setBackground(Color.DARK_GRAY);
				btnLogOut.setForeground(new Color(255, 191, 0));
			}
		});
		
		btnLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				 try {
					btnLogOut_OnClicked_Action_Performed();
				 } catch (IOException e) {
					e.printStackTrace();
				 }
			}
		});
	  }
	
    private void btnHome_OnClick_Action_Performed() {
    	
    	maincontentPane.removeAll();
    	maincontentPane.add(new HomePane());
    	maincontentPane.repaint();
    	maincontentPane.revalidate();
    	
    }
    
    public void btnAddLibrarian_OnClick_Action_Performed() {
 	     maincontentPane.removeAll();
 	     maincontentPane.add(new AddLibrarianPane());
 	     maincontentPane.repaint();
 	     maincontentPane.revalidate();
    }
    	
    private void btnView_OnClick_Action_Performed() {
    	 maincontentPane.removeAll();
 	     maincontentPane.add(new LibrarianInfoPane());
 	     maincontentPane.repaint();
 	     maincontentPane.revalidate();
    }
    private void btnLogOut_OnClicked_Action_Performed() throws IOException {
    	dispose();
    	new AdminLogin();
	}
    
   
}