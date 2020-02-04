package com.eomcs.lms.handler;

import com.eomcs.util.Prompt;

public class ComputePlusCommand implements Command {
  Prompt prompt;

  public ComputePlusCommand(Prompt prompt) {
    this.prompt = prompt;
  }

  @Override
  public void execute() {
    int no1 = prompt.inputInt("수1? ");
    int no2 = prompt.inputInt("수2? ");

    System.out.printf("계산결과는 %d 입니다\n", (no1 + no2));
  }

}
