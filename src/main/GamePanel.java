package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	private static final long serialVersionUID = 4238812509645110460L;
	
	//Screen settings
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale; // 48 x48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHigth = tileSize * maxScreenRow; // 576 pixels
	
	Thread gameThread;
	
	public GamePanel() {
		
		setPreferredSize(new Dimension(screenWidth, screenHigth));
		setBackground(Color.black);
		setDoubleBuffered(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		
		while (gameThread != null) {
			//System.out.println("This game is running");
			
			// 1 Update
			update();
			// 2 Draw (repaint -> call paintComponent)
			repaint();
			
		}
	}
	
	public void update() {
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.setColor(Color.white);
		
		g2.fillRect(100, 100, tileSize, tileSize);
		
		g2.dispose();
	}
	

}
