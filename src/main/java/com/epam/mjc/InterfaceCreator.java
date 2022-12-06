package com.epam.mjc;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for (String s : strings) {
                char firstChar = s.charAt(0);
                if (Character.isDigit(firstChar) || Character.isLowerCase(firstChar)) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return numbers -> numbers.addAll(numbers.stream().filter(i-> i % 2 == 0).collect(Collectors.toList()));
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return  () -> values.stream().filter(s-> Character.isUpperCase(s.charAt(0))
                && s.endsWith(".")
                && s.split(" ").length > 3).collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> strings.stream().collect(Collectors.toMap(s->s, String::length));
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (first, second) -> {
          List<Integer> result = new ArrayList<>(first);
          result.addAll(second);
          return result;
        };
    }
}
