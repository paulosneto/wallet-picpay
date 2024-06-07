package br.com.wallet.picpay.repositories;

import br.com.wallet.picpay.domain.Wallet;
import br.com.wallet.picpay.domain.WalletType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletTypeRepository extends JpaRepository<WalletType, Integer> {
}
