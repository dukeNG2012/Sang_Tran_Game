import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
//* This class is our control system */
public class GamePanel extends JPanel implements Runnable
{
    int FPS = 100;
    KeyHandler keyH = new KeyHandler();
    //* Screen settings */
    final int originalTileSize = 16; // 16 x 16
    final int scale = 3;
    public final int tileSize = originalTileSize * scale; // 48 x 48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    
    //* this line wwill do some thing...... */
    Thread gameThread; 
    //? when we run this thread, it will automatic run the run method!
    Player player = new Player(this, keyH);

    TileManager tileM = new TileManager(this);
    


    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);

        //* if set to true, all the drawing from this component will be done in an offscreen painting buffer */
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        //* this line will focus when our key is press */
        this.setFocusable(true);
    }
    
    public void startGameThread()
    {
        //* this means you add gamepanel to this thread */
        gameThread = new Thread(this);
        gameThread.start();// this line will auto run the run() function!
    }

    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while(gameThread != null)
        {
            
            
            //* update information such as character position */
            
            
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1)
            {
                update();
            //* 2 Draw: draw the screen */

                /*
                *   sau khi minh fix ham update, thi hinh cua minh bien mat
                *   Dieu nay la boi vi chi can an 1 lan la repaint() da duoc goi rat
                * nhieu lan va lam mat hinh luon!
                * 
                */
                repaint();
                delta--;
            }
            
            
            

            

            
        }

    }
    public void update()
    {
        player.update();
    }
    public void paintComponent(Graphics g)
    {
        //* this super will affect imediate in JPanel! */
        super.paintComponent(g);

        //* This line will change graphic to graphics2d */
        Graphics2D g2 = (Graphics2D)g;

        //* draw tileM before player */
        tileM.draw(g2);
        player.draw(g2);
        
        g2.dispose();
    }

}
