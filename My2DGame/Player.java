//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
//import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends entity {
    GamePanel gp;
    KeyHandler keyH;
    public Player(GamePanel gp, KeyHandler keyH)
    {
        this.gp = gp;
        this.keyH = keyH;


        solidArea = new Rectangle(8,16,32, 32);

        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues()
    {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage()
    {
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("sang_tran.jpg"));
            //up2 = ImageIO.read(getClass().getResourceAsStream("C:/Users/ASUS/OneDrive/my programming files/Java programming/My2DGame/sang_tran.jpg"));
            down1 = ImageIO.read(getClass().getResourceAsStream("sang_tran.jpg"));
            //down2 = ImageIO.read(getClass().getResourceAsStream("C:/Users/ASUS/OneDrive/my programming files/Java programming/My2DGame/sang_tran.jpg"));
            left1 = ImageIO.read(getClass().getResourceAsStream("sang_tran.jpg"));
            //left2 = ImageIO.read(getClass().getResourceAsStream("C:/Users/ASUS/OneDrive/my programming files/Java programming/My2DGame/sang_tran.jpg"));
            right1 = ImageIO.read(getClass().getResourceAsStream("sang_tran.jpg"));
            //right2 = ImageIO.read(getClass().getResourceAsStream("C:/Users/ASUS/OneDrive/my programming files/Java programming/My2DGame/sang_tran.jpg"));

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void update()
    {
        if(keyH.upPressed == true)
        {
            direction = "up";
            //System.out.println("pressed up!");
            //y -= speed;
            //PlayerX = PlayerY-PlayerSpeed;
        }
        else if(keyH.downPressed == true)
        {
            direction = "down";
            //y += speed;
        }
        else if(keyH.leftPressed == true)
        {
            direction = "left";
            //x -= speed;
        }
        else if(keyH.rightPressed == true)
        {
            direction = "right";
            //x += speed;
        }
        collision = false;
        gp.cChecker.checkTile(this);

        if(collision == false)
        {
            switch(direction)
            {
                case "up":
                    y -= speed;
                    break;
                case "down":
                    y += speed;
                    break;
                case "left":
                    x -= speed;
                    break;
                case "right":
                    x += speed;
                    break;

            }
        }
    }
    public void draw(Graphics2D g2)
    {
        //g2.setColor(Color.white);

        //* this line create a rectange and its position! */
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = up1;

        switch(direction)
        {
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;    
            
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
