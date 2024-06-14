package br.com.wallet.picpay.services;

import br.com.wallet.picpay.domain.Transfer;
import br.com.wallet.picpay.domain.Wallet;
import br.com.wallet.picpay.dto.TransferDTO;
import br.com.wallet.picpay.exceptions.InsufficientBalanceException;
import br.com.wallet.picpay.exceptions.TransferNotAllowedForWalletTypeException;
import br.com.wallet.picpay.exceptions.TransferNotAuthorizationException;
import br.com.wallet.picpay.exceptions.WalletNotFoundException;
import br.com.wallet.picpay.repositories.TransferRepository;
import br.com.wallet.picpay.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {

    @Autowired
    private final TransferRepository transferRepository;
    @Autowired
    private final AuthorizationService authorizationService;
    @Autowired
    private final NotificationService notificationService;
    @Autowired
    private final WalletRepository walletRepository;


    public TransferService(TransferRepository transferRepository,
                           AuthorizationService authorizationService,
                           NotificationService notificationService,
                           WalletRepository walletRepository) {
        this.transferRepository = transferRepository;
        this.authorizationService = authorizationService;
        this.notificationService = notificationService;
        this.walletRepository = walletRepository;
    }

    @Transactional
    public Transfer transfer(TransferDTO dto){

        // Validação para saber se a pessoa que está enviando valores tem cadastro
        var sender = walletRepository.findById(dto.payer()).orElseThrow(()-> new WalletNotFoundException(dto.payer()));

        // Validação para saber se a pessoa recebedora tem cadastro
        var receiver = walletRepository.findById(dto.payee()).orElseThrow(()-> new WalletNotFoundException(dto.payee()));

        validateTransfer(dto, sender);

        sender.debit(dto.value());
        receiver.credit(dto.value());

        var transfer = new Transfer(sender, receiver, dto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        // Faz a chamada de forma assincrona a api para envio das notificação
        CompletableFuture.runAsync(() -> notificationService.sendNotification(transferResult));


        return transferResult;

    }

    private void validateTransfer(TransferDTO dto, Wallet sender){
        boolean isval = sender.isTransferAllowedForWalletType();
        if(!sender.isTransferAllowedForWalletType()){
                throw new TransferNotAllowedForWalletTypeException();
        }

        if(!sender.isBalanceEqualOrGreatherThan(dto.value())){
                throw new InsufficientBalanceException();
        }

        if(!authorizationService.isAuthorized(dto)){
            throw new TransferNotAuthorizationException();

        }
    }



}
