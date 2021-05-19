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
	private JButton groupBtn;
	private MyButtonActionListner _myListener;

	private Vector<Figure> _figureList;

	private StatePattern _nowState = null;

	public MyFrame() {
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel(this));
		setLayout(null);
	}

	public void Init() {
		_myListener = new MyButtonActionListner(this);
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

		groupBtn = new JButton("그룹화");
		groupBtn.setBounds(380, 20, 80, 35);
		groupBtn.addActionListener(_myListener);
		add(groupBtn);
	}

	class MyButtonActionListner implements ActionListener {
		private MyFrame frame;

		public MyButtonActionListner(MyFrame f) {
			frame = f;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == rectBtn) {
				_nowState = new DrawRectState(frame);
			} else if (e.getSource() == ovalBtn) {
				_nowState = new DrawOvalState(frame);
			} else if (e.getSource() == lineBtn) {
				_nowState = new DrawLineState(frame);
			} else if (e.getSource() == moveBtn) {
				_nowState = new MoveState(frame);
			}
		}
	}

	public void do_something(Point p1, Point p2) {
		_nowState.do_something(p1, p2);
	}

	public void addFigure(Figure f) {
		_figureList.add(f);
		repaint();
	}

	public Vector<Figure> getFigureList() {
		return _figureList;
	}
}
