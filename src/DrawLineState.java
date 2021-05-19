import java.awt.Point;

public class DrawLineState extends DrawState implements StatePattern {

	public DrawLineState(MyFrame f) {
		super(f);
	}

	@Override
	public void do_something(Point p1, Point p2) {
		Figure f = new Line();
		f.setPosition(p1);
		f.setSize(new Point((p2.x - p1.x), (p2.y - p1.y)));
		_frame.addFigure(f);
	}

}
