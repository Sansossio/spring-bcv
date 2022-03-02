package com.juliosansossio.venezuela.bcv.rate;

import javax.validation.constraints.NotNull;

public class RateResponseDto {
  @NotNull
  private final RateTypeEnum type;
  @NotNull
  private final Double rate;

  public RateResponseDto(RateTypeEnum type, Double rate) {
    this.type = type;
    this.rate = rate;
  }

  public Double getRate() {
    return rate;
  }

  public RateTypeEnum getType() {
    return type;
  }

  public static RateResponseDto create (RateTypeEnum type, Double rate) {
    return new RateResponseDto(type, rate);
  }
}
