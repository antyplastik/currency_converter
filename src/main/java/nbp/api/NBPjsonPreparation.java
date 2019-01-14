package nbp.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NBPjsonPreparation {

    public static String prepare(String json) {
        List<String> list = Arrays.stream(json
                .split("\n"))
                .collect(Collectors.toList());

        String character = list.get(0).charAt(0) + "";

        if (character.matches("[^A-Za-z0-9\\{ \\}\'\"\\s]"))
            for (int i = 0; i < 3; i++)
                list.remove(0);

        return list.stream().collect(Collectors.joining());
    }

}
