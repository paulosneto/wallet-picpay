package br.com.wallet.picpay.repositories;

import br.com.wallet.picpay.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, String> {
}
