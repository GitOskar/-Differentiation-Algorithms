package sample.alghoritm.base;

import sample.example.exampleEnum.Example;

public abstract class BaseAlgorithm {
    protected Example example;

    public BaseAlgorithm(Example example) {
        this.example = example;
    }

    protected double function(double x, double y)
    {
        switch (example){
            case EXAMPLE1: return y;
            case EXAMPLE2: return 1 + 2 * x * y;
            case EXAMPLE3: return x / (1 + y * y) + 2 * y;
        }
        throw new NullPointerException("Function not found");
    }
}
