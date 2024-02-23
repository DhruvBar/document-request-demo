//package com.example.requestIdGenerator.service;
//
//import com.example.model.DocumentRequest;
//import com.example.repository.DocumentRequestRepository;
//import com.example.requestIdGenerator.model.RequestId;
//import com.example.requestIdGenerator.repository.RequestRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//
//@Service
//public class RequestIdService {
//
//    @Autowired
//    private RequestRepository requestRepository;
//
//    @Autowired
//    private DocumentRequestRepository documentRequestRepository;
//
//    public RequestId createRequest()
//    {
//        RequestId requestId = new RequestId();
//        requestId.setRequestDate(LocalDate.now());
//        requestId.setRequestIncrement(getNextIncrementValue());
//        String formattedDate = requestId.getRequestDate().format(DateTimeFormatter.ofPattern("ddMMyy"));
//        String requestIds = formattedDate+ String.format("%04d",getNextIncrementValue());
//        requestId.setRequestId(requestIds);
//        requestRepository.save(requestId);
//
//        DocumentRequest documentRequest = new DocumentRequest();
//        documentRequest.setId(Long.valueOf(requestIds));
//
//        StoredRequestId storedRequestId = new StoredRequestId();
//        storedRequestId.setRequestId(requestId);
//        storedRequestIdRepository.save(storedRequestId);
//        System.out.println(requestId);
//
//        return request;
//
//    }
//    private int getNextIncrementValue() {
//        LocalDate currentDate = LocalDate.now();
//
//        // Check if there is a record for the current date
//        RequestId lastRequest = requestRepository.findTopByRequestDateOrderByRequestIncrementDesc(currentDate);
//
//        if (lastRequest != null) {
//            // If there is a record for today, increment the existing value
//            return lastRequest.getRequestIncrement() + 1;
//        } else {
//            // If no record exists for today, start from 1
//            return 1;
//        }
//    }
//
//
//}
