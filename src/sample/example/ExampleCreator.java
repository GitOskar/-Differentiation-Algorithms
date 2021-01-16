package sample.example;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import sample.alghoritm.RecordHolder;
import sample.alghoritm.base.AlgorithmInterface;
import sample.example.exampleEnum.Example;
import sample.factory.AlgorithmFactory;
import sample.factory.algorithmEnum.AlgorithmEnum;

public class ExampleCreator
{
    NumberAxis xAxis;
    NumberAxis yAxis;
    LineChart<Number, Number> lineChart;
    XYChart.Series<Number, Number> series;
    RecordHolder recordHolder;
    Example example;
    AlgorithmEnum algorithmEnum;
    double h;
    double step;

    public ExampleCreator(
            NumberAxis xAxis, NumberAxis yAxis, LineChart<Number,
            Number> lineChart, XYChart.Series<Number, Number> series,
            RecordHolder recordHolder, Example example, AlgorithmEnum algorithmEnum,
            double h, double step) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.lineChart = lineChart;
        this.series = series;
        this.recordHolder = recordHolder;
        this.example = example;
        this.algorithmEnum = algorithmEnum;
        this.h = h;
        this.step = step;
    }

    public AlgorithmInterface createExamples()
    {
        switch (example)
        {
            case EXAMPLE1:
                return exampleInit1();
            case EXAMPLE2:
                return exampleInit2();
            case EXAMPLE3:
                return exampleInit3();
            default:
                throw new NullPointerException("Example not found");
        }
    }

    private AlgorithmInterface exampleInit1()
    {
        init();
        xAxis.setLowerBound(0.0);
        xAxis.setUpperBound(4.0);
        yAxis.setUpperBound(60.0);
        yAxis.setLowerBound(0.0);
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        AlgorithmInterface algorithm = algorithmFactory.createAlgorithm(algorithmEnum, 0, 1, Example.EXAMPLE1);
        recordHolder.createSeries(algorithm, h, 0.001, 4.0, step);
        return algorithm;
    }

    private AlgorithmInterface exampleInit2()
    {
        init();
        xAxis.setLowerBound(0.0);
        xAxis.setUpperBound(2.0);
        yAxis.setUpperBound(250.0);
        yAxis.setLowerBound(0.0);
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        AlgorithmInterface algorithm = algorithmFactory.createAlgorithm(algorithmEnum, 0, 3, Example.EXAMPLE2);
        recordHolder.createSeries(algorithm, h, 0.001, 2.0, step);
        return algorithm;
    }

    private AlgorithmInterface exampleInit3()
    {
        init();
        xAxis.setLowerBound(0.0);
        xAxis.setUpperBound(2.0);
        yAxis.setUpperBound(150.0);
        yAxis.setLowerBound(0.0);
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        AlgorithmInterface algorithm = algorithmFactory.createAlgorithm(algorithmEnum, 0, 2, Example.EXAMPLE3);
        recordHolder.createSeries(algorithm, h, 0.001, 2.0, step);
        return algorithm;
    }

    private void init()
    {
        lineChart.setCreateSymbols(false);
        lineChart.setAnimated(false);
        xAxis.setAutoRanging(false);
        yAxis.setAutoRanging(false);
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
    }
}
