import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class TT {

	public static void main(String[] args) {
		Map<String, Map<Integer, Set<Integer>>> map = new HashMap<>();

		Map<Integer, Set<Integer>> row = map.getOrDefault("dd", new HashMap<>());





		Set<Integer> cul = row.getOrDefault(1, new HashSet<>());
		cul.add(1);
		cul.add(2);
		cul.add(3);
		row.put(1, cul);
		map.put("dd", row);

		System.out.println(map.get("dd"));

		System.out.println(row.keySet());

	}

}
