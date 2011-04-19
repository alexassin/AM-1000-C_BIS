package ru.utorus.am.src.general;


public class Character {
    private String character;

    public Character(State state) {
        this.character = state.name();
    }

    public String getCharacter() {
        return this.character;
    }
}
