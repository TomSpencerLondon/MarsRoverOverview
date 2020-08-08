package com.codurance;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoverShould {

  private Rover rover;

  @BeforeEach
  void setUp() {
    Grid grid = new Grid();
    rover = new Rover(grid);
  }

  @ParameterizedTest
  @CsvSource({
      "R, 0:0:E",
      "RR, 0:0:S",
      "RRR, 0:0:W",
      "RRRR, 0:0:N"
  })
  void rotate_right(String input, String output) {
    assertEquals(output, rover.execute(input));
  }


  @ParameterizedTest
  @CsvSource({
      "L, 0:0:W",
      "LL, 0:0:S",
      "LLL, 0:0:E",
      "LLLL, 0:0:N"
  })
  void rotate_left(String input, String output) {
    assertEquals(output, rover.execute(input));
  }

  @ParameterizedTest
  @CsvSource({
      "M, 0:1:N",
      "MMM, 0:3:N"
  })
  void move_up(String input, String output) {
    assertEquals(output, rover.execute(input));
  }

  @ParameterizedTest
  @CsvSource({
      "MMMMMMMMMM, 0:0:N",
      "MMMMMMMMMMMMMMM, 0:5:N"
  })
  void wrap_from_top_to_bottom(String input, String output) {
    assertEquals(output, rover.execute(input));
  }

  @ParameterizedTest
  @CsvSource({
      "RM, 1:0:E",
      "RMMMMM, 5:0:E"
  })
  void move_right(String input, String output) {
    assertEquals(output, rover.execute(input));
  }

  @ParameterizedTest
  @CsvSource({
      "RMMMMMMMMMM, 0:0:E"
  })
  void wraps_from_right_to_left(String input, String output) {
    assertEquals(output, rover.execute(input));
  }

  @ParameterizedTest
  @CsvSource({
      "LM, 9:0:W",
      "LMMMMM, 5:0:W",
      "LMMMMMMMMMMMM, 8:0:W"
  })
  void move_left(String input, String output) {
    assertEquals(output, rover.execute(input));
  }

  @ParameterizedTest
  @CsvSource({
      "RRM, 0:9:S",
      "RRMMMMM, 0:5:S",
      "RRMMMMMMMMMMM, 0:9:S"
  })
  void move_south(String input, String output) {
    assertEquals(output, rover.execute(input));
  }

  @ParameterizedTest
  @CsvSource({
      "MMMM, 0:3:N"
  })
  void stops_at_obstacle(String input, String output) {
    Coordinate obstacle = new Coordinate(0, 4);
    Grid oGrid = new Grid(asList(obstacle));
    Rover oRover = new Rover(oGrid);

    assertEquals(output, oRover.execute(input));
  }
}
