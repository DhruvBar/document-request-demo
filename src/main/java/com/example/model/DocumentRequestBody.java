package com.example.model;

import lombok.Data;

import java.util.List;
@Data
public class DocumentRequestBody {
    private String username;
    private List<DocumentRequestData> documentRequestDataList;
}
