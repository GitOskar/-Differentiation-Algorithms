package sample.alghoritm;

import sample.alghoritm.base.BaseEngRunGillKutt;
import sample.example.exampleEnum.Example;

public class England extends BaseEngRunGillKutt {

    public England(double x0, double y0, Example example) {
        super(x0, y0, example);
    }

    @Override
    public String getTitle() {
        return "England method";
    }

    @Override
    protected double deltaY(double xn, double yn, double h)
    {
        double k1 = h * function(xn, yn);
        double k2 = h * function(xn + h/2, yn + k1/2);
        double k3 = h * function(xn + h/2, yn + k1/4 + k2/4);
        double k4 = h * function(xn + h, yn - k2 + 2*k3);

        return (k1 + 4*k3 + k4) / 6;
    }
}
