package ru.netology.Radio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    private Radio radio;

    @BeforeEach
    public void setUp() {
        radio = new Radio();
    }

    @Test
    public void testSetCurrentStationValid() {
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());
    }

    @Test
    public void testSetCurrentStationInvalid() {
        radio.setCurrentStation(10);
        assertEquals(0, radio.getCurrentStation()); // Номер станции не изменится, так как 10 недопустимое значение
    }

    @Test
    public void testNextStation() {
        radio.setCurrentStation(9);
        radio.nextStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testNextStationNormal() {
        radio.setCurrentStation(8);
        radio.nextStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        radio.setCurrentStation(0);
        radio.prevStation();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testPrevStationNormal() {
        radio.setCurrentStation(1);
        radio.prevStation();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolume() {
        radio.setCurrentVolume(99);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testIncreaseVolumeMax() {
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolume() {
        radio.setCurrentVolume(1);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolumeMin() {
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testSetVolumeValid() {
        radio.setCurrentVolume(50);
        assertEquals(50, radio.getCurrentVolume());
    }

    @Test
    public void testSetVolumeInvalid() {
        radio.setCurrentVolume(150);
        assertEquals(50, radio.getCurrentVolume()); // предполагаемое значение по умолчанию 50
    }
}
