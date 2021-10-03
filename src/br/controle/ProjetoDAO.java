package br.controle;

import br.exceptions.DadoConsultadoException;
import br.modelo.Projeto;

import java.util.List;

public interface ProjetoDAO {

    void adicionar(Projeto projeto) throws DadoConsultadoException;
    List<Projeto> listar();
    Projeto consultarPorNome(String nome) throws DadoConsultadoException;
    Projeto alterar(String nome, Projeto projeto) throws DadoConsultadoException;
    void excluir(Projeto projeto) throws DadoConsultadoException;
    void excluir(String nome) throws DadoConsultadoException, UnsupportedOperationException;
}