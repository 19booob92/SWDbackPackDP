package main.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import main.core.dto.Parameters;


public class InputDataProcessor {

    private static final int LINE_WITH_SIZES_NO = 0;
    private static final int LINE_WITH_WEIGHTS_NO = 1;
    private static final int LINE_WITH_PRICES_NO = 2;
    private static final int LINE_WITH_ITEMS_NAMES = 3;

    private static final int PACK_SIZE_POSITION = 1;
    private static final int ITEMS_AMOUNT_POSITION = 0;

    public Parameters processData(List<String> inputData) {

        Parameters parameters = new Parameters();

        String splitetFirstLine[] = inputData.get(LINE_WITH_SIZES_NO).split(" ");

        int backpackSize = Integer.valueOf(splitetFirstLine[PACK_SIZE_POSITION]);
        int itemsAmount = Integer.valueOf(splitetFirstLine[ITEMS_AMOUNT_POSITION]);

        parameters.setItemsAmount(itemsAmount);
        parameters.setPackSize(backpackSize);

        List<String> splittedPrices = Arrays.asList(inputData.get(LINE_WITH_PRICES_NO).split(","));
        List<Integer> pricesList = splittedPrices.stream().map(Integer::valueOf).collect(Collectors.toList());
        parameters.setPrices(pricesList);

        List<String> splitedSizes = Arrays.asList(inputData.get(LINE_WITH_WEIGHTS_NO).split(","));
        List<Integer> sizesList = splitedSizes.stream().map(Integer::valueOf).collect(Collectors.toList());
        parameters.setSizes(sizesList);

        List<String> splitedNames = Arrays.asList(inputData.get(LINE_WITH_ITEMS_NAMES).split(","));
        parameters.setItemsNames(splitedNames);
        

        return parameters;
    }

}
