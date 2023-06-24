import java.util.ArrayList;
import java.util.PropertyPermission;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        GenerateNumber GNumber = new GenerateNumber(args[0]);

        //generate the calculus
        int first = GenerateNumber.generateRandomNumber(GNumber.getBound());
        String op = String.valueOf(GenerateNumber.generateRandomNumber(GNumber.getOperation()));

        //get answer
        int res = 0;
        int second;
        switch (op) {
            case "PLUS":
                second = GenerateNumber.generateRandomNumber(GNumber.getBound());
                res = first + second;
                break;
            case "MINUS":
                second = GenerateNumber.generateRandomNumber(GNumber.getBound());
                res = abs(first - second);
                break;
            case "MULTI":
                second = GenerateNumber.generateRandomNumber(GNumber.getBound());
                res = first * second;
                break;
            case "DIV":
                var List = GenerateNumber.Div(first);
                second = GenerateNumber.generateRandomNumber(List.size());
                res = first / (int) List.get(second);
                break;
            default :
                break;
            
        }

        var Proposition = new ArrayList<>();
        Proposition.add(res);
        //generate other answers

        int answer1 = GenerateNumber.generateRandomNumber(GNumber.getAnswers());
        Proposition.add(answer1);
        int answer2 = res - 2;
        Proposition.add(answer2);
        int answer3 = res + 5;
        Proposition.add(answer3);

        //display randomly
        GenerateNumber.displayProposition(Proposition, 4);

    }
}
