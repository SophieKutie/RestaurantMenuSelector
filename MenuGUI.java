import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuGUI extends JFrame {
	
	private Order order;
	private JPanel contentPane;

	public MenuGUI(Order o){
		this();
		this.order=o;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI frame = new MenuGUI();
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
	public MenuGUI() {
		setTitle("Menu items");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStarter = new JButton("Starter");
		btnStarter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StarterList instance = new StarterList (order);
				instance.setVisible(true);
				dispose();
				
			}
		});
		btnStarter.setBounds(58, 21, 147, 89);
		contentPane.add(btnStarter);
		
		JButton btnMain = new JButton("Main");
		btnMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainList instance = new MainList(order);
				instance.setVisible(true);
				dispose();
			}
		});
		btnMain.setBounds(244, 21, 147, 89);
		contentPane.add(btnMain);
		
		JButton btnDessert = new JButton("Dessert");
		btnDessert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnDessert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DessertList instance = new DessertList(order);
				instance.setVisible(true);
				dispose();
			}
		});
		btnDessert.setBounds(58, 157, 147, 89);
		contentPane.add(btnDessert);
		
		JButton btnDrinks = new JButton("Drinks");
		btnDrinks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrinksList instance = new DrinksList(order);
				instance.setVisible(true);
				dispose();
			}
		});
		btnDrinks.setBounds(244, 157, 147, 89);
		contentPane.add(btnDrinks);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderGUI instance = new OrderGUI(order);
				instance.setVisible(true);
				dispose();

			}
		});
		btnNext.setBounds(270, 302, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				WelcomeGUI instance = new WelcomeGUI();
				instance.setVisible(true);
				dispose();

			}
		});
		btnReturn.setBounds(101, 302, 89, 23);
		contentPane.add(btnReturn);
	}
}
