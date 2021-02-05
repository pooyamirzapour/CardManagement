package com.digi.card.internal;

import com.digi.card.api.payment.adapter.Converter;
import com.digi.card.api.payment.service.PaymentProvider1Service;
import com.digi.card.api.payment.service.PaymentProvider2Service;
import com.digi.card.repository.crud.TransferRequestRepository;
import com.digi.card.repository.crud.TransferResponseRepository;
import com.digi.card.repository.entity.TransferRequest;
import com.digi.card.repository.entity.TransferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    TransferRequestRepository transferRequestRepository;
    @Autowired
    TransferResponseRepository transferResponseRepository;
    @Autowired
    PaymentProvider1Service paymentProvider1Service;
    @Autowired
    PaymentProvider2Service paymentProvider2Service;

    @Override
    public TransferResponse transfer(TransferRequest transferRequest) throws Exception {
        if (isValid(transferRequest))
           return findAndTransfer(transferRequest);
            throw new Exception("input invalid");
    }

    @Transactional
    private TransferResponse findAndTransfer(TransferRequest transferRequest) {
        transferRequest.setInsertDate(new Date());
        TransferRequest savedTransferRequest = transferRequestRepository.saveAndFlush(transferRequest);
        String status;
        if (transferRequest.getSource().substring(4).equals("6037"))
            status = paymentProvider1Service.pay(Converter.toProvider1DTO(transferRequest));
        else
            status = paymentProvider2Service.pay(Converter.toProvider2DTO(transferRequest));
        TransferResponse transferResponse = setResponse(savedTransferRequest, status);
        return transferResponse;
    }

    private TransferResponse setResponse(TransferRequest savedTransferRequest, String status) {
        TransferResponse transferResponse = new TransferResponse();
        transferResponse.setStatus(status);
        transferResponse.setInsertDate(new Date());
        transferResponse.setRequestId(savedTransferRequest.getId());
        //response.setCellPhone(savedRequest.getC());
        transferResponseRepository.saveAndFlush(transferResponse);
        return transferResponse;
    }


    private boolean isValid(TransferRequest transferRequest) throws Exception {
        if (transferRequest.getSource() == null || transferRequest.getDestination() == null ||
                transferRequest.getPin() == null || transferRequest.getCvv() == null || transferRequest.getAmount() == null)
            throw new Exception("invalid input");//todo define proper message and specific exception
        return true;
    }
}
