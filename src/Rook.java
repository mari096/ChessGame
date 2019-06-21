public class Rook extends Piece {
    public Rook(Type type, Color color, Position position)
    {
        super(type,color,position);
    }

    private boolean validUtil(Position position)
    {
        if(this.getPosition().x==position.x || this.getPosition().y==position.y)
            return true;
        return false;
    }

    @Override
    public boolean isValidMove(Position position) {
        if(!super.isValidMove(position))
            return false;
        if(!position.isOccupied){
            if(validUtil(position))
                return true;
        }
        else {
            if(validUtil(position)){
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
