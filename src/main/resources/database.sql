-- Criação da Tabela Cliente
    CREATE TABLE Cliente (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             nome VARCHAR(100),
                             email VARCHAR(100),
                             sexo VARCHAR(10)
    );

    -- Criação da Tabela Livro
    CREATE TABLE Livro (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           nome VARCHAR(100),
                           autor VARCHAR(100),
                           tipo VARCHAR(50),
                           status VARCHAR(20) DEFAULT 'disponível'
    );

    -- Criação da Tabela Empréstimo
    CREATE TABLE Empréstimo (
                                id INT AUTO_INCREMENT PRIMARY KEY,
                                id_cliente INT,
                                id_livro INT,
                                status VARCHAR(20),
                                data DATE,
                                FOREIGN KEY (id_cliente) REFERENCES Cliente(id),
                                FOREIGN KEY (id_livro) REFERENCES Livro(id)
    );

-- Criação do Trigger 1: Atualização do Status do Livro ao ocorrer um Empréstimo
CREATE TRIGGER emprestimo_trigger AFTER INSERT ON Empréstimo
    FOR EACH ROW
BEGIN
    UPDATE Livro
    SET status = 'emprestado'
    WHERE id = NEW.id_livro;
END;

-- Criação do Trigger 2: Atualização do Status do Livro ao ser Devolvido
CREATE TRIGGER devolucao_trigger AFTER UPDATE ON Empréstimo
    FOR EACH ROW
BEGIN
    IF NEW.status = 'devolvido' THEN
        UPDATE Livro
        SET status = 'disponível'
        WHERE id = NEW.id_livro;
    END IF;
END;

SELECT * FROM empréstimo;