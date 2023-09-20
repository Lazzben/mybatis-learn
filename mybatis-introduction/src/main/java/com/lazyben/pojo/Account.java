package com.lazyben.pojo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class Account {
    String name;
    Long id;
    BigDecimal balance;
}
