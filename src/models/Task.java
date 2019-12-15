package models;

import interfaces.ITask;

import java.util.Scanner;

public class Task implements ITask {
    Integer a;
    Integer b;
    Integer answer;
    String op;

    private Task(){};

    public Task(Integer a, Integer b, Integer answer, String op) {
        this.a = a;
        this.b = b;
        this.answer = answer;
        this.op = op;
    }

    @Override
    public int getQuestion() {
        System.out.println( a+" "+op+" "+b+" = ?");
        Scanner in = new Scanner(System.in);
        if(Integer.parseInt(in.next()) == answer) return 1;
        else {
            System.out.println("Wrong Answer, Correct is: " + a + " " + op + " " + b + " = " + answer);
            return 0;
        }
    }
}
