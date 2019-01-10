import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Color;

public class DrinksList extends JFrame {
	
	   private Order order = new Order();
       
       public DrinksList(Order o){
       	this();
       	this.order=o;
       }

	private JPanel contentPane;
	private final Label label = new Label("Please make your selection");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrinksList frame = new DrinksList();
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
	public DrinksList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		label.setBackground(Color.ORANGE);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		//scrollpane.setPreferredSize (100,150);
		panel_1.add(scrollPane);
		
		final JList list = new JList();
		list.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
			}
		});
	

		     String[] listOfButties = new String[Menu.DRINKS.length]; //{"Orange and Passion Fruit", "Apple and Raspberry", "Ocean Spray", "Peach flavored ice tea", "Apple Juice", "Mango Juice", "Orange Juice", "Coke", "Pepsi", "Fanta", "Sprite"};
		     Menu.getMeals(MealType.DRINKS).toArray(listOfButties);
		     list.setListData(listOfButties);
		scrollPane.setViewportView(list);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnRemove = new JButton("Remove");
		panel_2.add(btnRemove);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.getTable().setMeal(MealType.DRINKS, list.getSelectedIndices());
				MenuGUI instance = new MenuGUI(order);
				instance.setVisible(true);
				dispose();
			}
		});
		panel_2.add(btnDone);
	}

}
