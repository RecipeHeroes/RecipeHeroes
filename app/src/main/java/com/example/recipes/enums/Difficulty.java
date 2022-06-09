package com.example.recipes.enums;

public enum Difficulty {
    NONE("n/a",0),
    EASY("Einfach", 1),
    MEDIUM("Mittel", 2),
    HARD("Schwer", 3);

    private String label;
    private int id;

    Difficulty(String label, int id) {
        this.label = label;
        this.id = id;
    }

    public String getLabel() {
        return this.label;
    }

    public int getId() {
        return this.id;
    }

    public static Difficulty get(int id) {
        for (Difficulty d : Difficulty.values()) {
            if(d.getId() == id) {
                return d;
            }
        }
        return Difficulty.NONE;
    }
}
