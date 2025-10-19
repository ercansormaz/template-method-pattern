package dev.ercan.poc.template.template;

import org.springframework.stereotype.Component;

@Component("friend")
public class FriendEmailTemplate extends EmailTemplate {

  @Override
  protected String getHeader() {
    return "Hey Friend!";
  }

  @Override
  protected String getFooter() {
    return "Cheers, Your Buddy App";
  }

}
