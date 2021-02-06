package com.digi.Card;

import com.digi.card.internal.CardService;
import com.digi.card.repository.entity.Card;
import com.digi.card.repository.entity.TransferRequest;
import com.digi.card.repository.entity.TransferResponse;
import com.digi.card.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class CardApplicationTests {

	@Mock
	CardService cardService;

	@Mock
	DateUtil dateUtil;

	@Test
	void addCard() throws Exception {
		Card card = new Card();
		card.setStatus("1");
		card.setPan("6037111122223333");
		card.setCellPhone("09121112222");
		card.setCvv("1");
		card.setExpDate("1399");
		card.setInsertDate(dateUtil.getCurrentDate());
		card.setPin("111");
		Card add = cardService.add(card);
		System.out.println(add);

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
	void transfer() throws Exception
	{
		TransferRequest transferRequest = new TransferRequest();
		transferRequest.setInsertDate(dateUtil.getCurrentDate());
		transferRequest.setAmount(1000l);
		transferRequest.setCvv("111");
		transferRequest.setDestination("6037111122223333");
		transferRequest.setSource("6037111122223456");
		transferRequest.setPin("1360");
		transferRequest.setExpDate("1399");
		TransferResponse transfer = cardService.transfer(transferRequest);
		System.out.println(transfer);

	}


}
