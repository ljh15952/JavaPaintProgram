import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public MyFrame() {
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		
		setVisible(true);
	}

	public void Init() {
		
	}
}
