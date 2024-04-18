package domain;

import java.util.ArrayList;
import java.util.List;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void changePoint() {
        int tmp = this.x;
        this.x = this.y;
        this.y = tmp;
    }

    public List<Point> generateVerticalStraightDataSet() {
        List<Point> verticalStraightPointList = new ArrayList<>();

        /**
         * 세로 데이터 셋
         */
        // 세로 직진 Point 만들기
        int v = 3;
        for (int i = 0; i < 15; i++) {
            Point p = new Point(50, v);
            verticalStraightPointList.add(p);
            v += 6;
        }

        return verticalStraightPointList;
    }

    public static List<Point> generateVerticalRightDataSet() {
        List<Point> verticalRightPointList = new ArrayList<>();

        // 세로 우회전 Point 만들기
        Point pv1 = new Point(50, 1);
        Point pv2 = new Point(55, 10);
        Point pv3 = new Point(60, 15);
        Point pv4 = new Point(65, 20);
        Point pv5 = new Point(70, 25);
        Point pv6 = new Point(75, 30);
        Point pv7 = new Point(80, 35);
        Point pv8 = new Point(85, 40);
        Point pv9 = new Point(90, 45);
        Point pv10 = new Point(100, 50);

        // add
        verticalRightPointList.add(pv1);
        verticalRightPointList.add(pv2);
        verticalRightPointList.add(pv3);
        verticalRightPointList.add(pv4);
        verticalRightPointList.add(pv5);
        verticalRightPointList.add(pv6);
        verticalRightPointList.add(pv7);
        verticalRightPointList.add(pv8);
        verticalRightPointList.add(pv9);
        verticalRightPointList.add(pv10);

        return verticalRightPointList;

    }

    public static List<Point> generateHorizontalStraightDataSet() {
        List<Point> horizontalStraightPointList = new ArrayList<>();
        /**
         * 가로 데이터 셋
         */

        // 가로 직진 Point 만들기
        int h = 3;
        for (int i = 0; i < 15; i++) {
            Point p = new Point(h, 50);
            horizontalStraightPointList.add(p);
            h += 6;
        }
        return horizontalStraightPointList;
    }

    public static List<Point> generateHorizontalRightDataSet() {
        List<Point> horizontalRightPointList = new ArrayList<>();

        // 가로 좌회전 Point 만들기
        Point ph1 = new Point(1, 50);
        Point ph2 = new Point(10, 55);
        Point ph3 = new Point(15, 60);
        Point ph4 = new Point(20, 65);
        Point ph5 = new Point(25, 70);
        Point ph6 = new Point(30, 75);
        Point ph7 = new Point(35, 80);
        Point ph8 = new Point(40, 85);
        Point ph9 = new Point(45, 90);
        Point ph10 = new Point( 50, 100);

        // add
        horizontalRightPointList.add(ph1);
        horizontalRightPointList.add(ph2);
        horizontalRightPointList.add(ph3);
        horizontalRightPointList.add(ph4);
        horizontalRightPointList.add(ph5);
        horizontalRightPointList.add(ph6);
        horizontalRightPointList.add(ph7);
        horizontalRightPointList.add(ph8);
        horizontalRightPointList.add(ph9);
        horizontalRightPointList.add(ph10);

        return horizontalRightPointList;
    }
}
