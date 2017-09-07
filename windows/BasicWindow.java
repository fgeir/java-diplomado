package windows;

public class BasicWindow {
	
	public static final int MIN_WIDTH  = 10;
	public static final int MIN_HEIGHT = 15;
	
	protected int x, y;
	protected int width, height;
	
	public BasicWindow(int x, int y, int w, int h) {
		this.x      = x < 0? 0 : x;
		this.y      = y < 0? 0 : y;
		this.width  = w < MIN_WIDTH  ? MIN_WIDTH  : w;
		this.height = h < MIN_HEIGHT ? MIN_HEIGHT : h;  
	}
	
	public BasicWindow() {
		this.x      = 0;
		this.y      = 0;
		this.width  = MIN_WIDTH;
		this.height = MIN_HEIGHT;
	}
	
	public void display() {
		System.out.printf("Location: (%d, %d)\n",  this.x,     this.y);
		System.out.printf("Dimensions: %d x %d\n", this.width, this.height);
	}
	
	public void resize(int dw, int dh) {
		this.width  += dw;
		this.height += dh;
		if(width  < MIN_WIDTH)  this.width  = MIN_WIDTH;
		if(height < MIN_HEIGHT) this.height = MIN_HEIGHT;
	}
	
}
