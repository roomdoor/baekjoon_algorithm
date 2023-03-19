package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class P11779 {

	static int n;
	static int m;
	static List<List<int[]>> buses;
	static List<List<int[]>> tracingMap;
	static int startPoint;
	static int endPoint;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		input();
		dijkstra();
	}

	private static void dijkstra() {
		PriorityQueue<Way> queue = new PriorityQueue<>();
		queue.add(new Way(startPoint, 0));
		int[] pointCost = new int[n + 1];
		Arrays.fill(pointCost, Integer.MAX_VALUE);
		pointCost[startPoint] = 0;

		while (!queue.isEmpty()) {

			Way cur = queue.poll();
			int curPoint = cur.curPoint;
			int curCost = cur.curCost;
			if (curPoint == endPoint) {
				StringBuilder sb = new StringBuilder();
				sb.append(curCost).append("\n");
				tracing(curPoint, curCost, pointCost, sb);
				System.out.println(sb);
				return;
			}

			List<int[]> busWays = buses.get(curPoint);
			for (int[] busWay : busWays) {
				if (curCost + busWay[2] < pointCost[busWay[1]]) {
					pointCost[busWay[1]] = curCost + busWay[2];
					queue.add(new Way(busWay[1], pointCost[busWay[1]]));
				}
			}
		}
	}

	private static void tracing(int curPoint, int curCost, int[] pointCost, StringBuilder sb) {
		Stack<Integer> stack = new Stack<>();
		stack.add(curPoint);
		while (curPoint != startPoint) {
			List<int[]> busWays = tracingMap.get(curPoint);
			for (int i = 0; i < busWays.size(); i++) {
				int[] busWay = busWays.get(i);
				if (pointCost[busWay[1]] == curCost - busWay[2]) {
					stack.add(busWay[1]);
					curCost = pointCost[busWay[1]];
					curPoint = busWay[1];
					break;
				}
			}
		}
		sb.append(stack.size()).append("\n");

		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}

	}

	private static class Way implements Comparable<Way> {

		int curPoint;
		int curCost;

		public Way(int curPoint, int curCost) {
			this.curPoint = curPoint;
			this.curCost = curCost;
		}

		@Override
		public int compareTo(Way o) {
			return this.curCost - o.curCost;
		}
	}

	private static void input() throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());
		buses = new ArrayList<>();
		tracingMap = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			buses.add(new ArrayList<>());
			tracingMap.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			buses.get(start).add(new int[]{start, end, cost});
			tracingMap.get(end).add(new int[]{end, start, cost});
		}
		st = new StringTokenizer(bf.readLine());
		startPoint = Integer.parseInt(st.nextToken());
		endPoint = Integer.parseInt(st.nextToken());
	}

}
