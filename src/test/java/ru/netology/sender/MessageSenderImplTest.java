package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;


public class MessageSenderImplTest {


    // Тест с русским ID на русский ответ
    @Test
    public void testSendMessageToRussianUser() {
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp("172.0.32.11")).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        LocalizationServiceImpl localizationServiceImpl = new LocalizationServiceImpl();
        String preferences = localizationServiceImpl.locale(geoServiceImpl.byIp("172.0.32.11").getCountry());
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, preferences);

    }
    // Тест с анмериканским IP на американский ответ
    @Test
    public void testSendMessageToUSAUser() {
        GeoServiceImpl geoServiceImpl = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceImpl.byIp("96.44.183.149")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        LocalizationServiceImpl localizationServiceImpl = new LocalizationServiceImpl();
        String preferences = localizationServiceImpl.locale(geoServiceImpl.byIp("96.44.183.149").getCountry());
        String expected = "Welcome";
        Assertions.assertEquals(expected, preferences);

    }
    // Тест на проверку локации по IP, пришлось перепись метод equals в Location.

    @Test
    public void testLocationByIp() {
        GeoServiceImpl geoServiceImpl = Mockito.spy(GeoServiceImpl.class);
        //Сюда вбиваем проверяемую локацию
        Location location = new Location("Moscow", Country.RUSSIA, null, 0);
        //Сюда вбваем проверяемый IP
        String ip = "172.0.33.11";
        Assertions.assertEquals(location, geoServiceImpl.byIp(ip));
    }

    //Тест на проверку выводимого текста
    @Test
    public void testLocale() {
        LocalizationServiceImpl localizationServiceImpl = Mockito.spy(LocalizationServiceImpl.class);
        //Сюда вбиваем проверяемую локацию
        Location location = new Location("Moscow", Country.RUSSIA, null, 0);
        //Сюда вбиваем проверяемый текст
        String text = "Добро пожаловать";
        Assertions.assertEquals(text, localizationServiceImpl.locale(location.getCountry()));
    }



}