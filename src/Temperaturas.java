
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Temperaturas extends JFrame {
	
	private JTextField txtCelsius = new JTextField("0.0");
	private JTextField txtFahrenh = new JTextField("32.0");
	private JLabel  lblCelsius    = new JLabel("Grados Celsius:");
	private JLabel  lblFahrenh    = new JLabel("Grados Fahrenheit:");
	private JButton btnFahrenh;
	private JButton btnCelsius;
	private JLabel  lblImage      = new JLabel("");
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			System.out.println(cmd);
			if(cmd.equals("Celsius")) toCelsius();
			else toFahrenheit();
		}
	}
	
	public Temperaturas() {
		super("Convertidor de temperaturas");
//		setTitle("Convertidor de temperaturas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(349, 523);
		setLocationRelativeTo(null);
		setResizable(false);
		initComponents();		
		setVisible(true);
	}
	
	private void initComponents() {
		Container c = getContentPane();
		Color windowColor = new Color(170, 190, 210);
		c.setBackground(windowColor);
		c.setLayout(null);
		lblCelsius.setForeground(new Color(255, 255, 255));
		lblCelsius.setOpaque(true);
		lblCelsius.setBackground(new Color(128, 0, 128));
		lblCelsius.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblCelsius.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCelsius.setBounds(50, 40, 130, 25);
		
		lblFahrenh.setForeground(new Color(255, 255, 255));
		lblFahrenh.setOpaque(true);
		lblFahrenh.setBackground(new Color(128, 0, 128));
		lblFahrenh.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblFahrenh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFahrenh.setBounds(50, 80, 130, 25);
		
		txtCelsius.setBackground(new Color(152, 251, 152));		
		txtCelsius.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtCelsius.setHorizontalAlignment(SwingConstants.CENTER);
		txtCelsius.setBounds(196, 40, 100, 25);
		
		txtFahrenh.setBackground(new Color(152, 251, 152));
		txtFahrenh.setFont(new Font("Consolas", Font.PLAIN, 14));
		txtFahrenh.setHorizontalAlignment(SwingConstants.CENTER);
		txtFahrenh.setBounds(196, 80, 100, 25);
				
		btnCelsius = new JButton("A Celsius");
		btnCelsius.setMnemonic('C');
		btnCelsius.setToolTipText("Convierte los grados Fahrenheit a Celsius");
		btnCelsius.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCelsius.setBackground(Color.ORANGE);
		btnCelsius.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnCelsius.setBounds(50, 140, 120, 40);
		btnCelsius.setActionCommand("Celsius");
		
		btnFahrenh = new JButton("A Fahrenheit");
		btnFahrenh.setMnemonic('F');
		btnFahrenh.setToolTipText("Convierte los grados Celsius a Fahrenheit");
		btnFahrenh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFahrenh.setBackground(Color.PINK);
		btnFahrenh.setFont(new Font("Calibri", Font.PLAIN, 15));
		btnFahrenh.setBounds(176, 140, 120, 40);
		btnFahrenh.setActionCommand("Fahrenheit");
		
//		ButtonListener chismoso1 = new ButtonListener();
//		btnCelsius.addActionListener(chismoso1);
//		btnFahrenh.addActionListener(chismoso1);
		
//		Esquema con clases anónimas
//		ActionListener chismoso2 = new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String cmd = e.getActionCommand();
//				System.out.println(cmd);
//				if(cmd.equals("Celsius")) toCelsius();
//				else toFahrenheit();				
//			}
//		};
//		btnCelsius.addActionListener(chismoso2);
//		btnFahrenh.addActionListener(chismoso2);
		
//		Esquema con clases y objetos anónimos: un chismoso por botón
		btnCelsius.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toCelsius();				
			}
		});
		
		btnFahrenh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toFahrenheit();
			}
		});
		
		lblImage.setIcon(new ImageIcon(Temperaturas.class.getResource("/images/termometro2.png")));
		lblImage.setBounds(50, 208, 256, 256);

		btnCelsius.setFocusable(false);
		btnFahrenh.setFocusable(false);
		
		c.add(lblCelsius);
		c.add(lblFahrenh);
		c.add(txtCelsius);
		c.add(txtFahrenh);
		c.add(btnCelsius);		
		c.add(btnFahrenh);
		c.add(lblImage);
	}
	
	private double f = 32.0, c = 0.0;
	
	private void toCelsius() {
		String sf = txtFahrenh.getText();
		try {
			f = Double.parseDouble(sf);
		} catch(Exception ex) {
			sf = String.format("%.1f", f);
			txtFahrenh.setText(sf);
		}
		double  c = (f - 32) / 1.8;
		String sc = String.format("%.1f", c);
		txtCelsius.setText(sc);
	}
	
	private void toFahrenheit() {
		String sc = txtCelsius.getText();
		try {
			c = Double.parseDouble(sc);
		} catch(Exception ex) {
			sc = String.format("%.1f", c);
			txtCelsius.setText(sc);
		}
		double  f = c * 1.8 + 32;
		String sf = String.format("%.1f", f);
		txtFahrenh.setText(sf);
	}

	public static void main(String[] args) {
		new Temperaturas();
//		Temperaturas t1 = new Temperaturas();
//		Temperaturas t2 = new Temperaturas();		
//		JFrame ventana1 = new JFrame("Convertidor de temperaturas");
//		ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		ventana1.setSize(600, 500);
//		ventana1.setLocationRelativeTo(null);
//		ventana1.setResizable(false);
//		ventana1.setVisible(true);
//		
//		JFrame ventana2 = new JFrame("Convertidor de temperaturas");
//		ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		ventana2.setSize(600, 500);
//		ventana2.setVisible(true);
		
//		System.out.println("¿Se acabó el método main?");
		
	}
}
