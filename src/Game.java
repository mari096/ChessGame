import java.util.Scanner;

public class Game {
    Board board;
    Player player1, player2;
    boolean isWon;

    public Game(Player player1, Player player2)
    {
        this.board = new Board();
        this.player1 = player1;
        this.player2 = player2;
        this.isWon = false;
    }

    public void startGame()
    {
        int i;
        //Pawn placement
        for(i=0;i<8;i++) {
            Position pos = new Position(1,i);
            Piece piece = new Pawn(Type.PAWN,Color.BLACK,pos);
            this.board.placePieceAtPosition(pos,piece);
        }
        for(i=0;i<8;i++){
            Position pos = new Position(6,i);
            Piece piece = new Pawn(Type.PAWN,Color.WHITE,pos);
            this.board.placePieceAtPosition(pos,piece);
        }

        //Queen placement
        Position pos = new Position(0,3);
        Piece piece = new Queen(Type.QUEEN,Color.BLACK,pos);
        this.board.placePieceAtPosition(pos,piece);

        pos = new Position(7,3);
        piece = new Queen(Type.QUEEN,Color.WHITE,pos);
        this.board.placePieceAtPosition(pos,piece);

        //Rook placement
        pos = new Position(0,0);
        piece = new Rook(Type.ROOK,Color.BLACK,pos);
        this.board.placePieceAtPosition(pos,piece);

        pos = new Position(0,7);
        piece = new Rook(Type.ROOK,Color.BLACK,pos);
        this.board.placePieceAtPosition(pos,piece);

        pos = new Position(7,0);
        piece = new Rook(Type.ROOK,Color.WHITE,pos);
        this.board.placePieceAtPosition(pos,piece);

        pos = new Position(7,7);
        piece = new Rook(Type.ROOK,Color.WHITE,pos);
        this.board.placePieceAtPosition(pos,piece);
        return;
    }

    public void MakeMove(Player player)
    {
        while (true) {
            System.out.println("Enter Source");
            Scanner sc = new Scanner(System.in);
            int src_x = sc.nextInt();
            int src_y = sc.nextInt();

            System.out.println("Enter Destination");
            sc = new Scanner(System.in);
            int dest_x = sc.nextInt();
            int dest_y = sc.nextInt();
            if (board.MovePiece(this.board.board[src_x][src_y], this.board.board[dest_x][dest_y],player)) {
                this.board.board[dest_x][dest_y].piece = this.board.board[src_x][src_y].piece;
                this.board.board[src_x][src_y] = new Position(src_x,src_y);
                break;
            }
        }
        return;
    }

    private void displayUtil(Piece piece){
        if(piece.getType()==Type.PAWN)
            System.out.print("P ");
        else if(piece.getType()==Type.ROOK)
            System.out.print("R ");
        else if(piece.getType()==Type.QUEEN)
            System.out.print("Q ");
    }

    private void displayPiece(Position position)
    {
        if(!position.isOccupied) {
            System.out.print("-- ");
            return;
        }
        if(position.piece.getColor()==Color.BLACK) {
            System.out.print("B");
            displayUtil(position.piece);
        }
        else if(position.piece.getColor()==Color.WHITE) {
            System.out.print("W");
            displayUtil(position.piece);
        }
        return;
    }

    public void displayBoard()
    {
        int i,j;
        for(i=0;i<8;i++){
            for(j=0;j<8;j++){
                displayPiece(this.board.board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isCheckMate()
    {
        return false;
    }
}
