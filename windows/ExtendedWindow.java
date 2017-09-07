package windows;

public class ExtendedWindow extends BasicWindow {

	public static final int MAX_X = 1200;
	public static final int MAX_Y = 1080;
	
	protected String title; 
	
	public ExtendedWindow(int x, int y, int w, int h, String title) {
		super(x, y, w, h);
		this.title = title;
	}

	public ExtendedWindow(String title) {
//		super();  // Por omisión de super, el compilador añade super();
		this.title = title;
	}
	
	@Override
//	La anotación @Override induce un error de sintaxis si no se sobreescribe un método
	public void display() {
		System.out.printf("Title: %s\n", this.title);
		super.display();
	}
	
	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
		
		if(super.x < 0) super.x = 0;
		else if(super.x > MAX_X) super.x = MAX_X;
		
		if(super.y < 0) super.y = 0;
		else if(super.y > MAX_Y) super.y = MAX_Y;
	}

}
