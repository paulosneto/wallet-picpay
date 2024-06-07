package br.com.wallet.picpay.exceptions;

import jakarta.persistence.ElementCollection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    // Tratamento personalizado
    @ExceptionHandler(RunTimeExceptions.class)
    public ProblemDetail handleWalletExpection(RunTimeExceptions e){
        return e.errorProblemDetail();
    }


    //Tratamento para informar quando não for passado os campos obrigatórios
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e){

        var listProblem = e.getFieldErrors()
                .stream()
                .map(a -> new InvalidParam(a.getField(), a.getDefaultMessage()))
                .toList();

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pd.setTitle("Your request parameters didn't validate");
        pd.setProperty("invalid-params", listProblem);

        return pd;
    }

    //Record usado no metodo acima para verificação
    // dos campos caso os mesmo nao estejam preenchidos
    private record InvalidParam(String name, String reason){}
}

