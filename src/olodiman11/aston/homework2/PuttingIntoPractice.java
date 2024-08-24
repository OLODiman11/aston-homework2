package olodiman11.aston.homework2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {
    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей к большей).
        List<Transaction> res1 = transactions.stream()
                .filter(x -> x.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();
        System.out.println("1. " + res1);

        // 2. Вывести список неповторяющихся городов, в которых работают трейдеры.
        List<String> res2 = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .distinct()
                .toList();
        System.out.println("2. " + res2);

        // 3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.
        List<Trader> res3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(x -> x.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        System.out.println("3. " + res3);

        // 4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном порядке.
        String res4 = transactions.stream()
                .map(x -> x.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println("4. " + res4);

        // 5. Выяснить, существует ли хоть один трейдер из Милана.
        boolean res5 = transactions.stream()
                .map(x -> x.getTrader().getCity())
                .anyMatch(x -> x.equals("Milan"));
        System.out.println("5. " + (res5 ? "Трейдер из Милана существует" : "Трейдера из Милана не существует"));

        // 6. Вывести суммы всех транзакций трейдеров из Кембриджа.
        int res6 = transactions.stream()
                .filter(x -> x.getTrader().getCity().equals("Cambridge"))
                .mapToInt(Transaction::getValue)
                .sum();
        System.out.println("6. " + res6);

        // 7. Какова максимальная сумма среди всех транзакций?
        int res7 = transactions.stream()
                .mapToInt(Transaction::getValue)
                .max()
                .orElse(-1);
        System.out.println("7. " + res7);

        // 8. Найти транзакцию с минимальной суммой.
        Transaction res8 = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .orElse(null);
        System.out.println("8. " + res8);
    }
}
