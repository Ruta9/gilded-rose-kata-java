package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonRulesTests {

    @Test
    void qualityCannotExceed50() {
        Item[] items = new Item[] {
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 25, 50),
                new Item("Aged Brie", 5, 50),
                new Item("Aged Brie", -2, 49)
        };
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(50, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
        assertEquals(50, app.items[3].quality);
        assertEquals(50, app.items[4].quality);
    }

    @Test
    void qualityCannotBeNegative() {
        Item[] items = new Item[] {
                new Item("Random item", 5, 0),
                new Item("Random item", -1, 0),
        };
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(0, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
    }

    @Test
    void qualityDecreasesTwiceAsFastWhenSellInDateHasPassed() {
        Item[] items = new Item[] {
                new Item("Random item", -1, 5)
        };
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(3, app.items[0].quality);
    }
}
