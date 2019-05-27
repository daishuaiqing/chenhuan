package com.daishuaiqing.chenhuan.vo;

import com.daishuaiqing.chenhuan.domain.Cases;
import lombok.Data;

@Data
public class CasesDetail {
    private Cases cases;
    private Cases lastCases;
    private Cases nextCases;
}
