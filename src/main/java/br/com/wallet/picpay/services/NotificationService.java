package br.com.wallet.picpay.services;

import br.com.wallet.picpay.client.NotificationClient;
import br.com.wallet.picpay.domain.Transfer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService  {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    public final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient){
        this.notificationClient = notificationClient;
    }

    public void sendNotification(Transfer transfer){

        try{
           logger.info("Sending notification...");

           var resp = notificationClient.senderNotification(transfer);

           if(resp.getStatusCode().isError()){
               logger.error("Error while sending notification status code is not ok");
           }

        }catch (Exception e){
            logger.error("Error while sending notification.", e);
        }
    }


}
