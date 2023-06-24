import java.util.ArrayList;
import java.util.Random;


public class GenerateNumber {
    private int bound;
    private int operation;
    private int answers;

    public int getBound() {
        return bound;
    }

    public int getOperation() {
        return operation;
    }

    public int getAnswers() {
        return answers;
    }


    public GenerateNumber(String difficulty) {
        switch(difficulty) {
            case "facile":
                bound = 10;
                operation = 1;
                answers = 20;
                break;
            case "moyen":
                bound = 15;
                operation = 2;
                answers = 50;
                break;
            case "difficile":
                bound = 20;
                operation = 3;
                answers = 60;
                break;
            default:
                break;
        }
    }
    public static boolean isPremier(int n)
    {
        if (n <= 1)
        {
            return false;
        }
        for (int i = 2; i*i <= n; i++)
        {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static ArrayList Div(int n)
    {
        ArrayList ListDiv = new ArrayList<>();
        for (int i = 2; i <= n; i++)
        {
            if (n % i == 0) {
                ListDiv.add(i);
            }
        }
        return ListDiv;
    }

    public static int generateRandomNumber(int n) {
        //return a random number between 0 and n
        int random = new Random().nextInt(n + 1);
        if (isPremier(random)){
            generateRandomNumber(n);
        }
        return random;
    }

    public static void displayProposition(var Proposition, int numb)
    {
        var answers = new ArrayList<>();
        var used = new ArrayList<>();
        for (int i = 0; i < numb; i++)
        {
            int k = generateRandomNumber(3);
            if (used.contains(k)){
                numb -= used.size();
                displayProposition(Proposition, numb);
            }
            else {
                used.add(k);
                answers.set(k, Proposition[i]);
            }
        }
        for (int i = 0; i < answers.size(); i++)
        {
            System.out.println(answers.get(i));
        }
    }
}
