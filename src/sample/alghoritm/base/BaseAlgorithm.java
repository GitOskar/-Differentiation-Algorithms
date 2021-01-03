package sample.alghoritm.base;

public abstract class BaseAlgorithm {
    protected double function(double x, double y)
    {
        //return y;
        //return 1 + 2 * x * y;
        return x / (1 + y * y) + 2 * y;
    }
}
