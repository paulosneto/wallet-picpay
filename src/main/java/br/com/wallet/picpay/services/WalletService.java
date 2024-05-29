package br.com.wallet.picpay.services;

import br.com.wallet.picpay.domain.Wallet;
import br.com.wallet.picpay.dto.WalletDTO;
import br.com.wallet.picpay.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository repository;

    public WalletService(WalletRepository repository){
        this.repository = repository;
    }

    public Wallet insert(WalletDTO dto){
        Wallet w = this.repository.findById(dto.cpfCnpj()).orElseThrow(() -> {new Exception("User not found");
            return null;
        });

               return this.repository.save(w);
    }

}
