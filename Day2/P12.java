import java.util.*;

public class UniqueSortedElements {
    
    public static Set<Integer> getSortedUniqueElements(int[] nums) {
  
        Set<Integer> sortedSet = new TreeSet<>();
        
        for (int num : nums) {
            sortedSet.add(num);
        }
        
        return sortedSet;
    }


    public static void main(String[] args) {
        int[] array = {5, 3, 8, 3, 1, 5, 9};
        Set<Integer> result = getSortedUniqueElements(array);
        System.out.println("Sorted unique elements: " + result);
    }
}
