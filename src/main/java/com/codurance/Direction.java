package com.codurance;

enum Direction {
  NORTH("N", "W", "E"),
  EAST("E", "N", "S"),
  SOUTH("S", "E", "W"),
  WEST("W", "S", "N");

  public final String value;
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
