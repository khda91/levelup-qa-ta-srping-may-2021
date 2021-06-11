package ru.levelup.at.java;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        System.out.println(deleteS(null));
        System.out.println(deleteS(Collections.emptyList()));
        System.out.println(deleteS(Collections.singletonList(null)));
        System.out.println(deleteS(List.of("saSha", "maSha", "apple")));
    }

    static List<String> deleteS(List<String> list) {
        if (list == null || list.isEmpty()) {
            return Collections.emptyList();
        }
        //        var res = new ArrayList<String>();
        //
        //        for (String str : list) {
        //            if (str != null) {
        //              res.add(str.replaceAll("S", ""));
        //            }
        //        }
        //
        //        return res;
        return list.stream()
                   .filter(Objects::nonNull)
                   .map(str -> str.replaceAll("S", ""))
                   .collect(Collectors.toList());
    }
}
