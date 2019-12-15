package services;

import models.Game;
import models.Task;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class GameManagerService {

    public static Game initiateGame(){
        List<Task> tasks = generateAddSubTasks();
        Game game = new Game();
        game.setTasks(tasks);
        return game;
    }

    private  static Task getSignleTask(List<Integer> nums, Integer target,int idx) {
        Map<Integer, Integer> res = new HashMap<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer complement = target - nums.get(i);
            if (numMap.containsKey(nums.get(i))) {
                res.put(numMap.get(nums.get(i)),nums.get(i));
            } else {
                numMap.put(complement, nums.get(i));
            }
        }

        Random generator = new Random();
        Object[] values = res.values().toArray();
        Integer randomValue = (Integer) values[generator.nextInt(values.length)];
        if(idx%2 == 0) return new Task(target-randomValue,randomValue,target,"+");
        else return new Task(target,randomValue,target-randomValue,"-");

    }

    private static List<Integer> generatePossiblePairs(int target){
        List<Integer> nums = new ArrayList<>();
        int r = target % 10;
        for(Integer i = 1; i < target; i++) {
            if(i % 10 > r)
                nums.add(i);
        }
        return nums;
    }

    private static   List<Task> generateAddSubTasks() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> finalnumbers = new ArrayList<>();
        for(int i=21;i<100;i++){
            if(i % 10 != 9)
            numbers.add(i);
        }
        List<Integer> randomindexs = ThreadLocalRandom.current().ints(0, numbers.size()-1).distinct().limit(10).boxed().collect(Collectors.toList());
        randomindexs.stream().forEach(ind -> {
            finalnumbers.add(numbers.get(ind));
        });
        return getAddSubTasks(finalnumbers);
    }

    private static List<Task> getAddSubTasks(List<Integer> finalnumbers){
        List<Task> tasks = new ArrayList<>();
        for(int i =0;i<finalnumbers.size();i++){
            List<Integer> nums = generatePossiblePairs(finalnumbers.get(i));
            tasks.add(getSignleTask(nums,finalnumbers.get(i),i));
        }
        return tasks;
    }
}
