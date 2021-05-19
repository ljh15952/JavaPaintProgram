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
	private MyButtonActionListner _myListener;

	private Vector<Figure> _figureList;
	private int _figureType = 0;

	public MyFrame() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel(this));
		setLayout(null);
		setVisible(true);
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
			}
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
			realSize = p2;
		}
		f.setPosition(realPos);
		f.setSize(realSize);
		this.addFigure(f);

		repaint();
	}

	public Boolean isMakeFigureState() {
		return (_figureType != 0);
	}
}
