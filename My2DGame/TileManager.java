import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class TileManager {
    GamePanel gp;
    Tile[] tile;

    public TileManager(GamePanel gp)
    {
        this.gp = gp;

        tile = new Tile[10]; //* this will be 10 kinds of tiles */

        getTileImage();
    }

    public void getTileImage()
    {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("sang_tran.jpg"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("sang_tran.jpg"));
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("sang_tran.jpg"));

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2)
    {
        //! gp is an object of game panel!
        //* i want to draw like khung tranh! */
        //g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        //g2.drawImage(tile[0].image, 48, 0, gp.tileSize, gp.tileSize, null);
        //g2.drawImage(tile[0].image, 96, 0, gp.tileSize, gp.tileSize, null);
        //g2.drawImage(tile[0].image, 96+48, 0, gp.tileSize, gp.tileSize, null);

        int col = 0, row = 0, x = 0, y = 0;
        //* cot dau tien */
        while (row < gp.maxScreenRow)
        {
            x = 0;
            row++;
            g2.drawImage(tile[0].image, x, y,gp.tileSize, gp.tileSize, null);
            y += gp.tileSize;
        }
        col = 0; row = 0; x = 0; y = 0;
        //* hang tren cung */
        while(col < gp.maxScreenCol)
        {
            y = 0;
            g2.drawImage(tile[0].image, x, y,gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
        }
        col = 0; row = 0; x = 0; y = 0;
        //* hang ben duoi cung */
        //x = gp.tileSize; y = gp.maxScreenCol; col = 0; row = gp.maxScreenRow;
        while(col < gp.maxScreenCol )
        {
            y = gp.tileSize * gp.maxScreenRow - gp.tileSize;
            col++;
            g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
            x += gp.tileSize;
            
            
        }

        //* cot phai cung */
        col = 0; row = 0; x = 0; y = 0;
        while(row < gp.maxScreenRow )
        {
            x = gp.tileSize * gp.maxScreenCol - gp.tileSize;
            row++;
            g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
            y += gp.tileSize;
            
            
        }

        
        
        
    }
}
