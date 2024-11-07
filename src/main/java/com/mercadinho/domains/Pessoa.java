package com.mercadinho.domains;

import com.mercadinho.domains.enums.TipoPessoa;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Pessoa {

    protected Long id;
    protected String nomePessoa;
    protected String cpf;
    protected LocalDate dataCadastro = LocalDate.now();
    protected Set<Integer> tipoPessoa = new HashSet<>();

    public Pessoa() {
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public Pessoa(Set<Integer> tipoPessoa, LocalDate dataCadastro, String cpf, String nomePessoa, Long id) {
        this.tipoPessoa = tipoPessoa;
        this.dataCadastro = dataCadastro;
        this.cpf = cpf;
        this.nomePessoa = nomePessoa;
        this.id = id;
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Set<TipoPessoa> getTipoPessoa() {
        return tipoPessoa.stream().map(x -> TipoPessoa.toEnum(x)).collect(Collectors.toSet());
    }

    public void addTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa.add(tipoPessoa.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }

}
