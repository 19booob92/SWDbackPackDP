package test;

import java.util.List;

import main.core.dto.Parameters;
import main.utils.FileLoader;
import main.utils.InputDataProcessor;

import org.junit.Assert;
import org.junit.Test;


public class FileReadingTest {

    private InputDataProcessor inputDataProcessor = new InputDataProcessor();

    @Test
    public void shouldSetAllArguments() throws Exception {
        List<String> unporcessedData = FileLoader.readFile(getClass().getResource("wagi.txt").getPath());

        Parameters params = inputDataProcessor.processData(unporcessedData);

        Assert.assertEquals(5, params.getPackSize());
        Assert.assertEquals(6, params.getItemsAmount());

        Assert.assertEquals(2, (int) params.getSizes().get(0));
        Assert.assertEquals(7, (int) params.getPrices().get(0));
    }

    @Test
    public void shouldReadProperAmountOfData() throws Exception {
        List<String> unporcessedData = FileLoader.readFile(getClass().getResource("wagi.txt").getPath());

        Parameters params = inputDataProcessor.processData(unporcessedData);
        int itemsAmount = params.getItemsAmount();

        Assert.assertEquals(itemsAmount, params.getPrices().size());
        Assert.assertEquals(itemsAmount, params.getSizes().size());
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenFileDoesNotExists() throws Exception {
        List<String> unporcessedData = FileLoader.readFile(getClass().getResource("doesNotExistsFile.txt").getPath());
    }
}
