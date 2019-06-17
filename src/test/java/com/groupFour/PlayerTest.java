package com.groupFour;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

    @Test
    public void getNameTest() {
            Player player = new Player();
            // Given (a name exists and a dog exists)
            String givenName = "Anish Patel";
            // When (a dog's name is set to the given name)
            player.setName(givenName);
            // Then (we expect to get the given name from the dog)
            String name = player.getName();
            Assert.assertEquals(givenName, name);
        }

    @Test
    public void setNameTest() {
        Player player = new Player();
        // Given (a name exists and a dog exists)
        String givenName = "Anish Patel";
        // When (a dog's name is set to the given name)
        player.setName(givenName);
        // Then (we expect to get the given name from the dog)
        String name = player.getName();
        Assert.assertEquals(givenName, name);
    }

    @Test
    public void setNameTest2() {
        Player player = new Player();
        // Given (a name exists and a dog exists)
        //String givenName;
        // When (a dog's name is set to the given name)
        //player.setName();
        // Then (we expect to get the given name from the dog)
        //String name = player.getName();
        Assert.assertEquals(player.getName(), "Player 1");
    }
}