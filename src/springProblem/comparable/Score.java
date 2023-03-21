package springProblem.comparable;

public class Score implements Comparable<Score>{

	private int point;

	public Score(int point) {
		this.point = point;
	}


	// 이 부분 뭐로 구현되는지
	@Override
	public int compareTo(Score o) {

		return 0;
	}
}
