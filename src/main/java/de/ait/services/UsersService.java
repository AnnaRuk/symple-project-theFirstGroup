package de.ait.services;

import de.ait.models.User;

import java.util.List;

public interface UsersService {
    List<String> getNames();

    String getLastNameOfMostAging();

    User createNewUser(String firstName, String lastName, int age, double height);



    int getAgeOfTallestPerson();

    double getAverageAge();
}
