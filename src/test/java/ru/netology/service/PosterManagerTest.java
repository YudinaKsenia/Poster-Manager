package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.service.PosterManager;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerTest {

    PosterManager manager = new PosterManager();

    @Test

    public void testAddNoMovie() {

        String[] expected = { };
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals( expected, actual);
    }

    @Test

    public void testAddOneMovie() {

        manager.addMovie("Bloodshot");

        String[] expected = { "Bloodshot" };
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals( expected, actual);
    }

    @Test

    public void testAddFewMovies() {

        manager.addMovie("Bloodshot");
        manager.addMovie("Onward");
        manager.addMovie("Belgrade Hotel");
        manager.addMovie("The Gentlemen");
        manager.addMovie("The Invisible Man");
        manager.addMovie("Trolls");
        manager.addMovie("Number 1");

        String[] expected = { "Bloodshot", "Onward","Belgrade Hotel", "The Gentlemen", "The Invisible Man", "Trolls", "Number 1" };
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals( expected, actual);
    }

    @Test

    public void testFindLastUnderLimit() {

        manager.addMovie("Bloodshot");
        manager.addMovie("Onward");
        manager.addMovie("Belgrade Hotel");


        String[] expected = { "Belgrade Hotel", "Onward", "Bloodshot" };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals( expected, actual);
    }

    @Test

    public void testFindLastOverLimit() {

        manager.addMovie("Bloodshot");
        manager.addMovie("Onward");
        manager.addMovie("Belgrade Hotel");
        manager.addMovie("The Gentlemen");
        manager.addMovie("The Invisible Man");
        manager.addMovie("Trolls");
        manager.addMovie("Number 1");


        String[] expected = { "The Invisible Man", "The Gentlemen","Belgrade Hotel", "Onward", "Bloodshot" };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals( expected, actual);
    }

    @Test

    public void testFindLastEqualLimit() {

        manager.addMovie("Bloodshot");
        manager.addMovie("Onward");
        manager.addMovie("Belgrade Hotel");
        manager.addMovie("The Gentlemen");
        manager.addMovie("The Invisible Man");


        String[] expected = { "The Invisible Man", "The Gentlemen","Belgrade Hotel", "Onward", "Bloodshot"  };
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals( expected, actual);
    }
}