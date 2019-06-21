public class Board {
    Position[][] board;

    public Board()
    {
        this.board = new Position[8][8];
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                this.board[i][j] = new Position(i,j);
            }
        }
    }

    public boolean placePieceAtPosition(Position position,Piece piece)
    {
        if(position.isOccupied)
            return false;
        position.piece = piece;
        position.occupyPosition();
        this.board[position.x][position.y] =  position;
        return true;
    }

    public boolean MovePiece(Position src, Position dest,Player player)
    {
        if(!src.isOccupied || (src.isOccupied && src.piece.getColor()!=player.getColor())) {
            System.out.println("Please enter source co-ordinate properly");
            return false;
        }
        if(!src.piece.Move(dest)) {
            System.out.println("Destination co-ordinates unreachble");
            return false;
        }
        return true;
    }
}
