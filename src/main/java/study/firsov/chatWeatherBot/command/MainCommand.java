package study.firsov.chatWeatherBot.command;

import java.util.Locale;

public enum MainCommand {
    START("for start"),
    HELP("list of commands"),
    CITY("current city"),
    SETCITY("for set new city"),
    NOW("show current temperature"),
    CANCEL("cancel");

    private String desc;

    public String getDescription() {
        return "/" + this.name().toLowerCase(Locale.ROOT) + " - " + desc;
    }

    MainCommand(String s) {
        desc = s;
    }
}
