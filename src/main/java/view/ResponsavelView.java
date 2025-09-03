package view;

import controller.AlunoController;
import controller.ResponsavelController;
import controller.TurmaController;
import model.Endereco;
import model.Responsavel;

import java.util.List;
import java.util.Scanner;

/**
 * Gerencia a interface com o usuário para operações relacionadas a Responsável.
 * Permite cadastrar, listar, remover e atualizar responsáveis.
 */
public class ResponsavelView {
    private final Scanner scanner;
    private final ResponsavelController responsavelController;
    private final AlunoController alunoController;
    private final TurmaController turmaController;

    /**
     * Construtor da classe ResponsavelView.
     * @param responsavelController Controlador de responsáveis.
     * @param alunoController Controlador de alunos.
     * @param turmaController Controlador de turmas.
     */
    public ResponsavelView(ResponsavelController responsavelController, AlunoController alunoController, TurmaController turmaController) {
        this.scanner = new Scanner(System.in);
        this.responsavelController = responsavelController;
        this.alunoController = alunoController;
        this.turmaController = turmaController;
    }

    /**
     * Exibe o menu principal de responsáveis para o usuário.
     */
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu de Responsável ---");
            System.out.println("1. Cadastrar Responsável");
            System.out.println("2. Listar Responsáveis");
            System.out.println("3. Remover Responsável");
            System.out.println("4. Atualizar Responsável");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarResponsavel();
                    break;
                case 2:
                    listarResponsaveis();
                    break;
                case 3:
                    removerResponsavel();
                    break;
                case 4:
                    atualizarResponsavel();
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
     * Solicita os dados de um novo responsável e o cadastra.
     */
    private void cadastrarResponsavel() {
        System.out.println("--- Dados do Responsável ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.println("\n--- Endereço do Responsável ---");
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
        Responsavel responsavel = new Responsavel(nome, dataNascimento, endereco, telefone);
        responsavelController.cadastrarResponsavel(responsavel);
        System.out.println("Responsável cadastrado com sucesso! ID: " + responsavel.getId());
    }

    /**
     * Lista todos os responsáveis cadastrados.
     */
    private void listarResponsaveis() {
        List<Responsavel> responsaveis = responsavelController.listar();
        System.out.println("\n--- Lista de Responsáveis ---");
        if (responsaveis.isEmpty()) {
            System.out.println("Nenhum responsável cadastrado.");
        } else {
            responsaveis.forEach(System.out::println);
        }
    }

    /**
     * Solicita o ID de um responsável para remoção.
     */
    private void removerResponsavel() {
        listarResponsaveis();
        System.out.print("Digite o ID do responsável a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        boolean ok = responsavelController.removerResponsavel(id);
        if (ok) {
            System.out.println("Responsável removido com sucesso.");
        } else {
            System.out.println("Responsável não encontrado.");
        }
    }

    /**
     * Solicita o ID de um responsável e os novos dados para atualização.
     */
    private void atualizarResponsavel() {
        listarResponsaveis();
        System.out.print("Digite o ID do responsável a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova data de nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Novo telefone: ");
        String telefone = scanner.nextLine();

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

        responsavelController.atualizarResponsavel(id, nome, dataNascimento, endereco, telefone);
        System.out.println("Responsável atualizado com sucesso.");
    }
}