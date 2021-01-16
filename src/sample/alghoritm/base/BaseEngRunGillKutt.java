package sample.alghoritm.base;

import javafx.geometry.Point2D;
import sample.example.exampleEnum.Example;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEngRunGillKutt extends BaseAlgorithm implements AlgorithmInterface {

    protected double x0, y0;

    public BaseEngRunGillKutt(double x0, double y0, Example example) {
        super(example);
        this.x0 = x0;
        this.y0 = y0;
    }

    @Override
    public List<Point2D> createResults(double h, double border) {
        List<Point2D> points = new ArrayList<>();
        double y = y0, i = x0 + h;
        points.add(new Point2D(x0, y0));

        for (; i <= border; i += h) {
            y += deltaY(i, y, h);
            points.add(new Point2D(i, y));
        }

        /*
        Bonus record to fill the chart range
         */
        y += h * function(i, y);
        points.add(new Point2D(i, y));
        return points;
    }

    abstract protected double deltaY(double xn, double yn, double h);
}
