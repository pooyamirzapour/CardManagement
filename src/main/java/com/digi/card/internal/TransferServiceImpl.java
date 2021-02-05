package com.digi.card.internal;

import com.digi.card.api.payment.adapter.Converter;
import com.digi.card.api.payment.service.PaymentProvider1Service;
import com.digi.card.api.payment.service.PaymentProvider2Service;
import com.digi.card.repository.crud.RequestRepository;
import com.digi.card.repository.crud.ResponseRepository;
import com.digi.card.repository.entity.Request;
import com.digi.card.repository.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    RequestRepository requestRepository;
    @Autowired
    ResponseRepository responseRepository;
    @Autowired
    PaymentProvider1Service paymentProvider1Service;
    @Autowired
    PaymentProvider2Service paymentProvider2Service;

    @Override
    public Response transfer(Request request) throws Exception {
        if (isValid(request))
           return findAndTransfer(request);
            throw new Exception("input invalid");
    }

    @Transactional
    private Response findAndTransfer(Request request) {
        request.setInsertDate(new Date());
        Request savedRequest = requestRepository.saveAndFlush(request);
        String status;
        if (request.getSource().substring(4).equals("6037"))
            status = paymentProvider1Service.pay(Converter.toProvider1DTO(request));
        else
            status = paymentProvider2Service.pay(Converter.toProvider2DTO(request));
        Response response = setResponse(savedRequest, status);
        return response;
    }

    private Response setResponse(Request savedRequest, String status) {
        Response response = new Response();
        response.setStatus(status);
        response.setInsertDate(new Date());
        response.setRequestId(savedRequest.getId());
        //response.setCellPhone(savedRequest.getC());
        responseRepository.saveAndFlush(response);
        return response;
    }


    private boolean isValid(Request request) throws Exception {
        if (request.getSource() == null || request.getDestination() == null ||
                request.getPin() == null || request.getCvv() == null || request.getAmount() == null)
            throw new Exception("invalid input");//todo define proper message and specific exception
        return true;
    }
}
