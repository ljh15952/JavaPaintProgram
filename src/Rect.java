import java.awt.Graphics;

public class Rect extends Figure {

	public void Draw(Graphics g) {
		g.drawRect(_position.x, _position.y, _size.x, _size.y);
	}

}
