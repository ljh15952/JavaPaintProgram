import java.awt.Point;

public class MoveState implements StatePattern {
	private MyFrame _frame;

	public MoveState(MyFrame f) {
		_frame = f;
	}

	private Figure getClickedFigure(Point p) {
		Figure temp = null;
		for (Figure it : _frame.getFigureList()) {
			if (it.contains(p)) {
				temp = it;
			}
		}
		return temp;
	}

	@Override
	public void do_something(Point p1, Point p2) {
		Figure _clickedFigure = getClickedFigure(p1);

		if (_clickedFigure == null)
			return;

		Point pos = _clickedFigure.getPosition();
		Point addPos = new Point(p1.x - pos.x, p1.y - pos.y);
		Point realPos = new Point(p2.x - addPos.x, p2.y - addPos.y);
		_clickedFigure.setPosition(realPos);
		_clickedFigure = null;
		_frame.repaint();
	}

}
