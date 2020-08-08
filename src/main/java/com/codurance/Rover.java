package com.codurance;

public class Rover {

  Direction direction = Direction.NORTH;

  public String execute(String commands) {
    for (char c : commands.toCharArray()) {
      if (c == 'R') {
        direction = direction.right();

      } else if (c == 'L') {
        direction = direction.left();
      }

    }

    return "0:0:" + direction.value;
  }

}
