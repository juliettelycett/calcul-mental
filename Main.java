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
        Operations op = operations[GenerateNumber.generateRandomNumberOP(GNumber.getOperation())];
        
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
                var divisors = GenerateNumber.Div(first);
                if (divisors.isEmpty()) {
                    // Si le premier nombre est un nombre premier, aucun diviseur n'est disponible
                    second = 1;
                    res = first / second;
                    operator = "/";
                } else {
                    Integer[] divisorsArray = (Integer[]) divisors.toArray(new Integer[0]);
                    second = divisorsArray[GenerateNumber.generateRandomNumber(divisorsArray.length)];
                    res = first / second;
                    operator = "/";
                }
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
