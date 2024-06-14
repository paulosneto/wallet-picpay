package br.com.wallet.picpay.dto;

import br.com.wallet.picpay.domain.Wallet;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

public record TransferDTO(@NotNull @DecimalMin("0.01") BigDecimal value,
                          @NotNull Integer payer,
                          @NotNull Integer payee) {
}
