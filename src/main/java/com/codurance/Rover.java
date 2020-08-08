package com.codurance;

public class Rover {

  String direction = "N";

  Direction eDirection = Direction.NORTH;

  public String execute(String commands) {
    for (char c : commands.toCharArray()) {
      if (c == 'R'){
        direction = rotateRight();
      }else if (c == 'L'){
        direction = rotateLeft();
      }

    }

    return "0:0:" + direction;
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
  }

  private String rotateLeft() {
    if (direction.equals("N")){
      return "W";
    }else if (direction.equals("W")){
      return "S";
    }else if (direction.equals("S")){
      return "E";
    }else {
      return "N";
    }
  }

  private String rotateRight() {
    if (direction.equals("N")){
      return "E";
    } else if (direction.equals("E")){
      return "S";
    } else if (direction.equals("S")){
      return "W";
    } else {
      return "N";
    }
  }
}
