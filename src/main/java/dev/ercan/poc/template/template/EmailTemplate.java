package dev.ercan.poc.template.template;

public abstract class EmailTemplate {

  public final String buildEmail(String body) {
    return getHeader() + "\n\n" + body + "\n\n" + getFooter();
  }

  protected abstract String getHeader();
  protected abstract String getFooter();

}
