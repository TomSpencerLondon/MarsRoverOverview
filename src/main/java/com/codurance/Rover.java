package com.codurance;

public class Rover {

  String direction = "N";

  public String execute(String commands) {
    for (char c : commands.toCharArray()) {
      if (direction == "E") {
        direction = "S";
      }
      if (direction == "N"){
        direction = "E";
      }
    }

    return "0:0:" + direction;
  }
}
