package br.com.wallet.picpay.domain;

import br.com.wallet.picpay.dto.WalletDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "cpfCnpj", nullable = false, unique = true)
    private String cpfCnpj;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;


    public Wallet(WalletDTO dto){
        this.name = dto.name();
        this.cpfCnpj = dto.cpfCnpj();
        this.email = dto.email();
        this.password = dto.password();
        this.balance = dto.balance();
    }

}
