package striver;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairsInSortedDLL {

    public static Map<Integer, Integer> findPairsWithSumNaive(DNode head, int sum){
        Map<Integer, Integer> sumPairs = new HashMap<>();

        DNode temp = head;
        while (temp != null){
            DNode temp2 = temp.next;
            while (temp2 != null){
                if(temp.data + temp2.data == sum){
                    sumPairs.put(temp.data, temp2.data);
                }
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        return sumPairs;
    }

    public static Map<Integer, Integer> findPairsWithSum(DNode head, int sum){
        Map<Integer, Integer> sumPairs = new HashMap<>();
        DNode start = head;
        DNode end = head;
        while (end.next != null){
            end = end.next;
        }

        while (start.data < end.data){
            if(start.data + end.data == sum){
                sumPairs.put(start.data, end.data);
                start = start.next;
                end = end.prev;
            }else if(start.data + end.data < sum){
                start = start.next;
            }else{
                end = end.prev;
            }
        }

        return sumPairs;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        DNode head = DoublyLinkedList.convertArrToDLL(arr);

        Map<Integer, Integer> pairs = findPairsWithSum(head, 10);
        for(Map.Entry<Integer, Integer> entry : pairs.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
