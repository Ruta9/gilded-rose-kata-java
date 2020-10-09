package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonRulesTests {

    @Test
    void qualityCannotExceed50() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50),
                new Item("Aged Brie", 5, 50),
                new Item("Aged Brie", -2, 50)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
    }

    @Test
    void qualityCannotBeNegative() {
        Item[] items = new Item[] {
                new Item("Random item", 5, 0),
                new Item("Random item", -1, 0),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void qualityDecreasesTwiceAsFastWhenSellInDateHasPassed() {
        Item[] items = new Item[] {
                new Item("Random item", -1, 5)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }
}
