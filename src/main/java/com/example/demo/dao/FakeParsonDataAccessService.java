package com.example.demo.dao;


import com.example.demo.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FakeParsonDataAccessService implements PersonDao {

    private static List<Person> dB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        dB.add(new Person(id, person.getName()));
        return 1;
    }
}
