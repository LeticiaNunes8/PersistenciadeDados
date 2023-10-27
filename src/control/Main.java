package control;

import model.Aluno;
import model.Curso;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static dao.Conexao.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a opção desejada: ");
        int opcao = scanner.nextInt();
        if (opcao == 1) {
            entradaAluno();
            System.out.println("FOOOOOOOOOI" + entradaAluno());
        } else if (opcao == 2) {
            entradaCurso();
        }


        try {
            Connection connection = estabelecerConexao(); //precisa pegar uma conexao para poder passar como parametro abaixo
            inserirAluno(connection, entradaAluno());
            listarAlunos(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = estabelecerConexao(); //precisa pegar uma conexao para poder passar como parametro abaixo
            inserirCursos(connection, entradaCurso());
            listarCursos(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Aluno entradaAluno() {
        Scanner scanner = new Scanner(System.in);
        Aluno aluno = new Aluno();

        System.out.println("Digite a matricula do aluno: ");
        String entradaNome = scanner.nextLine();
        aluno.setNome(entradaNome);

        System.out.println("Digite o nome do aluno: ");
        String entradaMatr = scanner.nextLine();
        aluno.setMatricula(entradaMatr);

        System.out.println("Digite o codigo do curso do aluno: ");
        int entradacurso = scanner.nextInt();
        //usuario entra com codigo

        aluno.setCurso(entradacurso);

        return aluno;
    }

    public static Curso entradaCurso() {
        Scanner scanner = new Scanner(System.in);
        Curso curso = new Curso();

        System.out.println("Digite a codigo do curso: ");
        int entradaCodigo = scanner.nextInt();
        curso.setCodigo(entradaCodigo);

        System.out.println("Digite o nome do curso: ");
        String entradaNome = scanner.nextLine();
        curso.setNome(entradaNome);

        System.out.println("Digite o carga Horaria do curso: ");
        int entradaCargaHoraria = scanner.nextInt();
        curso.setCargaHoraria(entradaCargaHoraria);

        return curso;
    }
}
