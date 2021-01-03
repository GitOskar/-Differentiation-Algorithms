package sample.alghoritm;

import sample.alghoritm.base.BaseEngRunGillKutt;
import sample.alghoritm.base.Example;

/*
Runge-Kutta method of the 4th row
 */
public class RungeKutta extends BaseEngRunGillKutt
{
    public RungeKutta(double x0, double y0, Example example) {
        super(x0, y0, example);
    }

    @Override
    public String getTitle()
    {
        return "Runge-Kutta method";
    }

    @Override
    protected double deltaY(double xn, double yn, double h)
    {
        double k1 = h * function(xn, yn, example);
        double k2 = h * function(xn + h/2, yn + k1/2, example);
        double k3 = h * function(xn + h/2, yn + k2/2, example);
        double k4 = h * function(xn + h, yn + k3, example);

        return (k1 + 2*k2 + 2*k3 + k4) / 6;
    }
}
