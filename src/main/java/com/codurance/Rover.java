package com.codurance;

public class Rover {

  String direction = "N";

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
