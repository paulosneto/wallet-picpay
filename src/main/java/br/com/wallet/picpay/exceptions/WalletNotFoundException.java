package br.com.wallet.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

public class WalletNotFoundException extends RunTimeExceptions{

    private int walletId;

    public WalletNotFoundException(int walletId) {
        this.walletId = walletId;
    }

    @Override
    public ProblemDetail errorProblemDetail() {

        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Wallet not found");
        pd.setDetail("There is no wallet with id "+ walletId+" ..");

        return pd;
    }
}
