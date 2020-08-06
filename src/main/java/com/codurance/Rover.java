package com.codurance;

public class Rover {

  String direction = "N";

  public String execute(String commands) {
    for (char c : commands.toCharArray()) {
      direction = rotateRight();

    }

    return "0:0:" + direction;
  }

  private String rotateRight() {
    if (direction == "N"){
      return "E";
    } else {
      return "S";
    }
  }
}
