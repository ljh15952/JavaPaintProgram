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

		Point addPos = new Point(p2.x - p1.x, p2.y - p1.y);
		_clickedFigure.addPosition(addPos);
		_frame.repaint();
	}

}
