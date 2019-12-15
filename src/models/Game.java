package models;

import interfaces.IGame;
import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {

    Integer score = 0;
    List<Task> tasks = new ArrayList<>();

    @Override
    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public void startGame() {
        for(Task task : this.getTasks()){
            this.score += task.getQuestion();
        }
        System.out.println("Your score is : "+this.score);
        System.out.println("End.");
    }

    @Override
    public List<Task> getTasks() {
        return this.tasks;
    }
}
