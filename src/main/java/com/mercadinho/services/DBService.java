package com.mercadinho.services;

import com.mercadinho.domains.Cliente;
import com.mercadinho.domains.Funcionario;
import com.mercadinho.domains.Produto;
import com.mercadinho.domains.Venda;
import com.mercadinho.repositories.ClienteRepository;
import com.mercadinho.repositories.FuncionarioRepository;
import com.mercadinho.repositories.ProdutoRepository;
import com.mercadinho.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void initDB() {

        Cliente cliente1 = new Cliente(encoder.encode("11122233344"), "Luís Felipe Prado da Silva", 1L);
        Cliente cliente2 = new Cliente(encoder.encode("11111111111"), "Luís Fagundes", 2L);
        Funcionario funcionario1 = new Funcionario(encoder.encode("77788899955"), "Fernando Rocha", 3L);
        Funcionario funcionario2 = new Funcionario(encoder.encode("22222222222"), "Fernanda Alcantra", 4L);
        Venda venda1 = new Venda(null, 20.00, cliente1);
        Venda venda2 = new Venda(null, 10.00, cliente2);
        Produto produto1 = new Produto(1, "Arroz", "Saco de arroz de 1kg", 15.00, 20.00, "UN" ,"Alimentos", venda1);
        Produto produto2 = new Produto(2, "Alface", "Caveça de alfaçe crespa", 8.00, 10.00, "UN" ,"Alimentos", venda2);

        //venda1.getProdutos().add()
        //venda2.getProdutos().add(produto2);

        cliente1.getVendas().add(venda1);
        cliente2.getVendas().add(venda2);

        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        funcionarioRepository.save(funcionario1);
        funcionarioRepository.save(funcionario2);
        vendaRepository.save(venda1);
        vendaRepository.save(venda2);
        produtoRepository.save(produto1);
        produtoRepository.save(produto2);
    }
}
