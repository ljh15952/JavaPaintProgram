import java.awt.Point;

public class DrawState {
	protected MyFrame _frame;

	public DrawState(MyFrame f) {
		_frame = f;
	}

	public Point getPosition(Point p1, Point p2) {
		return new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
	}

	public Point getSize(Point p1, Point p2) {
		return new Point(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));
	}

	public void setFigure(Figure f, Point p1, Point p2) {
		f.setPosition(getPosition(p1, p2));
		f.setSize(getSize(p1, p2));
		_frame.addFigure(f);
	}
}
