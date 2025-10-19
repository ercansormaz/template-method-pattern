package dev.ercan.poc.template.controller;

import dev.ercan.poc.template.dto.request.BuildEmailRequest;
import dev.ercan.poc.template.dto.response.BuildEmailResponse;
import dev.ercan.poc.template.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

  private final EmailService emailService;

  @PostMapping("/build")
  public BuildEmailResponse buildEmail(@RequestBody BuildEmailRequest request) {
    return emailService.buildEmail(request.category(), request.body());
  }

}
