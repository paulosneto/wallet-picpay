package br.com.wallet.picpay.domain;

import br.com.wallet.picpay.dto.TransferDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "wallet_sender_id")
    private Wallet sender;

    @ManyToOne
    @JoinColumn(name = "wallet_receiver_id")
    private Wallet receiver;

    @Column(name = "value")
    private BigDecimal value;

    /*public Transfer(TransferDTO dto){
        this.value = dto.value();
        this.sender = dto.sender();
        this.receiver = dto.receiver();
    }*/

    public Transfer(Wallet sender, Wallet receiver, BigDecimal value){
        this.sender = sender;
        this.receiver = receiver;
        this.value = value;
    }

}
