package homeworks.hw7.entities;

import homeworks.enums.Colors;
import homeworks.enums.Metals;
import homeworks.enums.NatureElements;
import homeworks.enums.Vegs;

import static homeworks.enums.Colors.RED;
import static homeworks.enums.Metals.SELEN;
import static homeworks.enums.NatureElements.*;
import static homeworks.enums.Vegs.CUCUMBER;
import static homeworks.enums.Vegs.TOMATO;


public class MetalsAndColors {
    public int oddSum;
    public int evenSum;
    public NatureElements[] natureElements;
    public Colors color;
    public Metals metal;
    public Vegs[] vegetables;

    public static MetalsAndColors TEST_ENTITY = new MetalsAndColors(
            3, 8,
            new NatureElements[]{WATER, FIRE},
            RED, SELEN,
            new Vegs[]{CUCUMBER, TOMATO});

    public MetalsAndColors(int oddSum, int evenSum, NatureElements[] natureElements, Colors color, Metals metal, Vegs[] vegetables) {
        this.oddSum = oddSum;
        this.evenSum = evenSum;
        this.natureElements = natureElements;
        this.color = color;
        this.metal = metal;
        this.vegetables = vegetables;
    }
}