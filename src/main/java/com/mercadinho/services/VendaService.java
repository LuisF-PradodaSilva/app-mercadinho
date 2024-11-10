package com.mercadinho.services;

import com.mercadinho.domains.Cliente;
import com.mercadinho.domains.Venda;
import com.mercadinho.domains.dtos.VendaDTO;
import com.mercadinho.repositories.VendaRepository;
import com.mercadinho.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteService clienteService;

    public List<VendaDTO> findAll() {
        return vendaRepository.findAll().stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
    }

    public Venda findById(UUID id) {
        Optional<Venda> obj = vendaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Venda não encontrada no sistema! ID: " + id));
    }

    public Venda newVenda(VendaDTO objDto) {
        Cliente cliente = clienteService.findById(objDto.getCliente());

        Venda venda = new Venda();

        if (objDto.getId() != null) {
            venda.setId(objDto.getId());;
        }

        venda.setValorTotal(objDto.getValorTotal());
        venda.setCliente(cliente);
        venda.setProdutos(objDto.getProdutos());

        return venda;
    }

    public Venda create(VendaDTO vendaDto) {
        return vendaRepository.save(newVenda(vendaDto));
    }

    public Venda update(UUID id, VendaDTO objDto) {
        objDto.setId(id);
        Venda oldObj = findById(id);
        oldObj = newVenda(objDto);
        return vendaRepository.save(oldObj);
    }
}
