package br.com.wallet.picpay.client;

import br.com.wallet.picpay.domain.Transfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "NotificationClient",
        url ="${${notification.authorization.service.url}}")
public interface NotificationClient {

    @PostMapping
    ResponseEntity<Void> senderNotification(@RequestBody Transfer t);


}
