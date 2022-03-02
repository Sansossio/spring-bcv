package com.juliosansossio.venezuela.bcv.rate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("rate")
@Tag(name = "Rate", description = "Rate methods")
public class RateController {
  @Autowired
  private RateService rateService;

  @GetMapping("{type}")
  @Operation(summary = "Get rate", description = "Get rate")
  public RateResponseDto getRate(@RequestParam RateTypeEnum type) throws Exception {
    Double rate = this.rateService.getRate(type);

    return RateResponseDto.create(type, rate);
  }

}
