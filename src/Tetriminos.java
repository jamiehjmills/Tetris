import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


class Straight extends Tetriminos {

    public Straight(double blockWidth, double blockHeight) {
        super(blockWidth, blockHeight);
    }


    @Override
    public Rectangle[][] shapeLayout(int x, int y, int difference) {

        Rectangle[][] straight = new Rectangle[1][4];

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(y); // works fine
                straight[i][j] = super.getShape(x, y);
                y = y + difference;
            }
        }

        return straight;
    }
}


// superclass
public abstract class Tetriminos {

    private double blockWidth;
    private double blockHeight;

    public Tetriminos (double blockWidth, double blockHeight) {
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
    }
    // to create a block. This will be @Override in each subclass
    public void setWidth(double blockWidth){

        this.blockWidth = blockWidth;

    }

    public void setHeight(double blockHeight){

        this.blockHeight = blockHeight;
    }

    public Rectangle getShape(int x, int y){

        Rectangle block = new Rectangle();

        block.setWidth(blockWidth);
        block.setHeight(blockHeight);
        block.setX(x);
        block.setY(y);
        block.setFill(Color.BLACK);

        return block;

    }

    public abstract Rectangle[][] shapeLayout(int x, int y, int difference);


}
