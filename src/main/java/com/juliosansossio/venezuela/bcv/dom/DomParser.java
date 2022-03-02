package com.juliosansossio.venezuela.bcv.dom;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class DomParser {
  public Document get(String url) throws IOException {
    return Jsoup.connect(url).get();
  }
}
