package br.com.wallet.picpay.dto;

import br.com.wallet.picpay.domain.WalletType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record WalletDTO (@NotNull @DecimalMin("0.01") BigDecimal balance,
                         @NotBlank String cpfCnpj,
                         @NotBlank String email,
                         @NotBlank String name,
                         @NotBlank String password,
                         @NotNull WalletType.Enum walletType) {
}
