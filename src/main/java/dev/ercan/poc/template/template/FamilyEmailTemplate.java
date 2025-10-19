package dev.ercan.poc.template.template;

import org.springframework.stereotype.Component;

@Component("family")
public class FamilyEmailTemplate extends EmailTemplate {

  @Override
  protected String getHeader() {
    return "Dear Family,";
  }

  @Override
  protected String getFooter() {
    return "Love, Your Family App";
  }
}
