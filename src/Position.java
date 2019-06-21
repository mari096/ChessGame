public class Position {
    int x;
    int y;
    Piece piece;
    boolean isOccupied;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.isOccupied = false;
    }

    public void freePosition() { this.isOccupied = false; }
    public void occupyPosition() { this.isOccupied = true; }

    public void setPiece(Piece piece) { this.piece = piece;}

    public void setPosition(Position position)
    {
        this.x = position.x;
        this.y = position.y;
        return;
    }
}
