package com.longmenzhitong.training.conc03.netty.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * IP段范围
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IpRange {

    private String start;

    private String end;


}
