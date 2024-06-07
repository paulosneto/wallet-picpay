package br.com.wallet.picpay.domain;

import br.com.wallet.picpay.dto.WalletDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;
    @Column(name = "CpfCnpj", nullable = false, unique = true)
    private String cpfCnpj;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "password", nullable = false)
    private String password;
    @ManyToOne
    @JoinColumn(name = "wallet_type_id")
    private WalletType walletType;
    //private int id_wallet_type;

    public Wallet(WalletDTO dto){
        //this.balance = dto.balance();
        this.cpfCnpj = dto.cpfCnpj();
        this.email = dto.email();
        this.name = dto.name();
        this.password = dto.password();
        this.walletType = dto.walletType().get();
    }

}
