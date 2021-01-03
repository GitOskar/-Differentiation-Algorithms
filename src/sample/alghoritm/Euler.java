package sample.alghoritm;

import javafx.geometry.Point2D;
import sample.alghoritm.base.AlgorithmInterface;
import sample.alghoritm.base.BaseAlgorithm;
import sample.alghoritm.base.Example;

import java.util.ArrayList;
import java.util.List;

public class Euler extends BaseAlgorithm implements AlgorithmInterface
{
    private double x0, y0;

    public Euler(double x0, double y0, Example example)
    {
        super(example);
        this.x0 = x0;
        this.y0 = y0;
    }

    @Override
    public List<Point2D> createResults(double h, double border)
    {
        List<Point2D> points = new ArrayList<>();
        double y = y0, i = x0+h;
        points.add(new Point2D(x0, y0));

        for (; i<=border ; i+=h)
        {
            y += h * function(i, y, example);
            points.add(new Point2D(i, y));
        }

        /*
        Bonus record to fill the chart range
         */
        y += h * function(i, y, example);
        points.add(new Point2D(i, y));
        return points;
    }

    @Override
    public String getTitle()
    {
        return "Euler method";
    }
}
