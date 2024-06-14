package br.com.wallet.picpay.controllers;

import br.com.wallet.picpay.domain.Transfer;
import br.com.wallet.picpay.dto.TransferDTO;
import br.com.wallet.picpay.services.TransferService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {


    private final TransferService transferService;


    public TransferController(TransferService transferService){
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<Transfer> transfer(@RequestBody @Valid TransferDTO dto){

        var resp = transferService.transfer(dto);

        return ResponseEntity.ok().body(resp);
    }

}
