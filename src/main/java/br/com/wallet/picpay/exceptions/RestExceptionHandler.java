package br.com.wallet.picpay.exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(RunTimeExceptions.class)
    public ProblemDetail handleWalletExpection(RunTimeExceptions e){
        return e.errorProblemDetail();
    }

}
