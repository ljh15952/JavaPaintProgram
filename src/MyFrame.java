import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame {
	private JButton rectBtn;
	private JButton ovalBtn;
	private JButton lineBtn;
	private JButton moveBtn;
	private MyButtonActionListner _myListener;

	private Vector<Figure> _figureList;
	private int _figureType = 0;
	private Boolean _isMoveState = false;
	private Figure _clickedFigure = null;

	public MyFrame() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel(this));
		setLayout(null);
	}

	public void Init() {
		_myListener = new MyButtonActionListner();
		_figureList = new Vector<>();

		rectBtn = new JButton("사각형");
		rectBtn.setBounds(20, 20, 80, 35);
		rectBtn.addActionListener(_myListener);
		add(rectBtn);

		ovalBtn = new JButton("타원");
		ovalBtn.setBounds(110, 20, 80, 35);
		ovalBtn.addActionListener(_myListener);
		add(ovalBtn);

		lineBtn = new JButton("선");
		lineBtn.setBounds(200, 20, 80, 35);
		lineBtn.addActionListener(_myListener);
		add(lineBtn);

		moveBtn = new JButton("이동");
		moveBtn.setBounds(290, 20, 80, 35);
		moveBtn.addActionListener(_myListener);
		add(moveBtn);
	}

	class MyButtonActionListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rectBtn) {
				_figureType = 1;
			} else if (e.getSource() == ovalBtn) {
				_figureType = 2;
			} else if (e.getSource() == lineBtn) {
				_figureType = 3;
			} else if (e.getSource() == moveBtn) {
				_isMoveState = true;
				_figureType = 0;
			}

			// 도형 버튼을 눌렀을 경우 움직이는 상태 false
			if (_figureType != 0)
				_isMoveState = false;
		}

	}

	public void addFigure(Figure f) {
		_figureList.add(f);
	}

	public Vector<Figure> getFigureList() {
		return _figureList;
	}

	public void makeFigure(Point p1, Point p2) {
		Figure f = null;
		Point realPos = new Point(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y));
		Point realSize = new Point(Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));

		if (_figureType == 1) {
			f = new Rect();
		} else if (_figureType == 2) {
			f = new Oval();
		} else if (_figureType == 3) {
			f = new Line();
			realPos = p1;
			realSize = new Point((p2.x - p1.x), (p2.y - p1.y));
		}
		f.setPosition(realPos);
		f.setSize(realSize);
		this.addFigure(f);

		repaint();
	}

	public Boolean isMakeFigureState() {
		return (_figureType != 0);
	}

	public Boolean isMoveFigureState() {
		return _isMoveState;
	}

	public void checkClickedFigure(Point point) {
		for (Figure it : _figureList) {
			if (it.contains(point)) {
				_clickedFigure = it;
			}
		}
	}

	public void moveFigure(Point p1, Point p2) {
		if (_clickedFigure == null)
			return;
		Point pos = _clickedFigure.getPosition();
		Point addPos = new Point(p1.x - pos.x, p1.y - pos.y);
		Point realPos = new Point(p2.x - addPos.x, p2.y - addPos.y);
		_clickedFigure.setPosition(realPos);
		_clickedFigure = null;
		repaint();
	}
}
