import java.awt.Graphics;
import java.awt.Point;

public class Line extends Figure {
	@Override
	public void Draw(Graphics g) {
		g.drawLine(_position.x, _position.y, _position.x + _size.x, _position.y + _size.y);
	}
}
