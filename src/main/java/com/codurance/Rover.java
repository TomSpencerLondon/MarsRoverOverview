package com.codurance;

import static com.codurance.Direction.NORTH;

public class Rover {

  Direction direction = NORTH;
  Coordinate coordinate = new Coordinate(0, 0);

  private Grid grid;

  public Rover(Grid grid) {
    this.grid = grid;
  }

  public String execute(String commands) {
    for (char c : commands.toCharArray()) {
      if (c == 'R') {
        direction = direction.right();

      } else if (c == 'L') {
        direction = direction.left();
      }

      if (c == 'M'){
        coordinate = grid.nextCoordinateFor(coordinate, direction);
      }
    }

    return coordinate.x() + ":" + coordinate.y() + ":" + direction.value;
  }

}
