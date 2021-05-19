import java.awt.Point;

public class DrawGroupState extends DrawState implements StatePattern {

	public DrawGroupState(MyFrame f) {
		super(f);
	}

	@Override
	public void do_something(Point p1, Point p2) {
		Group g = new Group();
		g.setPosition(getPosition(p1, p2));
		g.setSize(getSize(p1, p2));
		g.checkContainsFigure(_frame);
		g.resetSize();
		_frame.addFigure(g);
	}

}
