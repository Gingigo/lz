package cn.lwjzt.designpattern.builder.factory_pattern;

public class Nintendo_Switch_Factory implements Factory {
    final static Integer GAME_MACHINE_TYPE_NINTENDO_SWITCH = 0;
    final static Integer GAME_MACHINE_TYPE_PLAY_STATION_5 = 1;
    final static Integer GAME_MACHINE_TYPE_XBOX = 2;


    public static void main(String[] args) {
        Factory factory = new Nintendo_Switch_Factory();
        GameMachine gameMachine = factory.createGameMachine("black ");
        gameMachine.startUp();
    }

    @Override
    public GameMachine createGameMachine() {
        return new NintendoSwitch();
    }

    @Override
    public GameMachine createGameMachine(String color) {
        return new NintendoSwitch(color);
    }
}
