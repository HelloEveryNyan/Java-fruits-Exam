import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PicnicAnalyzer {

    public static void main(String[] args) {
        int wordCount = countWords(".idea/input.txt");
        System.out.println("Count of words in file: " + wordCount);

        String longestWord = findLongestWord(".idea/input.txt");
        System.out.println("Longest word: " + longestWord);

        Map<String, Integer> wordFrequency = calculateWordFrequency(".idea/input.txt");
        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    private static int countWords(String fileName) {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count += line.split("\\s+").length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private static String findLongestWord(String fileName) {
        String longestWord = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return longestWord;
    }

    private static Map<String, Integer> calculateWordFrequency(String fileName) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordFrequency;
    }
}
