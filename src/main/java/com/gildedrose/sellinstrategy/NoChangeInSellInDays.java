package com.gildedrose.sellinstrategy;

public class NoChangeInSellInDays implements SellInDaysCalculationStrategy{

    @Override
    public int calculateSellInDays(int sellIn) {
        return sellIn;
    }
}
