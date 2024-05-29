package br.com.wallet.picpay.dto;

import java.math.BigDecimal;

public record WalletDTO (String name, String cpfCnpj, String email, String password, BigDecimal balance) {
}
