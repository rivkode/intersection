package controller;


import domain.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static view.OutputView.*;
import static view.constant.StaticNotice.*;


public class GameV2 {
    private static final double THRESHOLD = 1;

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.start();
    }

    public void start() throws IOException {
        printStaticNotice(GAME_START);
        printStaticNotice(CHOOSE_TYPE);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int type = Integer.parseInt(br.readLine());
        List<Point> pointList = generatePointList(type);

        printStaticNotice(POINT_LIST);
        printPointList(pointList);

        boolean isHorizontal = checkAndAdjustDirection(pointList);

        List<Double> gradientNumbers = calculateGradient(pointList);

        boolean isStraight = checkIsStraight(gradientNumbers);

        printResult(isStraight, pointList);
    }

    private List<Point> generatePointList(int type) {
        Point forGenerateData = new Point(0, 0);
        switch (type) {
            case 1:
                return forGenerateData.generateVerticalStraightDataSet();
            case 2:
                return forGenerateData.generateVerticalRightDataSet();
            case 3:
                return forGenerateData.generateHorizontalStraightDataSet();
            case 4:
                return forGenerateData.generateHorizontalRightDataSet();
            default:
                throw new IllegalArgumentException("Unexpected type: " + type);
        }
    }

    private boolean checkAndAdjustDirection(List<Point> points) {
        Point start = points.get(0);
        Point end = points.get(points.size() - 1);
        return direction(start, end, points);
    }

    private boolean direction(Point start, Point end, List<Point> points) {
        int xDifference = end.getX() - start.getX();
        int yDifference = end.getY() - start.getY();
        int x = Math.abs(xDifference);
        int y = Math.abs(yDifference);
        return y > x;
    }

    private List<Double> calculateGradient(List<Point> points) {
        List<Double> gradientNumbers = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            double gradient = calculateGradient(p1, p2);
            gradientNumbers.add(gradient);
        }
        return gradientNumbers;
    }

    private double calculateGradient(Point p1, Point p2) {
        double x = p2.getX() - p1.getX();
        double y = p2.getY() - p1.getY();
        if (x == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return y / x;
    }

    private boolean checkIsStraight(List<Double> gradientNumbers) {
        for (Double gradient : gradientNumbers) {
            if (gradient > THRESHOLD) {
                return false;
            }
        }
        return true;
    }

    private void printResult(boolean isStraight, List<Point> pointList) {
        if (isStraight) {
            printStraight();
        } else {
            String direction = checkLeftOrRight(pointList);
            if (direction.equals("좌회전")) {
                printLeft();
            } else if (direction.equals("우회전")) {
                printRight();
            } else {
                throw new IllegalStateException("Invalid direction: " + direction);
            }
        }
        printStaticNotice(GAME_END);
    }

    private String checkLeftOrRight(List<Point> points) {
        Point start = points.get(0);
        Point end = points.get(points.size() - 1);
        return start.getX() > end.getX() ? "좌회전" : "우회전";
    }
}