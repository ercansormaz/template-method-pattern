package dev.ercan.poc.template.template;

import org.springframework.stereotype.Component;

@Component("work")
public class WorkEmailTemplate extends EmailTemplate {

  @Override
  protected String getHeader() {
    return "Dear Colleague,";
  }

  @Override
  protected String getFooter() {
    return "Best regards, Your Company";
  }
}
