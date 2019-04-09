package PracticeSim;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Window extends Canvas{

	private static final long serialVersionUID = -7606809190565392235L;
	private JFrame frame;
	private Canvas canvas;
	public JTextArea area;
	public JScrollPane sbar;
	private boolean on = false;

	public Window(int width, int height , String title, Game game)
	{
		frame = new JFrame(title);
		
		
		area = new JTextArea("this is going to be displayed");
		sbar = new JScrollPane(area);	
		area.setBackground(Color.gray);
		area.setEditable(false);
		sbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sbar.setBounds(50, 600, 800, 250);
		frame.add(sbar);

		sbar.setVisible(false);
		
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		
		frame.add(game);
		frame.setVisible(true);
		game.start();
		
	}
	public void setOn(boolean on) {
		this.on = on;
	}
	public JFrame getFrame() {
		return frame;
	}
	public Canvas getCanvas() {
		return canvas;
	}

}
