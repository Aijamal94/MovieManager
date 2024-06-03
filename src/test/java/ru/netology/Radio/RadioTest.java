package ru.netology.Radio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {
    private Radio radio;

    @BeforeEach
    public void setUp() {
        radio = new Radio();
    }

    // Тесты для метода setCurrentStation
    @Test
    public void testSetCurrentStationLowerBound() {
        radio.setCurrentStation(0);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationUpperBound() {
        radio.setCurrentStation(9);
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationBelowLowerBound() {
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationAboveUpperBound() {
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation());
    }

    // Тесты для метода nextStation
    @Test
    public void testNextStationAtUpperBound() {
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testNextStationBelowUpperBound() {
        radio.setCurrentStation(8);
        radio.nextStation();
        assertEquals(9, radio.getCurrentStation());
    }

    // Тесты для метода prevStation
    @Test
    public void testPrevStationAtLowerBound() {
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationAboveLowerBound() {
        radio.setCurrentStation(1);
        radio.prevStation();
        assertEquals(0, radio.getCurrentStation());
    }

    // Тесты для метода setCurrentVolume
    @Test
    public void testSetCurrentVolumeLowerBound() {
        radio.setCurrentVolume(0);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testSetCurrentVolumeUpperBound() {
        radio.setCurrentVolume(100);
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testSetCurrentVolumeBelowLowerBound() {
        radio.setCurrentVolume(-1);
        assertEquals(50, radio.getCurrentVolume()); // предполагаемое значение по умолчанию 50
    }

    @Test
    public void testSetCurrentVolumeAboveUpperBound() {
        radio.setCurrentVolume(101);
        assertEquals(50, radio.getCurrentVolume()); // предполагаемое значение по умолчанию 50
    }

    // Тесты для метода increaseVolume
    @Test
    public void testIncreaseVolumeAtUpperBound() {
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testIncreaseVolumeBelowUpperBound() {
        radio.setCurrentVolume(99);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    // Тесты для метода decreaseVolume
    @Test
    public void testDecreaseVolumeAtLowerBound() {
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeAboveLowerBound() {
        radio.setCurrentVolume(1);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }
}
