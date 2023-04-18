import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TT {

	public static void main(String[] args) {
		Set<Integer> s = new HashSet<>();
		s.add(1);
		s.add(1);
		s.add(1);
		s.add(2);
		s.add(2);
		s.add(3);
		List<Integer> l = new ArrayList<>(s);
		System.out.println(l);
	}

}
