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

  enum Direction {
    NORTH("N", "W", "E"),
    EAST("E", "N", "S"),
    SOUTH("S", "E", "W"),
    WEST("W", "S", "N");

    private final String value;
    private final String left;
    private final String right;

    Direction(String value, String left, String right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }

    public Direction right() {
      return directionMatching(right);
    }

    public Direction left() {
      return directionMatching(left);
    }

    private Direction directionMatching(String value) {
      for (Direction direction : values()) {
        if (direction.value.equals(value)) {
          return direction;
        }
      }
      return null;
    }
  }
}
