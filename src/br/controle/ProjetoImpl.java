package br.controle;

import br.exceptions.DadoConsultadoException;
import br.modelo.Projeto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjetoImpl implements ProjetoDAO {
    //Collection que irá armazenar todos os projetos
    private static Set<Projeto> projetos = new HashSet<>();


    @Override
    public void adicionar(Projeto projeto) {
        projetos.add(projeto);
    }


    @Override
    public List<Projeto> listar() {
        List<Projeto> projetoList = new ArrayList<>();
        projetoList.addAll(projetos);
        return projetoList;
    }

    @Override
    public Projeto consultarPorNome(String nome) throws DadoConsultadoException {
        for(Projeto projeto: projetos){
            if(projeto.getNome().equalsIgnoreCase(nome)){
                return projeto;
            }
        }
        throw new DadoConsultadoException("Projeto não encontrada com o nome: "+ nome);
    }

    @Override
    public Projeto alterar(String nome, Projeto projeto) throws DadoConsultadoException {
        return null;
    }

    @Override
    public void excluir(Projeto projeto) throws DadoConsultadoException {
        if(projetos.contains(projeto)){
            projetos.remove(projeto);
            return;
        }
        throw new DadoConsultadoException("Não foi possível encontrar o projeto para exclusão");
    }

    @Override
    public void excluir(String nome) throws DadoConsultadoException {
        Projeto projeto = consultarPorNome(nome);
        this.excluir(projeto);
    }

}
