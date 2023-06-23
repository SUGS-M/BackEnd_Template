package com.example.backend_template.common.request;

import lombok.Data;

@Data
public class PageRequest {
    private Long pageNum;
    private Long pageSize;
}
