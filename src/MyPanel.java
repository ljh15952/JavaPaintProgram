import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.JPanel;

public class MyPanel extends JPanel{
	private Vector<Figure> _figureList;
	
	public MyPanel(){
		_figureList = new Vector<>();
		
		Rect r = new Rect();
		r.setPosition(new Point(100,100));
		r.setSize(new Point(50,50));
		_figureList.add(r);
		
		Oval o = new Oval();
		o.setPosition(new Point(100,100));
		o.setSize(new Point(50,50));
		_figureList.add(o);
		
		Line l = new Line();
		l.setPosition(new Point(100,100));
		l.setSize(new Point(150,150));
		_figureList.add(l);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for(Figure it : _figureList) {
			it.Draw(g);
		}
	}
}
