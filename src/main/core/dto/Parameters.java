package main.core.dto;

import java.util.ArrayList;
import java.util.List;

public class Parameters {

    private int packSize = 0;
    private int itemsAmount = 0;

    private List<Integer> sizes = new ArrayList<>();
    private List<Integer> prices = new ArrayList<>();
    private List<String> itemsNames = new ArrayList<>();

    public Parameters() {
    }

    public Parameters(int packSize, int itemsAmount) {
        this.itemsAmount = itemsAmount;
        this.packSize = packSize;
    }

    public List<String> getItemsNames() {
        return itemsNames;
    }

    public void setItemsNames(List<String> itemsNames) {
        this.itemsNames = itemsNames;
    }

    public int getPackSize() {
        return packSize;
    }

    public void setPackSize(int packSize) {
        this.packSize = packSize;
    }

    public int getItemsAmount() {
        return itemsAmount;
    }

    public void setItemsAmount(int itemsAmount) {
        this.itemsAmount = itemsAmount;
    }

    public List<Integer> getSizes() {
        return sizes;
    }

    public void setSizes(List<Integer> sizes) {
        this.sizes = sizes;
    }

    public List<Integer> getPrices() {
        return prices;
    }

    public void setPrices(List<Integer> prices) {
        this.prices = prices;
    }

}
