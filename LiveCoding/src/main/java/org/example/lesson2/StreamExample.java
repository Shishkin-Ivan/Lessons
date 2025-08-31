package org.example.lesson2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Условия
// Сумму транзакций для каждой валюты
// Топ 3 крупнейших транзакций в каждой валюте
// Общее количество транзакций
public class StreamExample {

    public static Map<String, Map<String, Object>> analyzeTransactional(List<Transaction> transactions) {
        return transactions.stream().collect(
                Collectors.groupingBy(
                        Transaction::getCurrency,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> {
                                    Map<String, Object> result = new HashMap<>();
                                    double total = list.stream()
                                            .mapToDouble(Transaction::getAmount)
                                            .sum();
                                    List<Transaction> subList = list.stream()
                                            .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                                            .limit(3)
                                            .collect(Collectors.toList());
                                    result.put("total", total);
                                    result.put("Top 3", subList);
                                    result.put("Count", list.size());
                                    return result;
                                }
                        )
                )
        );
    }
}
