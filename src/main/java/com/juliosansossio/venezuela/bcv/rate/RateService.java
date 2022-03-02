package com.juliosansossio.venezuela.bcv.rate;

import com.juliosansossio.venezuela.bcv.dom.DomParser;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RateService {
  private final String BCV_URL = "http://www.bcv.org.ve/";

  @Autowired
  private DomParser domParser;

  private String getSelectorByEnum(RateTypeEnum type) throws Exception {
    switch (type) {
      case DOLLAR:
        return "#dolar > div > div > div.col-sm-6.col-xs-6.centrado > strong";
      case EUR:
        return "#euro > div > div > div.col-sm-6.col-xs-6.centrado > strong";
      default:
        throw new Exception("Invalid rate type");
    }
  }

  public Double getRate(RateTypeEnum type) throws Exception {
    Document document = this.domParser.get(this.BCV_URL);
    String rate = document.select(this.getSelectorByEnum(type)).text();
    rate = rate.replace(",", ".");
    return Double.parseDouble(rate);
  }
}
