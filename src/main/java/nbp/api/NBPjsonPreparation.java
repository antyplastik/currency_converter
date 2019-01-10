package nbp.api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NBPjsonPreparation {

    public String prepare(String json){
        List<String> list = Arrays.stream(json
                .split("\n"))
                .collect(Collectors.toList());

        for (int i = 0; i < 3; i++)
            list.remove(0);

        return list.stream().collect(Collectors.joining());
    }

}
