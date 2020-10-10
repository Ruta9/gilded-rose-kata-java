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

            if (item.name != "Sulfuras, Hand of Ragnaros") item.sellIn = item.sellIn - 1;

            item.quality = new QualityCalculationAlgorithmFactory().getAlgorithm(item.name).calculate(item.sellIn, item.quality);



        }
    }
}