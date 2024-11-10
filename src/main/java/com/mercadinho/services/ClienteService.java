package com.mercadinho.services;

import com.mercadinho.domains.Cliente;
import com.mercadinho.domains.dtos.ClienteDTO;
import com.mercadinho.repositories.ClienteRepository;
import com.mercadinho.services.exceptions.DataIntegrityViolationException;
import com.mercadinho.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteDTO> findAll() {
        return clienteRepository.findAll().stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado no sistema! ID: " + id));
    }

    public Cliente findByCpf(String cpf) {
        Optional<Cliente> obj = clienteRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado no sistema! CPF: " + cpf));
    }

    public Cliente create(ClienteDTO objDto) {
        objDto.setId(null);
        validarPorCPF(objDto);
        Cliente newObj = new Cliente(objDto);
        return clienteRepository.save(newObj);
    }

    public Cliente update(Long id, ClienteDTO objDto) {
        objDto.setId(id);
        Cliente oldObj = findById(id);
        validarPorCPF(objDto);
        oldObj = new Cliente(objDto);
        return clienteRepository.save(oldObj);
    }

    private void validarPorCPF(ClienteDTO objDto) {
        Optional<Cliente> obj = clienteRepository.findByCpf(objDto.getCpf());

        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
    }

}
