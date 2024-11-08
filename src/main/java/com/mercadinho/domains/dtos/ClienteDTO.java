package com.mercadinho.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercadinho.domains.Cliente;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDTO {

    protected Long id;
    protected String nomePessoa;
    protected String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCadastro = LocalDate.now();
    protected Set<Integer> tipoPessoa = new HashSet<>();

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nomePessoa = cliente.getNomePessoa();
        this.cpf = cliente.getCpf();
        this.dataCadastro = cliente.getDataCadastro();
        this.tipoPessoa = cliente.getTipoPessoa().stream().map(x -> x.getId()).collect(Collectors.toSet());
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

    public Set<Integer> getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(Set<Integer> tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

}
