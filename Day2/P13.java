import java.util.*;

public class CommonElementsFinder {

    public static List<Integer> findCommonElements(List<Integer> list1, List<Integer> list2) {
        
        List<Integer> common = new ArrayList<>(list1);
        
        
        common.retainAll(list2);
        
        return common;
    }

    
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 9);

        List<Integer> commonElements = findCommonElements(list1, list2);
        System.out.println("Common elements: " + commonElements);
    }
}
