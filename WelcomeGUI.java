import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WelcomeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tableTextField;
	private JTextField dinersTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeGUI frame = new WelcomeGUI();
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
	public WelcomeGUI() {
		setTitle("Restaurant Menu Selector");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToPrideOfBarbados = new JLabel("Welcome to Pride of Barbados");
		lblWelcomeToPrideOfBarbados.setFont(new Font("Castellar", Font.ITALIC, 17));
		lblWelcomeToPrideOfBarbados.setBounds(69, 11, 339, 49);
		contentPane.add(lblWelcomeToPrideOfBarbados);
		
		JLabel lblTableNumber = new JLabel("Table Number");
		lblTableNumber.setFont(new Font("Chiller", Font.ITALIC, 17));
		lblTableNumber.setBounds(205, 71, 78, 35);
		contentPane.add(lblTableNumber);
		
		tableTextField = new JTextField();
		String textVariable = tableTextField.getText();
		tableTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		tableTextField.setBounds(197, 102, 86, 20);
		contentPane.add(tableTextField);
		tableTextField.setColumns(10);
		
		JLabel lblNunberOfDiners = new JLabel("Number of Diners");
		lblNunberOfDiners.setFont(new Font("Chiller", Font.ITALIC, 17));
		lblNunberOfDiners.setBounds(193, 158, 102, 14);
		contentPane.add(lblNunberOfDiners);
		
		dinersTextField = new JTextField();
		dinersTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		dinersTextField.setBounds(197, 183, 86, 20);
		contentPane.add(dinersTextField);
		dinersTextField.setColumns(10);
		
		JButton buttonNext = new JButton("Feed Me");
		buttonNext.setBackground(Color.WHITE);
		buttonNext.addActionListener(new ActionListener() {
			int foo = Integer.parseInt(tableTextField.getText());
			public void actionPerformed(ActionEvent arg0) {
				MenuGUI instance = new MenuGUI();
				instance.setVisible(true);
				dispose();
			}
		});
		buttonNext.setBounds(193, 248, 89, 23);
		contentPane.add(buttonNext);
	}
}
