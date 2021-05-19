import java.awt.Graphics;
import java.awt.Point;

public abstract class Figure {
	protected Point _position;
	protected Point _size;

	public void setPosition(Point p) {
		_position = p;
	}

	public void setSize(Point p) {
		_size = p;
	}
	
	public abstract void Draw(Graphics g);
}
