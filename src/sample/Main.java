/*
* Oskar Wołosiuk
* */

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
import sample.example.ExampleCreator;
import sample.example.exampleEnum.Example;
import sample.factory.algorithmEnum.AlgorithmEnum;

public class Main extends Application {

    final private double h = 1.0, step = 0.001;
    private double hTmp = h;

    @Override
    public void start(Stage stage) {
        final Example example = Example.EXAMPLE2;
        final AlgorithmEnum algorithmEnum = AlgorithmEnum.RUNGE_KUTTA;

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series();
        RecordHolder recordHolder = new RecordHolder();
        ExampleCreator exampleCreator = new ExampleCreator(xAxis, yAxis, lineChart, series, recordHolder, example, algorithmEnum, h, step);
        AlgorithmInterface algorithm = exampleCreator.createExamples();

        lineChart.setTitle(algorithm.getTitle());
        for (Point2D point : recordHolder.getNext())
            series.getData().add(new XYChart.Data(point.getX(), point.getY()));

        Timeline timeLine = new Timeline();
        timeLine.getKeyFrames().add(new KeyFrame(Duration.millis(10),
                actionEvent -> {
                    reDraw(recordHolder, series, lineChart, hTmp);
                    hTmp -= step;
                    if (hTmp < 0)
                        hTmp = h - step;
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

    private void reDraw(RecordHolder recordHolder, XYChart.Series series, LineChart lineChart, double h)
    {
        series = new XYChart.Series();
        for (Point2D point : recordHolder.getNext())
            series.getData().add(new XYChart.Data(point.getX(), point.getY()));

        series.setName("H: " + String.format("%.3f", h));
        lineChart.getData().remove(0);
        lineChart.getData().addAll(series);
    }
}