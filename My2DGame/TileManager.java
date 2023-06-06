import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
//import java.util.concurrent.ExecutionException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    public int mapTileNum[][]; //* this map will store the txt map */

    public TileManager(GamePanel gp)
    {
        this.gp = gp;
        tile = new Tile[10]; //* this will be 10 kinds of tiles */
        mapTileNum = new int[gp.maxScreenRow][gp.maxScreenCol];
        getTileImage();
        loadMap();
    }

    public void getTileImage()
    {
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("sang_tran.jpg"));
            tile[0].collision = true;


            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("dirt.png"));
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void loadMap()
    {
        try
        {
            InputStream is = getClass().getResourceAsStream("tiles_Sang_Tran.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            //* br is the method to read the text file */

            int col = 0;
            int row = 0;
            while(col < gp.maxScreenCol && row < gp.maxScreenRow)
            {
                String line = br.readLine(); //* read a single line */
                while(col < gp.maxScreenCol)
                {
                    String numbers[] = line.split(" ");
                    /*
                     * this means number[0] = 0; number[1] = 0; number[2] = 1 
                     * follow the txt file!
                     * 
                     */

                    //* convert string to int */
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[row][col] = num;
                    col++;
                    
                }
                if(col == gp.maxScreenCol)
                    {
                        col = 0;
                        row++;
                    }
                

            }
            br.close();
        }
        catch(Exception e)
        {

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

        // int col = 0, row = 0, x = 0, y = 0;
        // //* cot dau tien */
        // while (row < gp.maxScreenRow)
        // {
        //     x = 0;
        //     row++;
        //     g2.drawImage(tile[0].image, x, y,gp.tileSize, gp.tileSize, null);
        //     y += gp.tileSize;
        // }
        // col = 0; row = 0; x = 0; y = 0;
        // //* hang tren cung */
        // while(col < gp.maxScreenCol)
        // {
        //     y = 0;
        //     g2.drawImage(tile[0].image, x, y,gp.tileSize, gp.tileSize, null);
        //     col++;
        //     x += gp.tileSize;
        // }
        // col = 0; row = 0; x = 0; y = 0;
        // //* hang ben duoi cung */
        // //x = gp.tileSize; y = gp.maxScreenCol; col = 0; row = gp.maxScreenRow;
        // while(col < gp.maxScreenCol )
        // {
        //     y = gp.tileSize * gp.maxScreenRow - gp.tileSize;
        //     col++;
        //     g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
        //     x += gp.tileSize;
            
            
        // }

        // //* cot phai cung */
        // col = 0; row = 0; x = 0; y = 0;
        // while(row < gp.maxScreenRow )
        // {
        //     x = gp.tileSize * gp.maxScreenCol - gp.tileSize;
        //     row++;
        //     g2.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
        //     y += gp.tileSize;
            
            
        // }
        

        //* draw follow txt file */

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while(col < gp.maxScreenCol && row < gp.maxScreenRow)
        {
            int tileNum = mapTileNum[row][col];
            g2.drawImage(tile[tileNum].image,x, y,gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol)
            {
                col = 0;
                x = 0;
                row++;
                y+=gp.tileSize;
            }
        }
        
        
    }

}
