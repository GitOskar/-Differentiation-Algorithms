package sample.alghoritm;

import javafx.geometry.Point2D;
import sample.alghoritm.base.AlgorithmInterface;

import java.util.ArrayList;
import java.util.List;

public class RecordHolder
{
    private List<List<Point2D>> list;
    private int size;
    private int iterator;

    public RecordHolder()
    {
        list = new ArrayList<>();
        iterator = 0;
        size = 0;
    }

    public void createSeries(AlgorithmInterface algorithmInterface, double firstH, double lastH, double border, double step)
    {
        iterator = 0;
        size = 0;
        while (firstH >= lastH)
        {
            list.add(algorithmInterface.createResults(firstH, border));
            firstH -= step;
            size ++;
        }
    }

    public List<Point2D> getNext()
    {
        int iteratorTmp = iterator;
        iterator = (iterator+1)%size;
        return list.get(iteratorTmp);
    }

    public int size()
    {
        return size;
    }
}
