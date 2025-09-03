package view;

import controller.AlunoController;
import controller.ProfessorController;
import controller.TurmaController;
import model.Aluno;
import model.Professor;
import model.Turma;

import java.util.List;
import java.util.Scanner;

/**
 * Gerencia a interface com o usuário para operações relacionadas a Turma.
 * Permite cadastrar, listar, remover turmas, e vincular professores e alunos.
 */
public class TurmaView {
    private final Scanner scanner;
    private final TurmaController turmaController;
    private final ProfessorController professorController;
    private final AlunoController alunoController;

    /**
     * Construtor da classe TurmaView.
     * @param turmaController Controlador de turmas.
     * @param professorController Controlador de professores.
     * @param alunoController Controlador de alunos.
     */
    public TurmaView(TurmaController turmaController, ProfessorController professorController, AlunoController alunoController) {
        this.scanner = new Scanner(System.in);
        this.turmaController = turmaController;
        this.professorController = professorController;
        this.alunoController = alunoController;
    }

    /**
     * Exibe o menu principal de turmas para o usuário.
     */
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu de Turma ---");
            System.out.println("1. Cadastrar Turma");
            System.out.println("2. Listar Turmas");
            System.out.println("3. Vincular Professor Regente a uma Turma");
            System.out.println("4. Matricular Aluno em uma Turma");
            System.out.println("5. Remover Turma");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarTurma();
                    break;
                case 2:
                    listarTurmas();
                    break;
                case 3:
                    vincularProfessor();
                    break;
                case 4:
                    matricularAluno();
                    break;
                case 5:
                    removerTurma();
                    break;
                case 6:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 6);
    }

    /**
     * Solicita os dados de uma nova turma e a cadastra.
     */
    private void cadastrarTurma() {
        System.out.println("--- Dados da Turma ---");
        System.out.print("Série: ");
        String serie = scanner.nextLine();
        System.out.print("Ano: ");
        String anoString = scanner.nextLine();

        try {
            int ano = Integer.parseInt(anoString);
            Turma turma = new Turma(serie, ano);
            turmaController.cadastrarTurma(turma);
            System.out.println("Turma cadastrada com sucesso! ID: " + turma.getId());
        } catch (NumberFormatException e) {
            System.out.println("Erro: O ano deve ser um número inteiro. Tente novamente.");
        }
    }

    /**
     * Lista todas as turmas cadastradas.
     */
    private void listarTurmas() {
        List<Turma> lista = turmaController.listarTurmas();
        System.out.println("\n--- Lista de Turmas ---");
        if (lista.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }
        lista.forEach(System.out::println);
    }

    /**
     * Gerencia a vinculação de um professor a uma turma.
     */
    private void vincularProfessor() {
        listarTurmas();
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        List<Professor> professores = professorController.listarProfessores();
        System.out.println("\n--- Lista de Professores ---");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado para vincular.");
            return;
        }
        professores.forEach(System.out::println);
        System.out.print("Digite o ID do professor para ser o regente: ");
        int idProfessor = scanner.nextInt();
        scanner.nextLine();

        boolean ok = turmaController.definirProfessorRegente(idTurma, idProfessor);
        if (ok) {
            System.out.println("Professor vinculado à turma com sucesso!");
        } else {
            System.out.println("Falha ao vincular professor. Verifique os IDs informados.");
        }
    }

    /**
     * Gerencia a matrícula de um aluno em uma turma.
     */
    private void matricularAluno() {
        listarTurmas();
        System.out.print("Digite o ID da turma: ");
        int idTurma = scanner.nextInt();
        scanner.nextLine();

        List<Aluno> alunos = alunoController.listarAlunos();
        System.out.println("\n--- Lista de Alunos ---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado para matricular.");
            return;
        }
        alunos.forEach(System.out::println);
        System.out.print("Digite o ID do aluno a ser matriculado: ");
        int idAluno = scanner.nextInt();
        scanner.nextLine();

        boolean ok = turmaController.matricularAluno(idTurma, idAluno);
        if (ok) {
            System.out.println("Aluno matriculado com sucesso!");
        } else {
            System.out.println("Falha ao matricular aluno. Verifique os IDs informados.");
        }
    }

    /**
     * Solicita o ID de uma turma para remoção.
     */
    private void removerTurma() {
        listarTurmas();
        System.out.print("Digite o ID da turma a ser removida: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        turmaController.removerTurma(id);
        System.out.println("Turma removida com sucesso!");
    }
}