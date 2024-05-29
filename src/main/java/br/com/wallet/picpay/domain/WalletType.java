package br.com.wallet.picpay.domain;

import br.com.wallet.picpay.dto.WalletDTO;
import br.com.wallet.picpay.dto.WalletTypeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "wallet_type")
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "description", nullable = false)
    private String description;


    public WalletType(WalletTypeDTO dto){
        this.description = dto.description();
    }

}
