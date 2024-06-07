package br.com.wallet.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;

public abstract class RunTimeExceptions extends RuntimeException{

    public ProblemDetail errorProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);

        pb.setTitle("Server internal error Wallet PicPay");
        //pb.setTitle(error);

        return pb;
    }

}
