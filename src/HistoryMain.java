import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class HistoryMain {


	JFrame hFrame;
	public DefaultTableModel model;
	static JTable table1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryMain window = new HistoryMain();
					window.hFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HistoryMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		hFrame = new JFrame();
		hFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/barIcon.png")));
		hFrame.setTitle("Flames Advanced");
		hFrame.setBounds(100, 50, 1000, 700);
		hFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hFrame.getContentPane().setLayout(null);
		hFrame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 204));
		panel.setBounds(0, 0, 986, 663);
		hFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblHistory = new JLabel("HISTORY");
		lblHistory.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblHistory.setBounds(425, 10, 136, 66);
		panel.add(lblHistory);
		

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnDelete.setBounds(332, 587, 136, 45);
		panel.add(btnDelete);
		
		JButton btnHback = new JButton("Back");
		btnHback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				FlameMain window=new FlameMain();
				FlameMain.gameFrame.setVisible(true);
				
			}
		});
		btnHback.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnHback.setBounds(513, 587, 136, 45);
		panel.add(btnHback);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 86, 904, 471);
		panel.add(scrollPane);
		
		table1 = new JTable();
		table1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		model=new DefaultTableModel(); 
		Object[] column={"Person 1","Person 2","Result"};
		model.setColumnIdentifiers(column);
		table1.setModel(model);
		scrollPane.setViewportView(table1);
		
	}
	public static void AddRowToJTable(Object[] dataRow)
    {
        DefaultTableModel model = (DefaultTableModel)table1.getModel();
        model.addRow(dataRow);
    }
}
