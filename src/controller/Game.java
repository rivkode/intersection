package controller;

import intersection.domain.Point;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static intersection.view.OutputView.*;
import static intersection.view.constant.StaticNotice.*;

/**
 * 용어정리
 *
 * 세로 : vertical
 * 가로 : horizontal
 */

public class Game {
    private static final double threshHold = 1;
    static List<Point> pointList;
    static int listSize;

    public static void main(String[] args) throws IOException {


        // 세로 직진 테스트 시작

        Game g = new Game();
        g.start();


    }

    public void start() throws IOException {
        printStaticNotice(GAME_START);
        printStaticNotice(CHOOSE_TYPE);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Point forGenerateData = new Point(0,0);

        int type = Integer.parseInt(br.readLine());
        int choose;

        switch (type) {
            case 1:
                pointList = forGenerateData.generateVerticalStraightDataSet();
                break;
            case 2:
                pointList = forGenerateData.generateVerticalRightDataSet();
                break;
            case 3:
                pointList = forGenerateData.generateHorizontalStraightDataSet();
                break;
            case 4:
                pointList = forGenerateData.generateHorizontalRightDataSet();
        }

        printStaticNotice(POINT_LIST);

        printPointList(pointList);



        listSize = pointList.size();
        boolean isStraight = true;

        // 리스트 시작점, 끝점으로 세로인지, 가로인지 판단
        Point vPStart = pointList.get(0);
        Point vPEnd = pointList.get(listSize - 1);
        boolean isHorizontal = direction(vPStart, vPEnd);

        // 세로라면 가로로 변경
        if (isHorizontal) {
            changePoint(pointList);
        }

        // 기울기 리스트
        List<Double> gradientNumbers = new ArrayList<>();

        for (int i = 0; i < listSize - 1; i++) {
            Point p1 = pointList.get(i);
            Point p2 = pointList.get(i + 1);

            double gradient = gradient(p1, p2);
            gradientNumbers.add(gradient);
        }

        Iterator<Double> itGradient = gradientNumbers.stream().iterator();

        // 기울기가 만약 1보다 크다면 우회전으로 간주
        while (itGradient.hasNext()) {
            if (itGradient.next() > threshHold) {
                isStraight = false;
            }
        }

        if (isStraight) {
            printStraight();
        } else {
            String ans = checkLeftOrRight(pointList);
            if (ans == "좌회전") {
                printLeft();
            } else if (ans == "우회전") {
                printRight();
            } else {
                System.out.println("오류가 발생하였습니다.");
            }
        }

        printStaticNotice(GAME_END);

        bw.flush();
        bw.close();

    }

    public String checkLeftOrRight(List<Point> points) {
        Point start = points.get(0);
        Point end = points.get(listSize - 1);

        // x값이 점점 작아지면 좌회전
        if (start.getX() > end.getX()) {
            return "좌회전";
        } else {
            return "우회전";
        }
    }

    // 기울기 계산
    public double gradient(Point p1, Point p2) {
        double x = p2.getX() - p1.getX();
        double y = p2.getY() - p1.getY();

        if (x == 0) {
            throw new RuntimeException("0일 수 없습니다.");
        }

        return y / x;
    }

    // 세로 변경
    public void changePoint(List<Point> points) {
        for (Point p : points) {
            p.changePoint();
        }
    }

    public boolean direction(Point start, Point end) {
        int xDifference = end.getX() - start.getX();
        int yDifference = end.getY() - start.getY();

        int x = Math.abs(xDifference);
        int y = Math.abs(yDifference);

        // y차이가 x차이보다 크다면 세로로 가는 것이므로 x, y 좌표를 바꿔준다
        if (y > x) {
            return true;
        }

        // 만약 x차이가 더 크다면 가로로 진행하므로 바꿔주지 않는다
        return false;
    }
}
