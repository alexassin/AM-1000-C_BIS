package ru.utorus.am.src.general;

/**
 * Created by IntelliJ IDEA.
 * User: desktop
 * Date: 29.03.11
 * Time: 13:11
 * To change this template use File | Settings | File Templates.
 */
public class Character {
    private String character;

    public Character(State state) {
        this.character = state.name();
    }

    public String getCharacter() {
        return this.character;
    }
}
