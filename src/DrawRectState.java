import java.awt.Point;

public class DrawRectState extends DrawState implements StatePattern {
	public DrawRectState(MyFrame f) {
		super(f);
	}

	@Override
	public void do_something(Point p1, Point p2) {
		Figure f = new Rect();
		setFigure(f,p1,p2);
	}
}
