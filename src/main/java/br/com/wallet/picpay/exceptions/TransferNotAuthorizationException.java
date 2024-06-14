package br.com.wallet.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAuthorizationException extends RunTimeExceptions{

    @Override
    public ProblemDetail errorProblemDetail() {

        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Transfer not authorized.");
        pd.setDetail("Authorization service not authorized this transfer.");

        return pd;
    }
}
