package com.codurance;

import static com.codurance.Direction.NORTH;

import java.util.Optional;

public class Rover {

  Direction direction = NORTH;
  Coordinate coordinate = new Coordinate(0, 0);

  private Grid grid;

  public Rover(Grid grid) {
    this.grid = grid;
  }

  public String execute(String commands) {
    String obstacleString = "";
    for (char c : commands.toCharArray()) {
      if (c == 'R') {
        direction = direction.right();

      } else if (c == 'L') {
        direction = direction.left();
      }

      if (c == 'M'){
        obstacleString = move();
      }
    }

    return obstacleString + coordinate.x() + ":" + coordinate.y() + ":" + direction.value;
  }

  private String move() {
    Optional<Coordinate> nextCoordinate = grid.nextCoordinateFor(coordinate, direction);
    nextCoordinate.ifPresent(nc -> this.coordinate = nc);
    return nextCoordinate.isPresent() ? "" : "O:";
  }

}
