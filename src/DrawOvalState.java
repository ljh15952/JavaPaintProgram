import java.awt.Point;

public class DrawOvalState extends DrawState implements StatePattern {

	public DrawOvalState(MyFrame f) {
		super(f);
	}

	@Override
	public void do_something(Point p1, Point p2) {
		Figure f = new Oval();
		setFigure(f, p1, p2);
	}

}
