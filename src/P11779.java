import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P11779 {

	static int n;
	static int m;
	static List<List<int[]>> buses;
	static int startPoint;
	static int endPoint;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		input();
		dijkstra();
	}

	private static void dijkstra() {
		PriorityQueue<int[]> queue = new PriorityQueue<>(
			Comparator.comparingInt(x -> x[1])); // int[]{현재위치, 코스트}
		queue.add(new int[]{startPoint, 0});

		while (!queue.isEmpty()) {
			int[] pointCost = new int[n + 1];
			Arrays.fill(pointCost, Integer.MAX_VALUE);
			pointCost[startPoint] = 0;

			int[] cur = queue.poll();
			int curPoint = cur[0];
			int curCost = cur[1];
			if (curPoint == endPoint) {
				System.out.println(curCost);
				tracing(curPoint, curCost, pointCost);
				return;
			}

			List<int[]> busWays = buses.get(curPoint);
			for (int[] busWay : busWays) {
				if (curCost + busWay[2] < pointCost[busWay[1]]) {
					pointCost[busWay[1]] = curCost + busWay[2];
					queue.add(new int[]{busWay[1], pointCost[busWay[1]]});
				}
			}
		}
	}

	private static void tracing(int curPoint, int curCost, int[] pointCost) {
		Stack<Integer> stack = new Stack<>();

		while (curPoint != startPoint) {
			List<int[]> busWays = buses.get(curPoint);
			for (int i = 0; i < busWays.size(); i++) {
				int[] busWay = busWays.get(i);
				if (pointCost[busWay[0]] == curCost - busWay[2]) {
					stack.add(busWay[0]);
					curCost = pointCost[busWay[0]];
					curPoint = busWay[0];
					break;
				}
			}
		}
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		buses = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			buses.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			buses.get(start).add(new int[]{start, end, cost});
		}
		st = new StringTokenizer(bf.readLine());
		startPoint = Integer.parseInt(st.nextToken());
		endPoint = Integer.parseInt(st.nextToken());
	}

}
