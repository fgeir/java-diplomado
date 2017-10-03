import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JComponent;
import javax.swing.JTextField;

import com.iteso.model.Currency;

public class CurrencyTF extends JTextField {
	
	private JComponent    next      = null;
	private double        value     = 0;
	private Currency      currency  = Currency.Peso; 
	private DecimalFormat formatter = new DecimalFormat("$#,##0.00");
	
	public CurrencyTF() {
		setText("$0.00");
		setHorizontalAlignment(CENTER);
		setPreferredSize(new Dimension(100, 25));
		setBorder(null);
		
//		KeyAdapter es una clase que implementó a la interfaz KeyListener
//		dejando los tres métodos vacíos (keyPressed, keyReleased, keyTyped).
//		En este esquema, sobreescribimos el método keyPressed de KeyAdapter
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() != KeyEvent.VK_ENTER) return;
				if(next != null) next.requestFocus();
			}
		});
		
		addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				String text = getText();
				try {
					value = Double.parseDouble(text);
				} catch(Exception ex) {}
//				value =  12345.678
//				text  = "$12,345.68"
				updateText();
			}
			public void focusGained(FocusEvent e) {
				displayValue();
			}
		});
	}
	
	private void updateText() {
		super.setText(formatter.format(value));
	}
	
	private void displayValue() {
		super.setText("" + value);
		selectAll();
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
		updateText();
	}

	public JComponent getNext() {
		return next;
	}

	public void setNext(JComponent next) {
		this.next = next;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
		switch(this.currency) {
			case Dollar : this.formatter.applyPattern("US $#,##0.00"); 
			              break;
			case Euro   : this.formatter.applyPattern("#,##0.00 €"); 
            			  break;
			case Peso   : this.formatter.applyPattern("$#,##0.00");
		}
		updateText();
	}
	
	@Override
	public void setText(String text) {
	}
	
	private static final Color GREEN = new Color(100, 220, 180, 90);
	private static final Color   RED = new Color(220, 100, 140, 90);
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int w = getWidth();
		int h = getHeight();
		g.setColor(GREEN);
		g.fillRect(0,     h / 4, w, h / 4);
		g.setColor(RED);
		g.fillRect(0, 3 * h / 4, w, h / 4);
	}
	
	
}
