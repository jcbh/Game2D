package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable{

	private static final long serialVersionUID = 4238812509645110460L;
	
	//Screen settings
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; // 48 x48 tile
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	final int screenHigth = tileSize * maxScreenRow; // 576 pixels
	
	//FPS
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();	
	Thread gameThread;
	Player player = new Player(this, keyH);
	TileManager tileM = new TileManager(this);
	
	public GamePanel() {
		
		setPreferredSize(new Dimension(screenWidth, screenHigth));
		setBackground(Color.black);
		setDoubleBuffered(true);
		this.addKeyListener(keyH);
		//Game panel can be 'focused' to receive input
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

//	@Override
//	public void run() {
//		
//		//nine zeros (nanoseconds) = 1 second
//		double drawInteval = 1000000000 / FPS;
//		double nextDrawTime = System.nanoTime() + drawInteval;
//		
//		while (gameThread != null) {
//			//long currentTime = System.nanoTime();
//			//System.out.println("Current time: "+currentTime);
//
//			update();
//
//			repaint();			
//			
//			try {
//				double remainingTime=nextDrawTime - System.nanoTime();
//				remainingTime=remainingTime/1000000;
//				System.out.println(remainingTime);
//				if (remainingTime < 0)
//				{
//					remainingTime=0;	
//				}
//				Thread.sleep((long) remainingTime);
//				
//				nextDrawTime+= drawInteval;
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
	
	@Override
	public void run() {
		
		//nine zeros (nanoseconds) = 1 second
		double drawInteval = 1000000000 / FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer=0;
		int drawCount =0;
		
		while (gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime)/drawInteval;
			timer += (currentTime - lastTime);
			
			lastTime = currentTime;
	
			if (delta>=1)
			{
				update();
				
				repaint();
				
				delta--;
				
				drawCount++;
			}
			
			if (timer  > 1000000000) {
				System.out.println("FPS:"+drawCount);
				drawCount = 0;
				timer = 0;
			}

		}
		
		
	}
	
	public void update() {
		player.update();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		tileM.draw(g2);

		player.draw(g2);
		
		g2.dispose();
	}
	

}
