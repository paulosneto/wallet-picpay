package br.com.wallet.picpay.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class WalletExceptions extends RunTimeExceptions {

    private final String detail;

    public WalletExceptions(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail errorProblemDetail() {
        //return super.errorProblemDetail(detail);
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Erro ao tentar armazenar os dados da Wallet");
        pd.setDetail(detail);

        return pd;
    }
}
