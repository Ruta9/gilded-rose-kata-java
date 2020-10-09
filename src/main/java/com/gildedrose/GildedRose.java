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
        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case "Sulfuras, Hand of Ragnaros":
                    break;
                case "Aged Brie":
                    items[i].quality = new DefaultQualityIncreasing().calculate(items[i].sellIn, items[i].quality);
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    items[i].quality = new BackstagePassesQuality().calculate(items[i].sellIn, items[i].quality);
                    break;
                default:
                    items[i].quality = new DefaultQualityDecreasing().calculate(items[i].sellIn, items[i].quality);
            }

            if (items[i].name != "Sulfuras, Hand of Ragnaros") items[i].sellIn = items[i].sellIn - 1;

        }
    }
}