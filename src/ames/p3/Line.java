package ames.p3;

import ames.p3.Line.Point;
// Point 인스턴스 어떻게 Triangle 안에서 호출하냐??
class Line {

	public class Point {

		public int x, y;
	}
	public Point getPoint() {
		return new Point();
	}

}

class Triangle {

	public Triangle() {
		Point point = (new Line()).getPoint();
		Line.Point a = (new Line()).getPoint();
	}
}


