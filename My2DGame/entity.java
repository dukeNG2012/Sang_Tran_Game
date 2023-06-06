import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class entity {
    public int x, y;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    //public int apriteCounter = 0;
    //public int apriteNum = 1;
    public Rectangle solidArea;
    public boolean collision = false;
}
