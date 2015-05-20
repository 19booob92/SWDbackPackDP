package main.core.dto;

import java.util.ArrayList;
import java.util.List;


public class Parameters {

    private int packSize = 0;
    private int itemsAmount = 0;

    private List<String> sizes = new ArrayList<>();
    private List<String> prices = new ArrayList<>();

    public Parameters() {
    }
    
    public Parameters(int packSize, int itemsAmount) {
        this.itemsAmount = itemsAmount;
        this.packSize = packSize;
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

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public List<String> getPrices() {
        return prices;
    }

    public void setPrices(List<String> prices) {
        this.prices = prices;
    }


}
