import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex18 {

    public static void main(String[] args) {
        List<Map<Byte, Integer>> collect = Stream.of(BinaryFile.read("TextFile.java")).map(
                bytes -> {
                    Map<Byte, Integer> map = new HashMap<Byte, Integer>();
                    for (Byte aByte : bytes) {
                        if (map.containsKey(aByte)) {
                            map.put(aByte, map.get(aByte) + 1);
                        } else {
                            map.put(aByte, 1);
                        }
                    }
                    return map;
                }
        ).collect(Collectors.toList());
        System.out.println(collect.get(0));
    }
}
