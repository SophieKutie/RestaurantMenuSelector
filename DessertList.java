import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.Color;

public class DessertList extends JFrame {
	
	   private Order order = new Order();
       
       public DessertList(Order o){
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
					DessertList frame = new DessertList();
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
	public DessertList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.NORTH);
		
		Label label = new Label("Please make your selection");
		label.setBackground(Color.ORANGE);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.ORANGE);
		panel_1.add(btnRemove);
		
		final JList list = new JList();
		
		JButton btnDone = new JButton("Done");
		btnDone.setBackground(Color.ORANGE);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.getTable().setMeal(MealType.DESSERT, list.getSelectedIndices());
				MenuGUI instance = new MenuGUI(order);
				instance.setVisible(true);
				dispose();
			}
		});
		btnDone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		panel_1.add(btnDone);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel_2, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane);
		
		
		list.setBackground(Color.LIGHT_GRAY);
		list.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
			}
		});
	

		     String[] listOfButties = new String [Menu.DESSERTS.length]; //{"Bitter sweet Chocolate Cheese Pie", "Croissant Bread Pudding", "Banana berries Foster", "Pineapple Cheesecake", "Nutella hazelnut spread and banana mini calzones",
//"Blood orange polenta cake","Milk chocolate fudge cake","Sticky toffee pudding","Served with hot butterscotch sauce and vanilla ice cream", "Honeycomb Smash Cheesecake"};
		     Menu.getMeals(MealType.DESSERT).toArray(listOfButties);     
		     list.setListData(listOfButties);
		scrollPane.setViewportView(list);
	}

}
