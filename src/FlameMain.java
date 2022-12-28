import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FlameMain {

	
	static JFrame gameFrame;
	private JTextField textName1;
	private JTextField textName2;
	private String n1 = "";
	private String n2 = "";

	JLabel lblNewLabel;
	JLabel lastResult;
	JLabel lblFinal;
	JLabel lblFinaltip;
	JLabel dOutput;
	JTextField message;
	String soundFile;
	JButton btnSound;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@SuppressWarnings("static-access")
			public void run() {
				try {
					FlameMain window = new FlameMain();
					window.gameFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FlameMain(){
		initialize();
	}
	

	private void initialize() {
		gameFrame = new JFrame();
		gameFrame.setTitle("Flames Advanced");
		gameFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/barIcon.png")));
		gameFrame.setBounds(100, 50, 1000, 700);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.getContentPane().setLayout(null);
		gameFrame.setResizable(false);

		JButton calBtn = new JButton("Calculate");
		calBtn.setBackground(new Color(255, 255, 255));
		calBtn.setForeground(Color.RED);
		calBtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
		calBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flames();   //Main Calculation
				sendHistory();   //History Update
				
			}
		});
		
		JLabel lblSound = new JLabel("");
		lblSound.setIcon(null);
		lblSound.setBounds(922, 10, 41, 35);
		gameFrame.getContentPane().add(lblSound);
		lblSound.setIcon(new ImageIcon(this.getClass().getResource("SOn.png")));

		lblFinaltip = new JLabel("");
		lblFinaltip.setForeground(Color.WHITE);
		lblFinaltip.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblFinaltip.setBounds(228, 506, 684, 44);
		gameFrame.getContentPane().add(lblFinaltip);
		

		lblFinal = new JLabel("");
		lblFinal.setForeground(new Color(255, 255, 255));
		lblFinal.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblFinal.setBounds(228, 435, 684, 44);
		gameFrame.getContentPane().add(lblFinal);

		JButton historyBtn = new JButton("History");
		historyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//gameFrame.dispose();
				HistoryMain f3 = new HistoryMain();
				f3.hFrame.setVisible(true);
				f3.hFrame.setLocationRelativeTo(null);
				f3.hFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				HistoryMain.AddRowToJTable(new Object[]{
						textName1.getText(),
						textName2.getText(),
			            lblFinal.getText(),
			           
			        
			        });
			}
		});
		historyBtn.setForeground(Color.RED);
		historyBtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
		historyBtn.setBackground(Color.WHITE);
		historyBtn.setBounds(713, 583, 199, 50);
		gameFrame.getContentPane().add(historyBtn);

		JButton clearBtn = new JButton("Clear");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();

				
			}
		});
		clearBtn.setForeground(Color.RED);
		clearBtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
		clearBtn.setBackground(Color.WHITE);
		clearBtn.setBounds(418, 583, 199, 50);
		gameFrame.getContentPane().add(clearBtn);

		JButton dwBtn = new JButton("Download");
		dwBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//gameFrame.dispose();
				try {
					DownloadPg frm2 = new DownloadPg();
					frm2.lblname1.setText(textName1.getText().toUpperCase());
					frm2.lblname2.setText(textName2.getText().toUpperCase());
					frm2.lblOutput.setIcon(dOutput.getIcon());
					frm2.dFrame.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Please Enter Inputs");
				}
			}
		});
		dwBtn.setForeground(Color.RED);
		dwBtn.setFont(new Font("Segoe UI", Font.BOLD, 25));
		dwBtn.setBackground(Color.WHITE);
		dwBtn.setBounds(143, 583, 199, 50);
		gameFrame.getContentPane().add(dwBtn);

		JLabel lblTip = new JLabel("Tip      :");
		lblTip.setForeground(Color.WHITE);
		lblTip.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTip.setBounds(104, 512, 298, 30);
		gameFrame.getContentPane().add(lblTip);

		JLabel lblResult = new JLabel("Result :");
		lblResult.setForeground(Color.WHITE);
		lblResult.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblResult.setBounds(104, 445, 151, 30);
		gameFrame.getContentPane().add(lblResult);
		calBtn.setBounds(418, 343, 199, 50);
		gameFrame.getContentPane().add(calBtn);

		textName2 = new JTextField();
		textName2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textName2.setColumns(10);
		textName2.setBounds(378, 258, 448, 35);
		gameFrame.getContentPane().add(textName2);

		textName1 = new JTextField();
		textName1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textName1.setBounds(378, 188, 448, 35);
		gameFrame.getContentPane().add(textName1);
		textName1.setColumns(10);

		JLabel name2 = new JLabel("Person 2 First name :");
		name2.setForeground(Color.WHITE);
		name2.setFont(new Font("Segoe UI", Font.BOLD, 24));
		name2.setBounds(104, 263, 298, 30);
		gameFrame.getContentPane().add(name2);

		JLabel name1 = new JLabel("Person 1 First name :");
		name1.setForeground(new Color(255, 255, 255));
		name1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		name1.setBounds(104, 188, 298, 30);
		gameFrame.getContentPane().add(name1);

		JLabel heart02 = new JLabel("");
		heart02.setHorizontalAlignment(SwingConstants.CENTER);
		heart02.setBounds(628, 28, 169, 125);
		gameFrame.getContentPane().add(heart02);
		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon(this.getClass().getResource("/heart2.gif")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		heart02.setIcon(imageIcon1);

		JLabel heart01 = new JLabel("");
		heart01.setHorizontalAlignment(SwingConstants.CENTER);
		heart01.setBounds(173, 28, 169, 125);
		gameFrame.getContentPane().add(heart01);
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(this.getClass().getResource("/heart1.gif")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		heart01.setIcon(imageIcon2);

		JLabel mTitle2 = new JLabel("ADVANCED");
		mTitle2.setForeground(new Color(255, 255, 255));
		mTitle2.setBackground(new Color(255, 255, 255));
		mTitle2.setFont(new Font("Impact", Font.PLAIN, 30));
		mTitle2.setBounds(418, 93, 141, 50);
		gameFrame.getContentPane().add(mTitle2);

		JLabel mTitle = new JLabel("Flames");
		mTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mTitle.setForeground(new Color(255, 0, 153));
		mTitle.setFont(new Font("a Alloy Ink", Font.PLAIN, 60));
		mTitle.setBounds(299, 28, 344, 99);
		gameFrame.getContentPane().add(mTitle);

		JLabel mainBg = new JLabel("New label");
		mainBg.setIcon(new ImageIcon(this.getClass().getResource("Mbg1.jpg")));
		mainBg.setBounds(0, 0, 1004, 682);
		gameFrame.getContentPane().add(mainBg);
	}

	private void flames() {  //Main Calculation

		JTextField message = new JTextField();
		JTextField tip = new JTextField();
		dOutput = new JLabel();

		while ((!textName1.getText().matches("[a-zA-Z]+")) || (!textName2.getText().matches("[a-zA-Z]+"))) {
			JOptionPane.showMessageDialog(null, "Please Enter Valid Inputs");
			n1 = textName1.getText();
			n2 = textName2.getText();
			return;
		}
		n1 = textName1.getText().toString().toLowerCase();   //.trim() no need to use
		n2 = textName2.getText().toString().toLowerCase();

		StringBuilder sb1 = new StringBuilder(n1);// converting to string builder
		StringBuilder sb2 = new StringBuilder(n2);

		int x = sb1.length();
		int y = sb2.length();

		for (int i = 0; i < x; i++) {

			for (int j = 0; j < y; j++) {

				if (sb1.charAt(i) == sb2.charAt(j)) {
					sb1.replace(i, i + 1, "0"); // replacing matching characters into "0"
					sb2.replace(j, j + 1, "0");
				}
			}
		}

		int x1 = 0;
		int x2 = 0;

		for (int i = 0; i < sb1.length(); i++) { // length of string to remove 0 and find the length
			if (sb1.charAt(i) != '0') {

				x1 += 1;
			}
		}

		for (int j = 0; j < sb2.length(); j++) { // length of string to remove 0 and find the length
			if (sb2.charAt(j) != '0') {

				x2 += 1;
			}
		}

		int t = x1 + x2;

		String game = "flames";
		StringBuilder sb3 = new StringBuilder(game);

		char result = 0;

		while (sb3.length() != 1) {
			int k = t % sb3.length();
			;
			String remaining;

			if (k != 0) {
				remaining = sb3.substring(k) + sb3.substring(0, k - 1);    //remove k index value of flames & print remaining string
			}

			else {
				remaining = sb3.substring(0, sb3.length() - 1);

			}

			sb3 = new StringBuilder(remaining);
			result = sb3.charAt(0);

		}

		String f1 = "The best relationship start off as friendship first";
		String f2 = "Friendship is the purest love";

		String a1 = "Love is strong in its passion, Affection is powerful in its gentleness";
		String a2 = "Affection never will waste";

		String e1 = "Enemies make the best lovers";
		String e2 = "You know,People can be lovers & enemies at the same time";

		switch (result) {
		case 'f':
			message.setText("Friends");
			dOutput.setIcon(new ImageIcon(this.getClass().getResource("/friends.png")));
			String[] f0 = { f1, f2 };
			int randIdx1 = ThreadLocalRandom.current().nextInt(f0.length);
			String randomElem1 = f0[randIdx1];
			tip.setText(randomElem1);
			try {
				playMusic("/friends.wav");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 'l':
			message.setText("Love");
			dOutput.setIcon(new ImageIcon(this.getClass().getResource("/lover.png")));
			tip.setText("Congratulations!!!");
			try {
				playMusic("/love.wav");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 'a':
			message.setText("Affection");
			dOutput.setIcon(new ImageIcon(this.getClass().getResource("/affection.png")));
			String[] a0 = { a1, a2 };
			int randIdx2 = ThreadLocalRandom.current().nextInt(a0.length);
			String randomElem2 = a0[randIdx2];
			tip.setText(randomElem2);
			try {
				playMusic("/affection.wav");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 'm':
			message.setText("Marriage");
			dOutput.setIcon(new ImageIcon(this.getClass().getResource("/marriage.png")));
			tip.setText("Congratulations!!!");
			try {
				playMusic("/marry.wav");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case 'e':
			message.setText("Enemies");
			dOutput.setIcon(new ImageIcon(this.getClass().getResource("/enemy.png")));
			String[] e0 = { e1, e2 };
			int randIdx3 = ThreadLocalRandom.current().nextInt(e0.length);
			String randomElem3 = e0[randIdx3];
			tip.setText(randomElem3);
			try {
				playMusic("/enemy.wav");
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case 's':
			message.setText("Soulmate");
			dOutput.setIcon(new ImageIcon(this.getClass().getResource("/soulmate.png")));
			tip.setText("Lucky you, You enter the exactly right person's name");
			try {
				playMusic("/soulmate.wav");
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		}

		lblFinal.setText(message.getText());
		lblFinaltip.setText(tip.getText());

	}
	
	private void sendHistory() {
		HistoryMain frm3 = new HistoryMain();
		//frm3.hFrame.setVisible(true);
		
		String data[]= {textName1.getText(),textName2.getText(),lblFinal.getText()};
		frm3.model.addRow(data); 
	}
	
	public void sendDownload() {
		try {
			DownloadPg frm2 = new DownloadPg();
			frm2.lblname1.setText(textName1.getText().toUpperCase());
			frm2.lblname2.setText(textName2.getText().toUpperCase());
			frm2.lblOutput.setIcon(dOutput.getIcon());
			frm2.dFrame.setVisible(true);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Please Enter Inputs");
		}
	}
	
	public void playMusic(String soundFile) throws Exception {
		
		
		JButton btnSound = new JButton("");   //Visible Sound Off Button
		btnSound.setIcon(new ImageIcon((this.getClass().getResource("/SOff.png"))));
		btnSound.setBounds(922, 10, 41, 35);
		gameFrame.getContentPane().add(btnSound);
		
		File f=new File("Assets/"+soundFile);  //Audio
		AudioInputStream audio1=AudioSystem.getAudioInputStream(f.getAbsoluteFile());
		Clip clip1=AudioSystem.getClip();
		clip1.open(audio1);
		clip1.loop(Clip.LOOP_CONTINUOUSLY);
		clip1.start();
		
		btnSound.addActionListener(new ActionListener() {   //Sound Off Action
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Press Ok to stop music");
				clip1.stop();
				btnSound.setVisible(false);
				
			}
		});

	}
	
	public void clear() {
		textName1.setText("");
		textName2.setText("");
		lblFinal.setText("");
		lblFinaltip.setText("");
	}
}
