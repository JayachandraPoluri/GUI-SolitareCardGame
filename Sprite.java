import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprite {
    private BufferedImage spriteSheet;
    private int spriteWidth;
    private int spriteHeight;
    private int numSprites;
    private int numRows;
    private int numColumns;

    public Sprite() {
        // Initialize fields to default values
        spriteSheet = null;
        spriteWidth =0;
        spriteHeight = 0;
        numSprites = 52;
        numRows = 4;
        numColumns = 13;
    }

    public void getSpriteSheet(String filename) {
        try {
            spriteSheet = ImageIO.read(new File(filename));
            spriteWidth = spriteSheet.getWidth() / numColumns;
            spriteHeight = spriteSheet.getHeight() / numRows;
            numSprites = numRows * numColumns;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int row, int col) {
        if (spriteSheet == null || row < 0 || row >= numRows || col < 0 || col >= numColumns) {
            return null;
        }

        return spriteSheet.getSubimage(col * spriteWidth, row * spriteHeight, spriteWidth, spriteHeight);
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
    }

    // Other methods and fields can be added as needed
}