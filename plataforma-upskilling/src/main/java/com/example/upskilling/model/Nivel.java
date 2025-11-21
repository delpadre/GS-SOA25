package com.example.upskilling.model;

public enum Nivel {
    INICIANTE,
    INTERMEDIARIO,
    AVANCADO;

    public static boolean isValid(String value) {
        if (value == null) return false;
        try {
            Nivel.valueOf(value.toUpperCase());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
