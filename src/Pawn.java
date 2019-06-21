public class Pawn extends Piece {
    public Pawn(Type type, Color color, Position position)
    {
        super(type,color,position);
    }

    @Override
    public boolean isValidMove(Position position)
    {
        if(!super.isValidMove(position))
            return false;
        if(this.getColor()==Color.BLACK) {
            if (!position.isOccupied && this.getPosition().x == (position.x) - 1 && this.getPosition().y == position.y)
                return true;
            if(position.isOccupied && position.piece.getColor()==Color.WHITE) {
                if (this.getPosition().x == (position.x) - 1 && Math.abs(this.getPosition().y - position.y) == 1) {
                    position.piece.isAlive = false;
                    position.piece = this;
                    return true;
                }
            }
        }
        else if(this.getColor()==Color.WHITE) {
            if (!position.isOccupied && this.getPosition().x == (position.x) + 1 && this.getPosition().y == position.y)
                return true;
            if(position.isOccupied && position.piece.getColor()==Color.BLACK) {
                if (this.getPosition().x == (position.x) + 1 && Math.abs(this.getPosition().y - position.y) == 1) {
                    position.piece.isAlive = false;
                    position.piece = this;
                    return true;
                }
            }
        }
        return false;
    }
}
