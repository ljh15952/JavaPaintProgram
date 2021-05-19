import java.awt.Graphics;

public class Oval extends Figure{

	@Override
	public void Draw(Graphics g) {
		g.drawOval(_position.x, _position.y, _size.x, _size.y);
	}

}
