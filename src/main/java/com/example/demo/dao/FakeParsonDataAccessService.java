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
        Optional<Person> personToDelete = selectPersonById(id);
        //no user
        if (personToDelete.isEmpty()) {
            return 0;
        }
        dB.remove(personToDelete.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p -> {
            int index = dB.indexOf(p);
            if (index >= 0) {
                dB.set(index, new Person(id, person.getName()));
                return 1;
            }
            return 0;


        }).orElse(0);
    }
}
