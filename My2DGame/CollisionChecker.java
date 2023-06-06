//import entity;

public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp)
    {
        this.gp = gp;
    }

    public void checkTile(entity en)
    {
        /*
         * solid area dung de xac dinh phan de collision o tren object la sang tran
         */
        int entityLeftx = en.x + en.solidArea.x;
        int entityRightx = en.x + en.solidArea.x + en.solidArea.width;
        int entityTopy = en.y + en.solidArea.y;
        int entityBottomy = en.y + en.solidArea.y + en.solidArea.height;

        int entityLeftCol = entityLeftx/gp.tileSize;
        int entityRightCol = entityRightx/gp.tileSize;
        int entityTopRow = entityTopy/gp.tileSize;
        int entityBottomRow = entityBottomy/gp.tileSize;
        
        int tileNum1;
        int tileNum2;
        switch(en.direction)
        {
            case "up":
                entityTopRow = (entityTopy - en.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM .mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    en.collision = true;
                }
                break;
            case "down":
                entityBottomRow = (entityBottomy + en.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM .mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    en.collision = true;
                }
                break;
            case "left":
                entityLeftCol = (entityLeftx - en.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM .mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    en.collision = true;
                }
                break;
            case "right":
                entityRightCol = (entityRightx + en.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM .mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true)
                {
                    en.collision = true;
                }
                break;

        }
    }
}
