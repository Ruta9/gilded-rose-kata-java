package com.gildedrose;

import com.gildedrose.qualitycalculationtemplate.BackstagePassesQuality;
import com.gildedrose.qualitycalculationtemplate.DefaultQualityDecreasing;
import com.gildedrose.qualitycalculationtemplate.DefaultQualityIncreasing;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            ItemType itemType = ItemType.fromString(item.name);

            item.sellIn = new SellInDaysCalculationAlgorithmFactory()
                    .getAlgorithm(itemType)
                    .calculateSellInDays(item.sellIn);

            item.quality = new QualityCalculationAlgorithmFactory()
                    .getAlgorithm(itemType)
                    .calculate(item.sellIn, item.quality);

        }
    }
}