package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.alghoritm.base.AlgorithmInterface;
import sample.alghoritm.RecordHolder;
import sample.alghoritm.base.Example;
import sample.factory.AlgorithmFactory;
import sample.factory.algorithmEnum.AlgorithmEnum;

public class Main extends Application {

    static double h = 1.0, step = 0.001, htmp = h;

    @Override
    public void start(Stage stage) {
        final Example example = Example.EXAMPLE3;
        final AlgorithmEnum algorithmEnum = AlgorithmEnum.ENGLAND;

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series();
        RecordHolder recordHolder = new RecordHolder();
        AlgorithmInterface algorithm = null;
        switch (example)
        {
            case EXAMPLE1:
                algorithm = exampleInit1(lineChart, xAxis, yAxis, recordHolder, algorithmEnum);
                break;
            case EXAMPLE2:
                algorithm = exampleInit2(lineChart, xAxis, yAxis, recordHolder, algorithmEnum);
                break;
            case EXAMPLE3:
                algorithm = exampleInit3(lineChart, xAxis, yAxis, recordHolder, algorithmEnum);
                break;
            default:
                throw new NullPointerException("Example not found");
        }

        lineChart.setTitle(algorithm.getTitle());
        for (Point2D point : recordHolder.getNext())
            series.getData().add(new XYChart.Data(point.getX(), point.getY()));

        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(new KeyFrame(Duration.millis(10),
                new EventHandler<ActionEvent>() {
                    @Override public void handle(ActionEvent actionEvent) {
                        reDraw(recordHolder, series, lineChart, htmp);
                        changeH();
                    }
                }));
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().addAll(series);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void init(LineChart<Number, Number> lineChart, NumberAxis xAxis, NumberAxis yAxis)
    {
        lineChart.setCreateSymbols(false);
        lineChart.setAnimated(false);
        xAxis.setAutoRanging(false);
        yAxis.setAutoRanging(false);
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
    }

    public void reDraw(RecordHolder recordHolder, XYChart.Series series, LineChart lineChart, double h)
    {
        series = new XYChart.Series();
        for (Point2D point : recordHolder.getNext())
            series.getData().add(new XYChart.Data(point.getX(), point.getY()));

        series.setName("H: " + String.format("%.3f", h));
        lineChart.getData().remove(0);
        lineChart.getData().addAll(series);
    }

    public static void changeH()
    {
        htmp -= step;
        if (htmp < 0)
            htmp = h;
    }

    public AlgorithmInterface exampleInit1(LineChart<Number, Number> lineChart, NumberAxis xAxis, NumberAxis yAxis, RecordHolder recordHolder, AlgorithmEnum algorithmEnum)
    {
        init(lineChart, xAxis, yAxis);
        xAxis.setLowerBound(0.0);
        xAxis.setUpperBound(4.0);
        yAxis.setUpperBound(60.0);
        yAxis.setLowerBound(0.0);
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        AlgorithmInterface algorithm = algorithmFactory.createAlgorithm(AlgorithmEnum.EULER, 0, 1, Example.EXAMPLE1);
        recordHolder.createSeries(algorithm, h, 0.001, 4.0, step);
        return algorithm;
    }

    public AlgorithmInterface exampleInit2(LineChart<Number, Number> lineChart, NumberAxis xAxis, NumberAxis yAxis, RecordHolder recordHolder, AlgorithmEnum algorithmEnum)
    {
        init(lineChart, xAxis, yAxis);
        xAxis.setLowerBound(0.0);
        xAxis.setUpperBound(2.0);
        yAxis.setUpperBound(250.0);
        yAxis.setLowerBound(0.0);
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        AlgorithmInterface algorithm = algorithmFactory.createAlgorithm(AlgorithmEnum.EULER, 0, 3, Example.EXAMPLE2);
        recordHolder.createSeries(algorithm, h, 0.001, 2.0, step);
        return algorithm;
    }

    public AlgorithmInterface exampleInit3(LineChart<Number, Number> lineChart, NumberAxis xAxis, NumberAxis yAxis, RecordHolder recordHolder, AlgorithmEnum algorithmEnum)
    {
        init(lineChart, xAxis, yAxis);
        xAxis.setLowerBound(0.0);
        xAxis.setUpperBound(2.0);
        yAxis.setUpperBound(150.0);
        yAxis.setLowerBound(0.0);
        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        AlgorithmInterface algorithm = algorithmFactory.createAlgorithm(AlgorithmEnum.EULER, 0, 2, Example.EXAMPLE3);
        recordHolder.createSeries(algorithm, h, 0.001, 2.0, step);
        return algorithm;
    }
}