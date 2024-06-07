package br.com.wallet.picpay.repositories;

import br.com.wallet.picpay.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    Optional<Wallet> findByCpfCnpjOrEmail(String cpfcnpj, String email);
}
