package br.com.wallet.picpay.config;

import br.com.wallet.picpay.domain.WalletType;
import br.com.wallet.picpay.repositories.WalletRepository;
import br.com.wallet.picpay.repositories.WalletTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private WalletTypeRepository repository;

    public DataLoader(WalletTypeRepository repository){
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        Arrays.stream(WalletType.Enum.values()).forEach(walletType -> repository.save(walletType.get()));
    }
}
