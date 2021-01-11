import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


class Straight extends Tetriminos {

    public Straight(double blockWidth, double blockHeight, Rectangle rect) {
        super(blockWidth, blockHeight, rect);
    }


    @Override
    public Rectangle[] shapeLayout(int x, int y, int difference){

        Rectangle[] straight = new Rectangle[4];

        for(int i = 0; i < straight.length; i++){
            straight[i] = super.getShape(x, y);
            y=y+difference;
        }
        
        return straight;
    }

}


// superclass
public abstract class Tetriminos {

    private double blockWidth;
    private double blockHeight;

    Rectangle block;

    public Tetriminos (double blockWidth, double blockHeight, Rectangle block) {
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
        this.block = block;

    }
    // to create a block. This will be @Override in each subclass
    public void setWidth(double blockWidth){

        this.blockWidth = blockWidth;

    }

    public void setHeight(double blockHeight){

        this.blockHeight = blockHeight;
    }

    public Rectangle getShape(int x, int y){

        block.setWidth(blockWidth);
        block.setHeight(blockHeight);
        block.setLayoutX(x);
        block.setLayoutY(y);
        block.setFill(Color.BLACK);

        return block;

    }

    public abstract Rectangle[] shapeLayout(int x, int y, int difference);


}
