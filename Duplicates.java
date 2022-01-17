import java.util.*;

public class Duplicates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> userInput = new ArrayList<>();

        while (scanner.hasNextInt()) {
            userInput.add(scanner.nextInt());
        }

        List<Integer> arrayA = new ArrayList<>();

        for (Integer integer : userInput) {
            if (integer != -1) {
                arrayA.add(integer);
            } else {
                break;
            }
        }
        List<Integer> arrayB = userInput.subList(arrayA.size() + 1, userInput.size());

        for (int i = 0; i < arrayA.size(); i++) {
            if (!arrayB.contains(i)) {
                System.out.print(arrayA.get(i) + " ");
            } else {
                System.out.print(arrayA.get(i) + " ");
                System.out.print(arrayA.get(i) + " ");
            }

        }
        System.out.print(-1);

    }

}
