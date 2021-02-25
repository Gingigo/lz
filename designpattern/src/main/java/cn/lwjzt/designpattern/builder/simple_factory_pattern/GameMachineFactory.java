package cn.lwjzt.designpattern.builder.simple_factory_pattern;

import cn.lwjzt.designpattern.builder.abstact_factory.BlackGameMachineFactory;
import cn.lwjzt.designpattern.builder.abstact_factory.Button;
import cn.lwjzt.designpattern.builder.abstact_factory.Screen;

public class GameMachineFactory {
    final static Integer GAME_MACHINE_TYPE_NINTENDO_SWITCH = 0;
    final static Integer GAME_MACHINE_TYPE_PLAY_STATION_5 = 1;
    final static Integer GAME_MACHINE_TYPE_XBOX = 2;

    public static GameMachine getGameMachine(Integer gameMachineType) {
        if (gameMachineType == 0) {
            return new NintendoSwitch();
        } else if (gameMachineType == 1) {
            return new PlayStation5();
        } else if (gameMachineType == 2) {
            return new Xbox();
        } else {
            System.out.println("No Game Machine found");
            return new FC();
        }
    }


    public static void main(String[] args) {
        Integer machineType = XMLUtil.getMachineType();
        GameMachine gameMachine = getGameMachine(machineType);
        gameMachine.startUp();

        BlackGameMachineFactory blackGameMachineFactory = new BlackGameMachineFactory();
        Button button = blackGameMachineFactory.createButton();
        Screen screen = blackGameMachineFactory.createScreen();
        button.display();
        screen.display();
    }
}
