package sample.alghoritm.base;

import javafx.geometry.Point2D;

import java.util.List;

public interface AlgorithmInterface {
    public List<Point2D> createResults(double h, double border);
    public String getTitle();
}
