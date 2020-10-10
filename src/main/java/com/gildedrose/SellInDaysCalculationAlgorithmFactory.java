package com.gildedrose;

import com.gildedrose.sellinstrategy.DefaultSellInCalculation;
import com.gildedrose.sellinstrategy.NoChangeInSellInDays;
import com.gildedrose.sellinstrategy.SellInDaysCalculationStrategy;


public class SellInDaysCalculationAlgorithmFactory {

    public SellInDaysCalculationStrategy getAlgorithm (ItemType itemType){

        switch(itemType){
            case SULFURAS:
                return new NoChangeInSellInDays();
            default:
                return new DefaultSellInCalculation();
        }

    }
}
