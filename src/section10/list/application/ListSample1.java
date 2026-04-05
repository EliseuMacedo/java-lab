package section10.list.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListSample1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Anna");
        list.add("Marco");
        list.add("Alex");
        list.add("Daniel");
        list.add("Peter");
        list.add("Maria");
        list.add("Jordan");

        System.out.println(list);
        System.out.println("------------------");

        list.remove(1);
        System.out.println(list);
        System.out.println("------------------");

        list.remove("Peter");
        System.out.println(list);
        System.out.println("------------------");

        list.add(1, "Joshua");
        System.out.println(list);
        System.out.println("------------------");

        list.removeIf(x -> x.charAt(0)=='A');
        System.out.println(list);
        System.out.println("------------------");

        List<String> filterList = list.stream().filter(x->x.charAt(0)=='J').collect(Collectors.toList());
        System.out.println(filterList);
        System.out.println("------------------");

        String name = filterList.stream().filter(x->x.charAt(0)=='J').findFirst().orElse(null);
        System.out.println(name);

    }
}
