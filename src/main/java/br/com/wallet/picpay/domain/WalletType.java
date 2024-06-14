package br.com.wallet.picpay.domain;

import br.com.wallet.picpay.dto.WalletTypeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "wallet_type")
public class WalletType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "description", nullable = false)
    private String description;


    /*public WalletType(WalletTypeDTO dto){
        this.id = dto.id();
        this.description = dto.description();
    }*/

    public WalletType() {
    }

    public WalletType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public enum Enum{
        USER(1, "USER"),
        MERCHANT(2, "MERCHANT");

        Enum(int id, String description) {
            this.id = id;
            this.description = description;
        }

        private int id;
        private String description;

        /*public void WalletType (WalletTypeDTO dto){
            this.id = dto.id();
            this.description = dto.description();
        }*/
        public WalletType get(){
            return new WalletType(id, description);
        }
    }

}
