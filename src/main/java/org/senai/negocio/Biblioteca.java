package org.senai.negocio;

import org.senai.entidades.Cliente;
import org.senai.entidades.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private Connection connection;

    public Biblioteca() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarLivrosDisponiveis() {
        List<Livro> livros = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Livro WHERE status = 'disponível'");
            while (rs.next()) {
                Livro livro = new Livro(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("autor"), rs.getString("tipo"), rs.getString("status"));
                livros.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livros;
    }

    public void emprestarLivro(int idLivro) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Livro SET status = 'emprestado' WHERE id = ?");
            pstmt.setInt(1, idLivro);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void devolverLivro(int idLivro) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("UPDATE Livro SET status = 'disponível' WHERE id = ?");
            pstmt.setInt(1, idLivro);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserirLivro(Livro livro) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Livro (nome, autor, tipo, status) VALUES (?, ?, ?, ?)");
            pstmt.setString(1, livro.getNome());
            pstmt.setString(2, livro.getAutor());
            pstmt.setString(3, livro.getTipo());
            pstmt.setString(4, livro.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Cliente (nome, email, sexo) VALUES (?, ?, ?)");
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getSexo());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente(rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("sexo"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public void realizarEmprestimo(int idCliente, int idLivro) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Empréstimo (id_cliente, id_livro, status, data) VALUES (?, ?, ?, NOW())");
            pstmt.setInt(1, idCliente);
            pstmt.setInt(2, idLivro);
            pstmt.setString(3, "emprestado");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Livro> listarLivrosEmprestados() {
        List<Livro> livrosEmprestados = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Livro WHERE status = 'emprestado'");
            while (rs.next()) {
                Livro livro = new Livro(rs.getInt("id"), rs.getString("nome"),
                        rs.getString("autor"), rs.getString("tipo"), rs.getString("status"));
                livrosEmprestados.add(livro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livrosEmprestados;
    }
}
