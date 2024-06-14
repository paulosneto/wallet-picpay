package br.com.wallet.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAllowedForWalletTypeException extends RunTimeExceptions{

    @Override
    public ProblemDetail errorProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("This wallet type is not allowed to transfer");;

        return pd;
    }
}
