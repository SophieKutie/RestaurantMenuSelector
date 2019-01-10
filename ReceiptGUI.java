import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReceiptGUI extends JFrame {
private Order order=new Order();
	
	public ReceiptGUI (Order o){
		this();
		this.order=o;
		JScrollPane scroller=new JScrollPane(); 
		JTextPane textPane = new JTextPane();
		contentPane.add(scroller, BorderLayout.CENTER); 
		textPane.setText(order.getDetails(OrderType.RECEIPT));
		scroller.setViewportView(textPane); 
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiptGUI frame = new ReceiptGUI();
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
	public ReceiptGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuGUI instance = new MenuGUI();
						instance.setVisible(true);
						dispose ();
			}
		});
		panel.add(btnMenu);
	}
}
