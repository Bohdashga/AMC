import java.util.*;

public class Subsequence{

    static boolean isSubSequence(List<Integer> head, List<Integer> tail)
    {
       int tailIdx = 0;
        for (Integer k: head) {
            if (tailIdx == tail.size()) {
                break;
            }
            if (tail.get(tailIdx).equals(k)) {
                tailIdx++;
            }
        }
        return tailIdx == tail.size();

    }



    public static void main(String[] args)  {
            Scanner scan = new Scanner(System.in);
            ArrayList<Integer> list = new ArrayList<Integer>();

            while (scan.hasNextInt()) {
                list.add(scan.nextInt());
            }

            List<Integer> head = list.subList(1, list.get(0) + 1);


            List<Integer> tail = list.subList(list.get(0) + 2, list.size());

        boolean res = isSubSequence(head, tail);
        if (res)
            System.out.print(1);
        else
            System.out.print(0);
    }
}