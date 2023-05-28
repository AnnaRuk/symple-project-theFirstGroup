package de.ait.services;

import static org.junit.jupiter.api.Assertions.*;

import de.ait.models.User;
import de.ait.repositories.UsersRepository;
import de.ait.repositories.UsersRepositoryListImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsersServiceImplTest {
private UsersServiceImpl usersService;

  @BeforeEach
  void setUp() {
    this.usersService = new UsersServiceImpl(new UsersRepositoryListImpl());

  }

  @Test
  void getNames() {
    List<String> actual = usersService.getNames();
    List<String> expected = Arrays.asList("User", "User1", "User2");
    assertEquals(expected,actual);
  }

@Test
void testGetLastNameOfMostAging(){
  String actual = usersService.getLastNameOfMostAging();
  String expected = "Petrov";
  assertEquals(expected,actual);
}
  @Test
 void getAverageAge() {
    double actual = usersService.getAverageAge();
    double expected = 25;
    assertEquals(expected,actual);
  }

@Test
void getAgeOfTallestPerson() {
  int actual = usersService.getAgeOfTallestPerson();
  int expected = 30;
  assertEquals(expected,actual);
}
@Test
  void testGetFullNameOfShortest() {
    String actual= usersService.getFullNameOfShortest();
    String expected = "Maxim Ivanov";

    assertEquals(expected, actual);
  }
}