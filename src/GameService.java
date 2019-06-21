import java.io.IOException;
import java.util.Scanner;

public class GameService {
    public static void main(String args[]) throws IOException {
        System.out.println("Welcome to the game of Chess!");
        int playerID = 1;
        Player p1,p2;
        System.out.println("White player enter your name");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        p1 = new Player(name,Color.WHITE);
        System.out.println("Black player enter your name");
        sc = new Scanner(System.in);
        name = sc.nextLine();
        p2 = new Player(name,Color.BLACK);
        Game game = new Game(p1,p2);
        game.startGame();
        game.displayBoard();
        System.out.println("White player goes first");

        while (!game.isWon){
            System.out.println("Player 1(White) turn");
            game.MakeMove(p1);
            game.displayBoard();
            if(game.isCheckMate()){
                System.out.println("Player 1 has won");
                game.isWon = true;
                break;
            }
            System.out.println("Player 2(Black) turn");
            game.MakeMove(p2);
            game.displayBoard();
            if(game.isCheckMate()){
                System.out.println("Player 2 has won");
                game.isWon = true;
                break;
            }
        }
    }
}
