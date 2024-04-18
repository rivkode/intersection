package view;

import intersection.domain.Point;
import intersection.view.constant.StaticNotice;

import java.util.List;

public class OutputView {
    public static void printStaticNotice(StaticNotice notice) {
        System.out.println(notice.getMessage());
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPointList(List<Point> pointList) {
        for (int i = 0; i < pointList.size(); i++) {
            Point p = pointList.get(i);
            System.out.println("(x, y) = " + "(" + p.getX() + " : " + p.getY() + ")");
        }
    }

    public static void printStraight() {
        System.out.println("검증 결과는 ***직진*** 입니다.");
    }

    public static void printRight() {
        System.out.println("검증 결과는 ***우회전*** 입니다.");
    }

    public static void printLeft() {
        System.out.println("검증 결과는 ***좌회전*** 입니다.");
    }

}
