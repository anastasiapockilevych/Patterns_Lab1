import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LambdaExerciseRunner {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5, 4.5);
        List<String> stringList = Arrays.asList("Apple", "banana", "", "Cherry", "date", "Elephant");
        String sentence = "Це тестове речення для підрахунку кількості слів";

        System.out.println("1: " + filterOddNumbers(intList));
        System.out.println("2: " + calculateAverage(doubleList));
        System.out.println("3: " + sortAlphabetically(stringList));
        System.out.println("4: " + sumEvenNumbers(intList));

        int factorialInput = 5;
        System.out.println("5: " + calculateFactorial(factorialInput));

        long[] sumAndProduct = multiplyAndSum(intList);
        System.out.println("6: " + sumAndProduct[0] + ", " + sumAndProduct[1]);

        System.out.println("7: " + calculateSquares(intList));
        System.out.println("8: " + sortByLength(stringList));
        System.out.println("9: " + countWords(sentence));
        System.out.println("10: " + findFirstNonEmpty(stringList).orElse(""));

        List<String> capitalWords = Arrays.asList("Java", "Stream", "Api");
        System.out.println("11: " + checkAllStartWithCapital(stringList));
        System.out.println("11 (capitalWords): " + checkAllStartWithCapital(capitalWords));

        System.out.println("12: " + findSecondLargest(intList).map(String::valueOf).orElse(""));
        System.out.println("13: " + findLargestEven(intList).map(String::valueOf).orElse(""));
    }

    public static List<Integer> filterOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
    }

    public static double calculateAverage(List<Double> numbers) {
        return numbers.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static List<String> sortAlphabetically(List<String> strings) {
        return strings.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
    }

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static long calculateFactorial(int n) {
        if (n < 0) throw new IllegalArgumentException();
        return LongStream.rangeClosed(1, n)
                .reduce(1, (a, b) -> a * b);
    }

    public static long[] multiplyAndSum(List<Integer> numbers) {
        long sum = numbers.stream().mapToLong(Integer::longValue).sum();
        long product = numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
        return new long[]{sum, product};
    }

    public static List<Integer> calculateSquares(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static long countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) return 0;
        return Arrays.stream(sentence.split("\\s+"))
                .filter(word -> !word.isEmpty())
                .count();
    }

    public static Optional<String> findFirstNonEmpty(List<String> strings) {
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty())
                .findFirst();
    }

    public static boolean checkAllStartWithCapital(List<String> strings) {
        return strings.stream()
                .allMatch(s -> s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0)));
    }

    public static Optional<Integer> findSecondLargest(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    public static Optional<Integer> findLargestEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .max(Integer::compareTo);
    }
}