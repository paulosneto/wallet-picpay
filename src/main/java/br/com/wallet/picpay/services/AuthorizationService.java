package br.com.wallet.picpay.services;

import br.com.wallet.picpay.client.AuthorizationClient;
import br.com.wallet.picpay.domain.Transfer;
import br.com.wallet.picpay.dto.TransferDTO;
import br.com.wallet.picpay.exceptions.RunTimeExceptions;
import br.com.wallet.picpay.exceptions.WalletExceptions;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient){
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDTO e){

        var  resposta = authorizationClient.isAuthorized();

        if(resposta.getStatusCode().isError()){
            throw new RuntimeException();
        }

        return resposta.getBody().authorized();
    }


}
