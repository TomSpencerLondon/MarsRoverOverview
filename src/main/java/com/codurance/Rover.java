package com.codurance;

public class Rover {

  Direction direction = Direction.NORTH;

  Coordinate coordinate = new Coordinate(0, 0);

  public String execute(String commands) {
    for (char c : commands.toCharArray()) {
      if (c == 'R') {
        direction = direction.right();

      } else if (c == 'L') {
        direction = direction.left();
      }

      if (c == 'M'){
        coordinate = move();
      }

    }

    return coordinate.x() + ":" + coordinate.y() + ":" + direction.value;
  }

  private Coordinate move() {
    int y = coordinate.y();
    if (direction.value.equals("N")){
      y += 1;
    }

    return new Coordinate(coordinate.x(), y);
  }
}
