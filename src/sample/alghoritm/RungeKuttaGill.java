package sample.alghoritm;

import sample.alghoritm.base.BaseEngRunGillKutt;
import sample.example.exampleEnum.Example;

public class RungeKuttaGill extends BaseEngRunGillKutt {

    public RungeKuttaGill(double x0, double y0, Example example) {
        super(x0, y0, example);
    }

    @Override
    protected double deltaY(double xn, double yn, double h) {
        double k1 = h * function(xn, yn);
        double k2 = h * function(xn + h/2, yn + k1/2);
        double k3 = h * function(xn + h/2, yn + (Math.sqrt(2.0)-1.0) / 2.0 * k1 + (1.0-Math.sqrt(2.0)) / 2.0 * k2);
        double k4 = h * function(xn + h, yn - Math.sqrt(2.0) / 2 * k2 + (2 + Math.sqrt(2)) / 2 * k3);

        return (k1 + (2 - Math.sqrt(2)) * k2 + (2 + Math.sqrt(2)) * k3 + k4) / 6;
    }

    @Override
    public String getTitle() {
        return "Runge-Kutta-Gill method";
    }
}
