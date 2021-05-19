import java.awt.Graphics;

public class Group extends Figure{

	@Override
	public void Draw(Graphics g) {
		g.drawRect(_position.x, _position.y, _size.x, _size.y);
	}
	
}
