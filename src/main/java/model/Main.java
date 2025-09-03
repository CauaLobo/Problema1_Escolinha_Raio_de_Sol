package model;

import controller.AlunoController;
import controller.ProfessorController;
import controller.ResponsavelController;
import controller.TurmaController;
import view.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe principal do sistema de gerenciamento escolar "Escolinha Raio de Sol".
 * Responsável por inicializar as estruturas de dados, os controladores e as views,
 * além de exibir o menu principal para o usuário.
 */
public class Main {

    /**
     * O método principal que inicia a aplicação.
     * @param args Argumentos da linha de comando (não utilizados neste programa).
     */
    public static void main(String[] args) {

        // Listas (banco em memória)
        List<Aluno> alunos = new ArrayList<>();
        List<Responsavel> responsaveis = new ArrayList<>();
        List<Professor> professores = new ArrayList<>();
        List<Turma> turmas = new ArrayList<>();

        // Controllers
        ResponsavelController responsavelController = new ResponsavelController(responsaveis);
        AlunoController alunoController = new AlunoController(alunos, responsavelController);
        ProfessorController professorController = new ProfessorController(professores, turmas);
        TurmaController turmaController = new TurmaController(turmas, professorController);

        // Ligações entre controllers
        responsavelController.setAlunoController(alunoController);
        alunoController.setTurmaController(turmaController);
        turmaController.setAlunoController(alunoController);
        professorController.setResponsavelController(responsavelController);

        // Views
        ResponsavelView responsavelView = new ResponsavelView(responsavelController, alunoController, turmaController);
        AlunoView alunoView = new AlunoView(turmaController, alunoController, responsavelController);
        ProfessorView professorView = new ProfessorView(professorController, turmaController, alunoController);
        TurmaView turmaView = new TurmaView(turmaController, professorController, alunoController);

        // Menu principal
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Escolinha Raio de Sol ===");
            System.out.println("1. Responsáveis");
            System.out.println("2. Alunos");
            System.out.println("3. Professores");
            System.out.println("4. Turmas");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    responsavelView.exibirMenu();
                    break;
                case 2:
                    alunoView.exibirMenu();
                    break;
                case 3:
                    professorView.exibirMenu();
                    break;
                case 4:
                    turmaView.exibirMenu();
                    break;
                case 5:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 5);
    }
}