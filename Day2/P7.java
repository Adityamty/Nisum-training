import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine().toLowerCase().replaceAll("[^a-z0-9\\s]", "");

        String[] words = text.split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words)
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("\nWord Frequencies (Descending):");
        for (Map.Entry<String, Integer> entry : list)
            System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
