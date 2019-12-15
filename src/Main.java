import models.Game;
import services.GameManagerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Game game = GameManagerService.initiateGame();
        game.startGame();

    }
}
