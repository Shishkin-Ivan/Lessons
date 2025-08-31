package org.example.lesson;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class SteamExample {



    public Map<String, Map<String, Object>> analyzeProduct(List<Product> products){
        return products.stream().collect(
                Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.teeing(
                                Collectors.averagingDouble(Product::getPrice),
                                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)),
                                (avg, maxOpt) -> {
                                    Map<String, Object> result = new HashMap<>();
                                    result.put("average", avg);
                                    result.put("max", maxOpt.map(Product::getPrice).orElse(0d));
                                    return result;
                                }
                        )
                )
        );
    }
}
