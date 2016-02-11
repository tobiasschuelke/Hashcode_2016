package models;


public class Base {
    protected int xCoordinate;
    protected int yCoordinate;

    public void setCoordinates(Base base) {
        setCoordinates(base.xCoordinate, base.yCoordinate);
    }

    public void setCoordinates(int x, int y) {
        xCoordinate = x;
        yCoordinate = y;
    }

    public int calcDist(Base b){
        return new Double( Math.ceil( Math.sqrt(Math.pow(Math.abs(xCoordinate-b.xCoordinate),2) + Math.pow(Math.abs(yCoordinate-b.yCoordinate),2)))).intValue();
    }
}
