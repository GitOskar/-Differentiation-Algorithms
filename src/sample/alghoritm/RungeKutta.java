package sample.alghoritm;

import sample.alghoritm.base.BaseEngRunGillKutt;

/*
Runge-Kutta method of the 4th row
 */
public class RungeKutta extends BaseEngRunGillKutt
{
    public RungeKutta(double x0, double y0) {
        super(x0, y0);
    }

    @Override
    public String getTitle()
    {
        return "Differentiation by Runge-Kutta method";
    }

    @Override
    protected double deltaY(double xn, double yn, double h)
    {
        double k1 = h * function(xn, yn);
        double k2 = h * function(xn + h/2, yn + k1/2);
        double k3 = h * function(xn + h/2, yn + k2/2);
        double k4 = h * function(xn + h, yn + k3);

        return (k1 + 2*k2 + 2*k3 + k4) / 6;
    }
}
