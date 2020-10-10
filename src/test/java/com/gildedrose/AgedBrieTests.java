package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgedBrieTests {

    @Test
    void increasesInQuality() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 1) };
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void increasesInQualityTwoTimesAsFastWhenSellInDateHasPassed() {
        Item[] items = new Item[] { new Item("Aged Brie", -5, 1) };
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(3, app.items[0].quality);
    }

}
