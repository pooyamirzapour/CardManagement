package com.digi.Card;

import com.digi.card.api.notification.service.NotificationService;
import com.digi.card.controller.CardController;
import com.digi.card.internal.CardService;
import com.digi.card.repository.entity.Card;
import com.digi.card.repository.entity.NotificationRequest;
import com.digi.card.repository.entity.TransferRequest;
import com.digi.card.repository.entity.TransferResponse;
import com.digi.card.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CardApplicationTests {

    @Mock
    CardService cardService;

    @Mock
    DateUtil dateUtil;

    @InjectMocks
    CardController cardController;


    @Test
    void addCard() throws Exception {
        Card card = getCard();
        Card add = cardService.add(card);
        assertThat(add.getPan()).isEqualTo(card.getPan());
    }

    private Card getCard() {
        Card card = new Card();
        card.setStatus("1");
        card.setPan("6037111122223333");
        card.setCellPhone("09121112222");
        card.setCvv("1");
        card.setExpDate("1399");
        card.setInsertDate(dateUtil.getCurrentDate());
        card.setPin("111");
        return card;
    }

    @Test
    void removeCard() throws Exception {
        cardService.remove("6037111122223333");
    }

    @Test
    void viewList() throws Exception {
        List<Card> cards = cardService.viewList("09121112222");
        System.out.println(cards);

    }

    @Test
    void transfer() throws Exception {
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setInsertDate(dateUtil.getCurrentDate());
        transferRequest.setAmount(1000l);
        transferRequest.setCvv("111");
        transferRequest.setDestination("6037111122223333");
        transferRequest.setSource("6037111122223456");
        transferRequest.setPin("1360");
        transferRequest.setExpDate("1399");
        TransferResponse transfer = cardService.transfer(transferRequest);
        assertThat(transfer.getStatus()).isEqualTo("200");

        System.out.println(transfer);

    }

    @Test
    public void testAddCard() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Card card = getCard();
        ResponseEntity<Card> responseEntity = cardController.addCard(card);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void sendNotification() throws Exception {
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setMsg("sent");
        notificationRequest.setTransferResponseId(1l);
        notificationRequest.setTarget("09121234567");
        notificationRequest.setInsertDate(dateUtil.getCurrentDate());
        NotificationService.INSTANCE.sendNotification(notificationRequest);
    }

    @Test
    public void testTransferCard() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        TransferRequest transfer = getTransfer();
        ResponseEntity<String> responseEntity = cardController.transfer(transfer);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void testViewList() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<List<Card>> listResponseEntity = cardController.viewCards("6037111122223333");
        assertThat(listResponseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    public void testRemoveCard() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        CardController cardController = this.cardController;
        ResponseEntity<String> stringResponseEntity = cardController.removeCard("6037111122223333");
        assertThat(stringResponseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    private TransferRequest getTransfer() {
        TransferRequest transfer = new TransferRequest();
        transfer.setExpDate("1400");
        transfer.setPin("1400");
        transfer.setSource("6037991123659874");
        transfer.setDestination("6037991123659875");
        transfer.setAmount(1000l);
        transfer.setInsertDate(dateUtil.getCurrentDate());
        transfer.setCvv("1400");
        return transfer;

    }


}
