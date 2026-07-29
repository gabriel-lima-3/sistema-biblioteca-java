package org.example;

public enum TipoDeUsuario {

    PROFESSOR,
    ESTUDANTE,
    VISITANTE;


    public static TipoDeUsuario pelaOpcao(int opcao) {
        return switch (opcao) {
            case 1 -> PROFESSOR;
            case 2 -> ESTUDANTE;
            case 3 -> VISITANTE;
            default -> throw new IllegalArgumentException("Opção inválida");
        };
}
}
