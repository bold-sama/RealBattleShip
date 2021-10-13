import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.Collections.unmodifiableList;

public enum Direction {
        NORTH, SOUTH, EAST, WEST;
        private static final List<Direction> VALUES = unmodifiableList(Arrays.asList(values()));
        private static final int SIZE = VALUES.size();
        private static final Random RANDOM = new Random();

        public static Direction randomDirection()  {
            return VALUES.get(RANDOM.nextInt(SIZE));
        }
    }
