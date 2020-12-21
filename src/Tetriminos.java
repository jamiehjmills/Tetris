import javafx.scene.shape.Rectangle;

// superclass
public class Tetriminos {

    double blockWidth;
    double blockHeight;
    double Xposition;
    double Yposition;

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

    public Rectangle shape(Rectangle block){

        this.block = block;

        block.setWidth(blockWidth);
        block.setHeight(blockHeight);
        block.setLayoutX(Xposition);
        block.setLayoutY(Yposition);

        return block;

    }


}
