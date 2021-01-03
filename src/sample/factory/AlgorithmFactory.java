package sample.factory;

import sample.alghoritm.base.AlgorithmInterface;
import sample.alghoritm.England;
import sample.alghoritm.Euler;
import sample.alghoritm.RungeKutta;
import sample.alghoritm.RungeKuttaGill;
import sample.factory.algorithmEnum.AlgorithmEnum;

public class AlgorithmFactory {

    public AlgorithmInterface createAlgorithm(AlgorithmEnum algorithm, double x0, double y0)
    {
        switch (algorithm){
            case EULER: return new Euler(x0, y0);
            case RUNGE_KUTTA: return new RungeKutta(x0, y0);
            case ENGLAND: return new England(x0, y0);
            case RUNGE_KUTTA_GILL: return new RungeKuttaGill(x0, y0);
        }
        throw new NullPointerException("Algorithm not set");
    }

}
