package br.com.wallet.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InsufficientBalanceException extends RunTimeExceptions{

    @Override
    public ProblemDetail errorProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Insufficient balance");
        pd.setDetail("You cannot transfer a value bigger than current balance.");

        return pd;

    }
}
