import models.Game;
import services.GameManagerService;


public class Main {
    public static void main(String[] args) {
        Game game = GameManagerService.initiateGame();
        game.startGame();

    }
}
