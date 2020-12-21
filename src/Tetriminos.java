import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


class Straight extends Tetriminos {

    public Straight(double blockWidth, double blockHeight) {
        super(blockWidth, blockHeight);
    }

    @Override
    public Rectangle shapeLayout(Rectangle block){

        Rectangle[] straight = new Rectangle[4];

        for(int i = 0; i < straight.length; i++){
            straight[i] = super.getShape(new Rectangle());
        }

        double layoutX =
        for(int i = 0; i < straight.length; i++){
            straight[i] = straight[i].setLayoutX();
        }
    }

}


// superclass
public class Tetriminos {

    private double blockWidth;
    private double blockHeight;
    private double Xposition;
    private double Yposition;

    Rectangle block;

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

    public void setX(double Xposition){

        this.Xposition = Xposition;
    }

    public void setY(double Yposition){

        this.Yposition = Yposition;
    }

    public Rectangle getShape(Rectangle block){

        this.block = block;

        block.setWidth(blockWidth);
        block.setHeight(blockHeight);
        block.setLayoutX(Xposition);
        block.setLayoutY(Yposition);
        block.setFill(Color.BLACK);

        return block;

    }

    public Rectangle shapeLayout(Rectangle block){

        Rectangle rect = new Rectangle();

        return rect;
    }


}
