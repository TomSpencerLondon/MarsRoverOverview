package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RoverShould {

  private Rover rover;

  @BeforeEach
  void setUp() {
    rover = new Rover();
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
  })
  void rotate_left(String input, String output) {
    assertEquals(output, rover.execute(input));
  }
}
