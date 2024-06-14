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

    public Wallet(WalletDTO dto){
        this.balance = dto.balance();
        this.cpfCnpj = dto.cpfCnpj();
        this.email = dto.email();
        this.name = dto.name();
        this.password = dto.password();
        this.walletType = dto.walletType().get();
    }

    // Verifica o tipo de usuario sendo do tipo USER para efetuar transação
    public boolean isTransferAllowedForWalletType(){
        //return this.walletType.getDescription().toLowerCase().equals(WalletType.Enum.USER.get());
        WalletType tt = WalletType.Enum.USER.get();
        WalletType tet = this.walletType;

        if(this.walletType.getId() ==  WalletType.Enum.USER.get().getId() && this.walletType.getDescription().equals(WalletType.Enum.USER.name())){
            return true;
        }else{
            return this.walletType.equals(WalletType.Enum.USER.get());
        }

        /*boolean vt = WalletType.Enum.USER.name() == this.walletType.getDescription().toString();
        WalletType valorW = WalletType.Enum.USER.get();
        boolean bl = WalletType.Enum.USER.get().equals(this.walletType);*/

    }

    // Verifica o saldo da pessoa para fazer a transferencia
    public boolean isBalanceEqualOrGreatherThan(BigDecimal value){
        return this.balance.doubleValue() >= value.doubleValue();
    }


    // Diminui o valor pago do saldo de conta de quem está enviado
    public void debit(BigDecimal value) {
        this.balance = this.balance.subtract(value);
    }

    // Adiciona o valor recebido ao saldo da conta
    public void credit(BigDecimal value){
        this.balance = this.balance.add(value);
    }
}
