public class Queen extends Piece {
    public Queen(Type type, Color color, Position position)
    {
        super(type,color,position);
    }

    private boolean validUtil(Position position)
    {
        if (Math.abs(this.getPosition().x - position.x) == Math.abs(this.getPosition().y - position.y))
            return true;
        if (this.getPosition().x == position.x || this.getPosition().y == position.y)
            return true;
        return false;
    }

    @Override
    public boolean isValidMove(Position position) {
        if(!super.isValidMove(position))
            return false;
        if(!position.isOccupied) {
            if(validUtil(position))
                return true;
            return false;
        }
        else {
            if (validUtil(position)){
                if((this.getColor()==Color.BLACK && position.piece.getColor()==Color.WHITE) || (this.getColor()==Color.WHITE && position.piece.getColor()==Color.BLACK)){
                    position.piece.isAlive = false;
                    position.piece = this;
                    return true;
                }
            }
        }
        return false;
    }
}
