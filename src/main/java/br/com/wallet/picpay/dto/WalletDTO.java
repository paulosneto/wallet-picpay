package br.com.wallet.picpay.dto;

import br.com.wallet.picpay.domain.WalletType;

import java.math.BigDecimal;

public record WalletDTO (BigDecimal balance, String cpfCnpj, String email, String name, String password, WalletType.Enum walletType) {
}
