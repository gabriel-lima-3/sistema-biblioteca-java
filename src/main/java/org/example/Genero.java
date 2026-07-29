package org.example;

public enum Genero {


    TERROR,
    COMEDIA,
    ROMANCE,
    AVENTURA;

    public static Genero porOpcao(int opcao) {
        return switch (opcao) {
            case 1 -> TERROR;
            case 2 -> COMEDIA;
            case 3 -> ROMANCE;
            case 4 -> AVENTURA;
            default -> throw new IllegalArgumentException("Opção inválida");
        };

    }
}