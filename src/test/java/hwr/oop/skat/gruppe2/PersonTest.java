package hwr.oop.skat.gruppe2;

import hwr.oop.skat.gruppe2.domain.Person;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class PersonTest {

    @Test
    void testLadePersonUUID() {
        UUID uuid = UUID.randomUUID();

        Person testPerson = new Person(uuid, "Person", 0, 0);

        Assertions.assertThat(testPerson.getUuid()).isEqualTo(uuid);
    }

    @Test
    void testLadePersonName() {
        Person testPerson = new Person(UUID.randomUUID(), "John Doe", 0, 0);

        Assertions.assertThat(testPerson.getName()).isEqualTo("John Doe");
    }

    @Test
    void testLadePersonGewonneneRunden() {
        int JohnSiege = 1;

        Person testPerson = new Person(UUID.randomUUID(), "John Doe", JohnSiege, 0);

        Assertions.assertThat(testPerson.getGewonneneRunden()).isEqualTo(JohnSiege);
    }

    @Test
    void testLadePersonVerloreneRunden() {
        int JohnSpiele = 1;

        Person testPerson = new Person(UUID.randomUUID(), "John Doe", 0, JohnSpiele);

        Assertions.assertThat(testPerson.getGespielteRunden()).isEqualTo(JohnSpiele);
    }

    @Test
    void testPersonName() {
        Person testPerson = new Person("Spieler");
        Assertions.assertThat(testPerson.getName()).isEqualTo("Spieler");
    }

    @Test
    void testPersonGespielt() {
        Person testPerson = new Person("Spieler");
        Assertions.assertThat(testPerson.getGespielteRunden()).isZero();
    }

    @Test
    void testSpielerGewonnen() {
        Person testPerson = new Person("Spieler");
        Assertions.assertThat(testPerson.getGewonneneRunden()).isZero();
    }
}
