package com.company;

import org.junit.Test;
import static org.junit.Assert.*;

    public class shotTest {

        @Test
        public void tesLegitShot() throws Exception {
            Shot shot = new Shot("D7");
            assertEquals(3, shot.getRow());
            assertEquals(6, shot.getColumn());
        }

        @Test
        public void testLowerCaseShot() throws Exception {
            Shot shot = new Shot("d7");
            assertEquals(3, shot.getRow());
            assertEquals(6, shot.getColumn());
        }

        @Test(expected = Exception.class)
        public void testTotallyBogusShot() throws Exception {
            Shot shot = new Shot("X20");
            assertEquals(3, shot.getRow());
            assertEquals(6, shot.getColumn());
        }

        @Test(expected = Exception.class)
        public void testSemiBogusShot() throws Exception {
            Shot shot = new Shot("Debby");
            assertEquals(3, shot.getRow());
            assertEquals(6, shot.getColumn());
        }
    }
