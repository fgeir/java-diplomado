import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.iteso.model.Currency;

public class Sesion13 extends JFrame {
	private CurrencyTF subtotal;
	private CurrencyTF IVA;
	private CurrencyTF total;
	
	public Sesion13() {
		setTitle("Using Currency text fields");
		setSize(417, 317);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		initComponents();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
//				Sesion13.this refiere a la instancia de Sesion13 en ejecución
//				this refiere a la instancia de WindowAdapter en ejecución
				int result = JOptionPane.showConfirmDialog(Sesion13.this, 
						                        "¿Está seguro de cerrar?");
				if(result == JOptionPane.YES_OPTION) System.exit(0);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				buttonPressed  = e.getButton();
				mousePosition  = e.getLocationOnScreen();
				windowPosition =   getLocationOnScreen(); 
			}
		});
		
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if(buttonPressed != MouseEvent.BUTTON3) return;
				int incMX = e.getXOnScreen() - (int) mousePosition.getX();
				int incMY = e.getYOnScreen() - (int) mousePosition.getY();
				int winX  = (int) windowPosition.getX() + incMX;
				int winY  = (int) windowPosition.getY() + incMY;
				setLocation(winX, winY);
			}
		});
		
		setVisible(true);
	}
	
	private Point mousePosition  = null;
	private Point windowPosition = null;
	private int   buttonPressed  = 0;
	
	
	private void initComponents() {
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(240, 220, 180));
		
		subtotal = new CurrencyTF();
		subtotal.setValue(1567.67);
		subtotal.setBounds(164, 78, 100, 25);
		getContentPane().add(subtotal);
		
		IVA = new CurrencyTF();
		IVA.setValue(567.893);
		IVA.setCurrency(Currency.Euro);
		subtotal.setNext(IVA);
		IVA.setBounds(164, 114, 100, 25);
		getContentPane().add(IVA);
		
		total = new CurrencyTF();
		total.setCurrency(Currency.Dollar);
		total.setValue(56783.0);
		total.setNext(subtotal);
		IVA.setNext(total);
		total.setBounds(164, 150, 100, 25);
		getContentPane().add(total);
		
		total.setText("hola");
	}

	public static void main(String[] args) {
		new Sesion13();
	}
}
