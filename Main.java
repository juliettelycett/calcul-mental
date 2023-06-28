import java.util.ArrayList;
import java.util.PropertyPermission;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        GenerateNumber GNumber;
        if (args.length > 0) {
            GNumber = new GenerateNumber(args[0]);
            
        } else {
            System.out.println("Difficulté non spécifiée, facile par défaut");
            GNumber = new GenerateNumber("facile");

        }
        //generate the calculus
        int first = GenerateNumber.generateRandomNumber(GNumber.getBound());
        Operations[] operations = Operations.values();
        Operations op = operations[GenerateNumber.generateRandomNumber(GNumber.getOperation())];
        
        //get answer
        int res = 0;
        int second = 0;
        String operator = "";
        switch (op) {
            case PLUS:
                second = GenerateNumber.generateRandomNumber(GNumber.getBound());
                res = first + second;
                operator = "+";
                break;
            case MINUS:
                second = GenerateNumber.generateRandomNumber(GNumber.getBound());
                res = (first - second);
                operator = "-";
                break;
            case MULTI:
                second = GenerateNumber.generateRandomNumber(GNumber.getBound());
                res = first * second;
                operator = "*";
                break;
            case DIV:
                var List = GenerateNumber.Div(first);
                second = GenerateNumber.generateRandomNumber(List.size());
                res = first / (int) List.get(second);
                operator = "/";
                break;
            default :
                break;
            
        }

        ArrayList<Integer> Proposition = new ArrayList<Integer>();
        Proposition.add(res);
        //generate other answers

        int answer1 = GenerateNumber.generateRandomNumber(GNumber.getAnswers());
        Proposition.add(answer1);
        int answer2 = res - 2;
        Proposition.add(answer2);
        int answer3 = res + 5;
        Proposition.add(answer3);


        //display the calculus
        System.out.println(first + " " + operator + " " + second + " = ?");


        //display answers randomly
        GenerateNumber.displayProposition(Proposition, 4);

    }
}
