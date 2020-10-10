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

            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Aged Brie":
                    item.quality = new DefaultQualityIncreasing().calculate(item.sellIn, item.quality);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality = new BackstagePassesQuality().calculate(item.sellIn, item.quality);
                    break;
                default:
                    item.quality = new DefaultQualityDecreasing().calculate(item.sellIn, item.quality);
            }



        }
    }
}