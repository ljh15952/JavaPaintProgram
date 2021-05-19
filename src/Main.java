
public class Main {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
		frame.Init();
		frame.setVisible(true);
	}
}
/*
TODO
1. Draw Rect, Oval, Line
2. Make JButton and Drag to draw 
3. Make Move Button
4. Make Group system to button
5. Test

make figure example
Rect r = new Rect();
r.setPosition(100,100);
r.setSize(50,50);
this.addChild(r);

상태 패턴과 어댑터 패턴을 사용하여 버튼에 따라 해야 할 행동을 구현하였음
그룹화 기능을 통해 Composite 패턴을 구현함
*/