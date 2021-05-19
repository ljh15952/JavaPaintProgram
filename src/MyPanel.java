import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	private MyFrame _frame;

	public MyPanel(MyFrame f) {
		addMouseListener(new MyMouseListener(f));
		_frame = f;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Figure it : _frame.getFigureList()) {
			System.out.println("qwe");
			it.Draw(g);
		}
	}
}
