package dev.ercan.poc.template.service;

import dev.ercan.poc.template.dto.response.BuildEmailResponse;
import dev.ercan.poc.template.exception.EmailCategoryNotFoundException;
import dev.ercan.poc.template.template.EmailTemplate;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

  // component name -> implementation map (Spring DI)
  private final Map<String, EmailTemplate> templates;

  public BuildEmailResponse buildEmail(String category, String body) {
    EmailTemplate template = templates.get(category.toLowerCase());
    if (template == null) {
      throw new EmailCategoryNotFoundException("Unknown category: " + category);
    }
    return new BuildEmailResponse(template.buildEmail(body));
  }

}
