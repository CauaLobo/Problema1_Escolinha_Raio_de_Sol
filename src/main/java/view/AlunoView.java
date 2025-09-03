package view;

import controller.AlunoController;
import controller.ResponsavelController;
import controller.TurmaController;
import model.Aluno;
import model.Endereco;
import model.Responsavel;

import java.util.List;
import java.util.Scanner;

/**
 * Gerencia a interface com o usuário para operações relacionadas a Aluno.
 * Permite cadastrar, listar, remover e atualizar alunos, além de vinculá-los a responsáveis.
 */
public class AlunoView {
    private final AlunoController alunoController;
    private final ResponsavelController responsavelController;
    private final TurmaController turmaController;
    private final Scanner scanner;

    /**
     * Construtor da classe AlunoView.
     * @param turmaController Controlador de turmas.
     * @param alunoController Controlador de alunos.
     * @param responsavelController Controlador de responsáveis.
     */
    public AlunoView(TurmaController turmaController, AlunoController alunoController, ResponsavelController responsavelController) {
        this.scanner = new Scanner(System.in);
        this.alunoController = alunoController;
        this.responsavelController = responsavelController;
        this.turmaController = turmaController;
    }

    /**
     * Exibe o menu principal de alunos para o usuário.
     */
    public void exibirMenu() {
        int opcao;
        do {
            System.out.println("\n--- Menu de Alunos ---");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Listar Alunos");
            System.out.println("3. Remover Aluno");
            System.out.println("4. Atualizar Aluno");
            System.out.println("5. Vincular Aluno a um Responsável");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    listarAlunos();
                    break;
                case 3:
                    removerAluno();
                    break;
                case 4:
                    atualizarAluno();
                    break;
                case 5:
                    vincularAlunoResponsavel();
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
     * Solicita os dados de um novo aluno e o cadastra.
     */
    private void cadastrarAluno() {
        System.out.println("--- Dados do Aluno ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Naturalidade: ");
        String naturalidade = scanner.nextLine();

        System.out.println("\n--- Endereço do Aluno ---");
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

        Aluno aluno = new Aluno(nome, dataNascimento, endereco, naturalidade);
        alunoController.cadastrarAluno(aluno);
        System.out.println("Aluno cadastrado com sucesso! ID: " + aluno.getId());
    }

    /**
     * Lista todos os alunos cadastrados.
     */
    private void listarAlunos() {
        List<Aluno> alunos = alunoController.listarAlunos();
        System.out.println("\n--- Lista de Alunos ---");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            alunos.forEach(System.out::println);
        }
    }

    /**
     * Solicita o ID de um aluno para remoção.
     */
    private void removerAluno() {
        listarAlunos();
        System.out.print("Digite o ID do aluno a ser removido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        alunoController.removerAluno(id);
        System.out.println("Aluno removido com sucesso.");
    }

    /**
     * Solicita o ID de um aluno e os novos dados para atualização.
     */
    private void atualizarAluno() {
        listarAlunos();
        System.out.print("Digite o ID do aluno a ser atualizado: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova data de nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Nova naturalidade: ");
        String naturalidade = scanner.nextLine();

        alunoController.atualizarAluno(id, nome, dataNascimento, naturalidade);
        System.out.println("Aluno atualizado com sucesso!");
    }

    /**
     * Gerencia a vinculação de um aluno a um responsável.
     */
    private void vincularAlunoResponsavel() {
        listarAlunos();
        if (alunoController.listarAlunos().isEmpty()) {
            System.out.println("Não há alunos para vincular.");
            return;
        }

        System.out.print("Digite o ID do aluno que deseja vincular: ");
        int idAluno = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = alunoController.buscarAlunoPorId(idAluno);
        if (aluno == null) {
            System.out.println("Aluno com ID " + idAluno + " não encontrado.");
            return;
        }

        System.out.println("\n--- Lista de Responsáveis ---");
        List<Responsavel> responsaveis = responsavelController.listar();
        if (responsaveis.isEmpty()) {
            System.out.println("Nenhum responsável cadastrado.");
            return;
        }
        responsaveis.forEach(System.out::println);

        System.out.print("Digite o ID do responsável para vincular: ");
        int idResponsavel = scanner.nextInt();
        scanner.nextLine();

        alunoController.vincularResponsavel(aluno, idResponsavel);
    }
}