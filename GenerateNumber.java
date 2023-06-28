import java.util.ArrayList;
import java.util.Arrays;
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
            return generateRandomNumber(n);
        }
        return random;
    }
    public static void displayProposition(ArrayList<Integer> Proposition, int numb) {
        ArrayList<Integer> answers = new ArrayList<>(Arrays.asList(0, 0, 0, 0));
        ArrayList<Integer> used = new ArrayList<>();
        int count = 0; // Compteur pour suivre le nombre de réponses uniques déjà générées
    
        Random random = new Random();
    
        while (count < numb) {
            int index = random.nextInt(numb); // Génère un index aléatoire dans la plage de propositions
    
            if (!used.contains(index)) {
                used.add(index);
                answers.set(index, Proposition.get(count));
                count++;
            }
        }
    
        for (int i = 0; i < answers.size(); i++) {
            System.out.println(answers.get(i));
        }
    }
}
