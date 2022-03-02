package com.juliosansossio.venezuela.bcv.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {
  @Autowired
  private RateService rateService;

  @GetMapping
  public RateResponseDto getRate(@RequestParam(required = false) RateTypeEnum type) throws Exception {
    type = type == null ? RateTypeEnum.DOLLAR : type;
    Double rate = this.rateService.getRate(type);

    return RateResponseDto.create(type, rate);
  }

}
