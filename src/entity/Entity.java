package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {

	//public int x,y;
	public int worldX, worldY;
	public int speed;
	
	public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	public String direction;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	//solid area are the part of the sprite that is solid to use in collisions
	public Rectangle solidArea;
	public boolean collisionOn=false;
}
