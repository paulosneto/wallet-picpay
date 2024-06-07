package br.com.wallet.picpay.services;

import br.com.wallet.picpay.domain.Wallet;
import br.com.wallet.picpay.dto.WalletDTO;
import br.com.wallet.picpay.exceptions.WalletExceptions;
import br.com.wallet.picpay.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {


    private final WalletRepository repository;

    public WalletService(WalletRepository repository){
        this.repository = repository;
    }

    public Wallet insert(WalletDTO dto){
        Optional<Wallet> w = this.repository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());

        if(w.isPresent()){
             throw new WalletExceptions("Usuário já existente");
        }else{
            Wallet wallet = new Wallet(dto);
           return this.repository.save(wallet);
        }
    }

    public List<Wallet> getAll(){
        return this.repository.findAll();
    }

}
