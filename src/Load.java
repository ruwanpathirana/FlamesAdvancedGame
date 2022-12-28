import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

public class Load extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JProgressBar progressBar;
	private static JLabel percentage;
	private static JLabel loadingText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			playIntro("/intro.wav");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		splash();
	
	
	}

	public Load() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bg = new JLabel("");
		ImageIcon icon1=new ImageIcon(this.getClass().getResource(("/bg.png")));
		
		JLabel lblNewLabel = new JLabel("Created By s14934");
		lblNewLabel.setFont(new Font("Segoe UI", Font.ITALIC, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(367, 224, 189, 29);
		contentPane.add(lblNewLabel);
		
		JLabel gifHeart = new JLabel("");
		gifHeart.setBounds(296, 304, 294, 201);
		contentPane.add(gifHeart);
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon(this.getClass().getResource("/test1.gif")).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
		gifHeart.setIcon(imageIcon2);
		
		loadingText = new JLabel("Loading...");
		loadingText.setForeground(Color.WHITE);
		loadingText.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		loadingText.setBounds(10, 533, 286, 22);
		contentPane.add(loadingText);
		
		percentage = new JLabel("0%");
		percentage.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		percentage.setForeground(Color.WHITE);
		percentage.setBounds(847, 533, 53, 22);
		contentPane.add(percentage);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 0, 128));
		progressBar.setBounds(10, 565, 880, 11);
		contentPane.add(progressBar);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon3 = new ImageIcon(new ImageIcon(this.getClass().getResource("/logo.png")).getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT));
		logo.setIcon(imageIcon3);
		logo.setBounds(128, 31, 654, 263);
		contentPane.add(logo);
		bg.setIcon(icon1);
		bg.setBounds(-18, -39, 938, 639);
		contentPane.add(bg);
	}
	
	//Splash Screen
	@SuppressWarnings("static-access")
	public static void splash() {
        int x;
		
		Load frame = new Load();
		frame.setVisible(true);
		
		try {
			
			
			for(x=0;x<=100;x++) {
				Load.progressBar.setValue(x);
				Thread.sleep(50);
				Load.percentage.setText(Integer.toString(x)+" %");
				
				if(x==10) {
					Load.loadingText.setText("Turning On Module...");
	    		}
	    		if(x==30) {
	    			Load.loadingText.setText("Loading Module...");
	    		}
	    		if(x==50) {
	    			Load.loadingText.setText("Connecting to Database...");
	    		}
	    		if(x==80) {
	    			Load.loadingText.setText("Launching Application...");
	    		}
	    		if(x==100) {
	    			frame.dispose();
	    			FlameMain m1 = new FlameMain();
					m1.gameFrame.setVisible(true);
					
	    			
	    		}
			}
		}
		catch(InterruptedException e){
			e.printStackTrace();	
		}
	}
	
	
	//Music
	
    public static void playIntro(String soundFile) throws Exception {
		
		File f=new File("Assets/"+soundFile);
		AudioInputStream audio1=AudioSystem.getAudioInputStream(f.getAbsoluteFile());
		Clip clip1=AudioSystem.getClip();
		clip1.open(audio1);
		clip1.start();
	
	}
}
