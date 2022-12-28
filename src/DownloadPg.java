import java.awt.EventQueue;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DownloadPg {

	JFrame dFrame;
	public JLabel lblname1;
	public JLabel lblname2;
	public JLabel lblOutput;
	public JButton captureBtn;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DownloadPg window = new DownloadPg();
					window.dFrame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the application.
	 */
	public DownloadPg() {
		initialize();
	
//		lblname1.setText(textName1.getText());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dFrame = new JFrame();
		dFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/barIcon.png")));
		dFrame.setTitle("Flames Advanced");
		dFrame.getContentPane().setBackground(new Color(0, 0, 102));
		dFrame.setBackground(new Color(0, 51, 102));
		dFrame.setBounds(100, 50, 1000, 700);
		dFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dFrame.getContentPane().setLayout(null);
		dFrame.setResizable(false);
		
		JButton captureBtn = new JButton("Download");
		captureBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			    captureBtn.setVisible(false); 
				capture();
				
				
			}
		});
		captureBtn.setBounds(427, 632, 132, 21);
		dFrame.getContentPane().add(captureBtn);
		
		lblOutput = new JLabel("");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(355, 243, 273, 262);
		dFrame.getContentPane().add(lblOutput);
		
		lblname2 = new JLabel("");
		lblname2.setForeground(new Color(255, 255, 255));
		lblname2.setHorizontalAlignment(SwingConstants.CENTER);
		lblname2.setFont(new Font("Roboto Black", Font.PLAIN, 25));
		lblname2.setBounds(655, 350, 303, 49);
		dFrame.getContentPane().add(lblname2);
		
		lblname1 = new JLabel("");
		lblname1.setForeground(new Color(255, 255, 255));
		lblname1.setHorizontalAlignment(SwingConstants.CENTER);
		lblname1.setFont(new Font("Roboto Black", Font.PLAIN, 25));
		lblname1.setBounds(33, 350, 303, 49);
		dFrame.getContentPane().add(lblname1);
		
		JLabel dHeart2 = new JLabel("");
		dHeart2.setHorizontalAlignment(SwingConstants.CENTER);
		dHeart2.setBounds(737, 185, 139, 159);
		dFrame.getContentPane().add(dHeart2);
		ImageIcon imageIconD1 = new ImageIcon(new ImageIcon(this.getClass().getResource("/dHeart.png")).getImage().getScaledInstance(150, 170, Image.SCALE_DEFAULT));
		dHeart2.setIcon(imageIconD1);
		
		JLabel dHeart1 = new JLabel("");
		dHeart1.setHorizontalAlignment(SwingConstants.CENTER);
		dHeart1.setBounds(108, 185, 139, 159);
		dFrame.getContentPane().add(dHeart1);
		ImageIcon imageIconD2 = new ImageIcon(new ImageIcon(this.getClass().getResource("/dHeart.png")).getImage().getScaledInstance(150, 170, Image.SCALE_DEFAULT));
		dHeart1.setIcon(imageIconD2);
		
		JLabel downBg = new JLabel();
		downBg.setForeground(new Color(255, 255, 255));
		downBg.setIcon(new ImageIcon(this.getClass().getResource("back.png")));
		downBg.setBounds(0, 0, 1022, 682);
		dFrame.getContentPane().add(downBg);
	}
	
	
	public void capture() {          //screenshot
		
		JFileChooser file = new JFileChooser();
		file.setDialogTitle("Select Path to save");
		file.setMultiSelectionEnabled(true);
	    file.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    file.setFileHidingEnabled(false);
	    int r = file.showSaveDialog(null);
		if (r == JFileChooser.APPROVE_OPTION) {
			@SuppressWarnings("unused")
			File f = file.getSelectedFile();
			try {
				Robot robot1=new Robot();
				Rectangle re1=new Rectangle(dFrame.getX(),dFrame.getY(),dFrame.getWidth(),dFrame.getHeight());
				
				BufferedImage screenshot=robot1.createScreenCapture(re1);
				
				ImageIO.write(screenshot, "png",
				
						new File(file.getSelectedFile().getAbsolutePath()+"\\Flames"+getDifferent()+".png"));
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Saved in "+file.getSelectedFile().getAbsolutePath());
		}
		
		
	}
	
	public String getDifferent()   //get different name for screenshot
	   {
	      String time1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	      return time1;
	   }
	
	
	
}
