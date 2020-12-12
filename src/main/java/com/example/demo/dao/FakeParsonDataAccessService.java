package com.example.demo.dao;


import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeParsonDataAccessService implements PersonDao {

    private static List<Person> dB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        dB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPerson() {
        return dB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return dB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
