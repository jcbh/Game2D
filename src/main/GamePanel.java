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
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
	public final int screenHeigth = tileSize * maxScreenRow; // 576 pixels
	
	//World Settings
	
	public final int maxWorldCol= 50;
	public final int maxWorldRow= 50;
	public final int maxWorldWidth= tileSize * maxWorldCol;
	public final int maxWorldHeigth= tileSize * maxWorldRow;
	
	//FPS
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();	
	Thread gameThread;
	public CollisionChecker collisionChecker = new CollisionChecker(this);
	public Player player = new Player(this, keyH);
	TileManager tileM = new TileManager(this);
	
	public GamePanel() {
		
		setPreferredSize(new Dimension(screenWidth, screenHeigth));
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
