package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestAddMethodThenFalse() {
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("2f44a", "Petr Petrov Petrovich");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        boolean result = office.add(citizen2);
        assertThat(result).isFalse();
    }

    @Test
    public void whenTestGetMethodThenNull() {
        PassportOffice office = new PassportOffice();
        assertThat(office.get("fakePassport")).isNull();
    }
}