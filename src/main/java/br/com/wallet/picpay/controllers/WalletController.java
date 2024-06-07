package br.com.wallet.picpay.controllers;


import br.com.wallet.picpay.domain.Wallet;
import br.com.wallet.picpay.dto.WalletDTO;
import br.com.wallet.picpay.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {


    @Autowired
    private WalletService service;

    public WalletController(WalletService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Wallet> insert(@RequestBody @Validated WalletDTO dto){

        Wallet w = this.service.insert(dto);
        return ResponseEntity.ok().body(w);
    }

    @GetMapping
    public ResponseEntity<List<Wallet>> getAllWallets(){
        List<Wallet> lt = this.service.getAll();
        return ResponseEntity.ok().body(lt);
    }


}
