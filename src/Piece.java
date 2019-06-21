public abstract class Piece {
    private Type type;
    private Color color;
    private Position position;
    boolean isAlive;

    public Piece(Type type, Color color,Position position)
    {
        this.type = type;
        this.color = color;
        this.position = position;
        this.isAlive = true;
    }

    public Type getType() { return this.type;}
    public Color getColor() { return this.color;}

    public Position getPosition() { return this.position; }

    public boolean isValidMove(Position position)
    {
        if(position.x<0 || position.y<0 || position.x>=8 || position.y>=8)
            return false;
        return true;
    }

    public boolean Move(Position position)
    {
        if(!this.isValidMove(position))
            return false;
        position.occupyPosition();
        this.position = position;
        return true;
    }
}
