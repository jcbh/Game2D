package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gp;
	Tile[] tile;
	
	public TileManager(GamePanel gp) {
		super();
		this.gp = gp;
		
		tile = new Tile[10];
		getTileImage();
	}
	
	public void getTileImage() {
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		
		g2.drawImage(tile[1].image, 0, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, gp.tileSize, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, gp.tileSize*2, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, gp.tileSize*3, 0, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, gp.tileSize*4, 0, gp.tileSize, gp.tileSize, null);
		
		g2.drawImage(tile[1].image, 0, gp.tileSize, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image, gp.tileSize, gp.tileSize, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image, gp.tileSize*2, gp.tileSize, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image, gp.tileSize*3, gp.tileSize, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, gp.tileSize*4, gp.tileSize, gp.tileSize, gp.tileSize, null);
	
		g2.drawImage(tile[1].image, 0, gp.tileSize*2, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image, gp.tileSize, gp.tileSize*2, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image, gp.tileSize*2, gp.tileSize*2, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image, gp.tileSize*3, gp.tileSize*2, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image, gp.tileSize*4, gp.tileSize*2, gp.tileSize, gp.tileSize, null);
		
		g2.drawImage(tile[1].image, 0, gp.tileSize*3, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image, gp.tileSize, gp.tileSize*3, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image, gp.tileSize*2, gp.tileSize*3, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[0].image, gp.tileSize*3, gp.tileSize*3, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, gp.tileSize*4, gp.tileSize*3, gp.tileSize, gp.tileSize, null);
		
		g2.drawImage(tile[1].image, 0, gp.tileSize*4, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[2].image, gp.tileSize, gp.tileSize*4, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[2].image, gp.tileSize*2, gp.tileSize*4, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[2].image, gp.tileSize*3, gp.tileSize*4, gp.tileSize, gp.tileSize, null);
		g2.drawImage(tile[1].image, gp.tileSize*4, gp.tileSize*4, gp.tileSize, gp.tileSize, null);
		
	}
	
	
}
