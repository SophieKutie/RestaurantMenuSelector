import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StarterList extends JFrame {

	private Order order=new Order();
	
	public StarterList(Order o){
		this();
		this.order=o;
	}
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarterList frame = new StarterList();
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
	public StarterList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setForeground(new Color(255, 200, 0));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblPleaseMakeYour = new JLabel("Please make your selection");
		panel.add(lblPleaseMakeYour);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		final JList list = new JList();
		JButton btnPlaceOrder = new JButton("Add");
		btnPlaceOrder.setBackground(Color.ORANGE);
		btnPlaceOrder.addMouseListener(new MouseAdapter() {
		
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnPlaceOrder);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.ORANGE);
		btnRemove.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_1.add(btnRemove);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.getTable().setMeal(MealType.STARTER, list.getSelectedIndices());
				MenuGUI instance = new MenuGUI(order);
				instance.setVisible(true);
				dispose();
			}
		});
		btnDone.setBackground(Color.ORANGE);
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_1.add(btnDone);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setForeground(Color.WHITE);
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
	//	scrollPane.setPreferredSize(100, 150);
		panel_2.add(scrollPane);
		
	     String[] listOfButties = new String[Menu.STARTERS.length];//{"Beef Pops with Pineapple and Parsley Sauce", "Pizza Skewers", "Cheese and bacon Pinwheels" ,"Quick Herb and Cheese Monkey Bread",
	//   "Heston's BBQ Chicken Wings", "Scotch quail eggs", "Crispy Turnip Cake with Chilli Sauce", "Potage of vegetables with poached duck egg and fresh herbs","Chocolate Flapjack Cakes", "Parmesan Potato Pancake","Chilled avocado soup with tortilla chips", "Sweet and Sour Couscous-Stuffed Peppers"};
	     Menu.getMeals(MealType.STARTER).toArray(listOfButties);
		 list.setListData(listOfButties);
		
		scrollPane.setViewportView(list);
	}

}
