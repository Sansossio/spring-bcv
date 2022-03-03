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

  private String getSelector (RateTypeEnum type) {
    String id;
    switch (type) {
      case DOLLAR:
        id = "dolar";
        break;
      case EUR:
        id = "euro";
        break;
      case CNY:
        id = "yuan";
        break;
      case TRY:
        id = "lira";
        break;
      case RUB:
        id = "rublo";
        break;
      default:
        throw new IllegalArgumentException("Invalid type");
    }
    return "#" + id + " > div > div > div.col-sm-6.col-xs-6.centrado > strong";
  }

  public Double getRate(RateTypeEnum type) throws Exception {
    Document document = this.domParser.get(this.BCV_URL);
    String selector = this.getSelector(type);
    String rate = document.select(selector).text();
    rate = rate.replace(",", ".");
    return Double.parseDouble(rate);
  }
}
