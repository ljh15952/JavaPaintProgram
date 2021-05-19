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
		if (_frame.isMoveFigureState())
			_frame.checkClickedFigure(e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (_frame.isMakeFigureState())
			_frame.makeFigure(_firstPos, e.getPoint());
		if (_frame.isMoveFigureState())
			_frame.moveFigure(_firstPos, e.getPoint());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
