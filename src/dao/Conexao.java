package dao;

import model.Aluno;
import model.Curso;

import java.sql.*;
import java.util.Scanner;

public class Conexao {

    public static final String JDBC_URL = "jdbc:postgresql://localhost:5432/escola";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";

    public static Connection estabelecerConexao() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

    }

    //////////////// ALUNOS
    public static void inserirAluno(Connection connection, Aluno aluno)  throws SQLException {

        String sql = "INSERT INTO alunos (matricula, nome, curso) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, aluno.getMatricula());
            preparedStatement.setString(2, aluno.getNome());
            preparedStatement.setInt(3, aluno.getCurso().getCodigo());
            preparedStatement.executeUpdate();
        }
    }

    public static void listarAlunos(Connection connection) throws SQLException {

        String sql = "SELECT matricula, nome, curso FROM alunos";
        try (Statement stmt = connection.createStatement();
             ResultSet result = stmt.executeQuery(sql)) {

            while (result.next()) {
                String matricula = result.getString("matricula");
                String nome = result.getString("nome");
                int curso = result.getInt("curso");
                System.out.println("Matrícula: " + matricula + " Nome: " + nome + "Curso: " + curso);
            }
        }
    }


    //////////////////////CURSO
    public static void inserirCursos(Connection connection, Curso curso)  throws SQLException {
        String sql = "INSERT INTO cursos (codigo, nome, cargaHoraria) VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, curso.getCodigo());
            preparedStatement.setString(2, curso.getNome());
            preparedStatement.setInt(3, curso.getCargaHoraria());
            preparedStatement.executeUpdate();
        }
    }

    public static void listarCursos(Connection connection) throws SQLException {
        String sql = "SELECT codigo, nome, cargaHoraria FROM cursos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String codigo = rs.getString("codigo");
                String nome = rs.getString("nome");
                int ch = rs.getInt("cargaHoraria");
                System.out.println("codigo: " + codigo + " Nome: " + nome + "cargaHoraria: " + ch);
            }
        }
    }
}
