package pl.sda.springwebmvc.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Laptop {
    private String name;
    private BigDecimal price;
    private int memory;
    private String processor;
}
