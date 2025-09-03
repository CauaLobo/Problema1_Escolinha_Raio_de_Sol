package view;

import controller.AlunoController;
import controller.ProfessorController;
import controller.TurmaController;
import model.Endereco;
import model.Professor;

import java.util.List;
import java.util.Scanner;

/**
 * Gerencia a interface com o usuário para operações relacionadas a Professor.
 * Permite cadastrar, listar, remover e atualizar professores.
 */
public class ProfessorView {
    private final Scanner scanner;
    private final ProfessorController professorController;
    private final TurmaController turmaController;
    private final AlunoController alunoController;

    /**
     * Construtor da classe ProfessorView.
     * @param professorController Controlador de professores.
     * @param turmaController Controlador de turmas.
     * @param alunoController Controlador de alunos.
     */
    public ProfessorView(ProfessorController professorController, TurmaController turmaController, AlunoController alunoController) {
        this.scanner = new Scanner(System.in);
        this.professorController = professorController;
        this.turmaController = turmaController;
        this.alunoController = alunoController;
    }

    /**
     * Exibe o menu principal de professores para o usuário.
     */
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu de Professor ---");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Listar Professores");
            System.out.println("3. Remover Professor");
            System.out.println("4. Atualizar Professor");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    listarProfessores();
                    break;
                case 3:
                    removerProfessor();
                    break;
                case 4:
                    atualizarProfessor();
                    break;
                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
    }

    /**
     * Solicita os dados de um novo professor e o cadastra.
     */
    private void cadastrarProfessor() {
        System.out.println("--- Dados do Professor ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Formação: ");
        String formacao = scanner.nextLine();

        System.out.println("\n--- Endereço do Professor ---");
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        Endereco endereco = new Endereco(rua, bairro, cep, cidade, estado);

        Professor professor = new Professor(nome, dataNascimento, endereco, telefone, formacao);
        professorController.cadastrarProfessor(professor);
        System.out.println("Professor cadastrado com sucesso! ID: " + professor.getId());
    }

    /**
     * Lista todos os professores cadastrados.
     */
    private void listarProfessores() {
        List<Professor> professores = professorController.listarProfessores();
        System.out.println("\n--- Lista de Professores ---");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
        } else {
            professores.forEach(System.out::println);
        }
    }

    /**
     * Solicita o ID de um professor para remoção.
     */
    private void removerProfessor() {
        listarProfessores();
        System.out.print("Digite o ID do professor a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean ok = professorController.removerProfessor(id);
        if (ok) {
            System.out.println("Professor removido com sucesso.");
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    /**
     * Solicita o ID de um professor e os novos dados para atualização.
     */
    private void atualizarProfessor() {
        listarProfessores();
        System.out.print("Digite o ID do professor a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova data de nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Nova formação: ");
        String formacao = scanner.nextLine();

        System.out.println("\n--- Novo Endereço ---");
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        Endereco endereco = new Endereco(rua, bairro, cep, cidade, estado);

        professorController.atualizarProfessor(id, nome, dataNascimento, endereco, telefone, formacao);
        System.out.println("Professor atualizado com sucesso!");
    }
}