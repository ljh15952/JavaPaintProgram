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

	public Point getPosition() {
		return _position;
	}

	public Point getSize() {
		return _size;
	}

	public abstract void Draw(Graphics g);

	public Boolean contains(Point p) {
		if (_position.x <= p.x && _position.y <= p.y && _size.x + _position.x >= p.x && _size.y + _position.y >= p.y) {
			return true;
		}
		return false;
	}
}
