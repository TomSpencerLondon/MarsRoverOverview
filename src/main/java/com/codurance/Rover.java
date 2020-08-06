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
    if (direction == "N"){
      return "W";
    }
    return "W";
  }

  private String rotateRight() {
    if (direction == "N"){
      return "E";
    } else if (direction == "E"){
      return "S";
    } else if (direction == "S"){
      return "W";
    } else {
      return "N";
    }
  }
}
