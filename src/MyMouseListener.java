import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {
	private Point _firstPos;
	private MyFrame _frame;

	public MyMouseListener(MyFrame p) {
		_frame = p;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		_firstPos = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		_frame.do_something(_firstPos, e.getPoint());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
