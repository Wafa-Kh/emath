package interfaces;

import models.Task;

import java.util.List;

public interface IGame {
    List<Task> getTasks();
    void setTasks(List<Task> tasks);
    void startGame();
}
