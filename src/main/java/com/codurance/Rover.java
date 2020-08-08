package com.codurance;

import static com.codurance.Direction.EAST;
import static com.codurance.Direction.NORTH;
import static com.codurance.Direction.WEST;

public class Rover {

  private static final int MAX_HEIGHT = 10;
  private static final int MAX_WIDTH = 10;
  Direction direction = NORTH;

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
    int x = coordinate.x();
    if (direction == NORTH){
      y = (y + 1) % MAX_HEIGHT;
    }
    
    if (direction == EAST){
      x = (x + 1) % MAX_WIDTH;
    }

    if (direction == WEST){
      x = (x > 0) ? x - 1 : MAX_WIDTH - 1;
    }

    return new Coordinate(x, y);
  }
}
