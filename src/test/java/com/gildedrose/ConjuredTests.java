package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConjuredTests {

    @Test
    void degradeInQualityTwiceAsFast_BeforeSellInEnds() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 2, 5) };
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    void degradeInQualityTwiceAsFast_AfterSellInEnds() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", -1, 5) };
        GildedRose app = new GildedRose(items);
        app.update();
        assertEquals(1, app.items[0].quality);
    }
}
