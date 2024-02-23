//package com.example.requestIdGenerator.repository;
//
//import com.example.requestIdGenerator.model.RequestId;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.time.LocalDate;
//
//public interface RequestRepository extends JpaRepository<RequestId, Long> {
//    RequestId findTopByRequestDateOrderByRequestIncrementDesc(LocalDate requestDate);
//}
