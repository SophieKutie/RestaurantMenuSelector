import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainList extends JFrame {
	
        private Order order = new Order();
        
        public MainList(Order o){
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
					MainList frame = new MainList();
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
	public MainList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		Label label = new Label("Please make your selection");
		label.setBackground(Color.ORANGE);
		panel_2.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.ORANGE);
		panel_1.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBackground(Color.ORANGE);
		panel_1.add(btnRemove);
		
		final JList list = new JList();
		
		JButton btnDone = new JButton("Done");
		btnDone.setBackground(Color.ORANGE);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.getTable().setMeal(MealType.MAIN, list.getSelectedIndices());
				MenuGUI instance = new MenuGUI(order);
				instance.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnDone);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
        //scrollPane.setPreferredSize(100, 150);
		panel_3.add(scrollPane);
		
		
		list.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
			}
		});
	

		     String[] listOfButties = new String[Menu.MAINS.length]; //{"Marsala Marinated Skirt Steak", "Orange and Milk-Braised Pork Carnitas", "Chicken and Pasta Casserole with Mixed Vegetable","Boneless Pork Chop with Shallot Mustard Sauce", "Pulled Pork Burritos", "Shrimp scampi with pasta", 
                    //"Chicken Marsala","Caprese Salad with Grilled Flank Steak", "Italian Hot Turkey Sausage and Black-Eyed Peas", "Swordfish a la Siciliana", "Linguine with Seafood and Sundried Tomatoes", "Pasta with Tuna, Sun-Dried Tomatoes, Artichoke Hearts, Lemon, and White Wine"};
		     Menu.getMeals(MealType.MAIN).toArray(listOfButties);
		     list.setListData(listOfButties);
		

		scrollPane.setViewportView(list);
	}

}
