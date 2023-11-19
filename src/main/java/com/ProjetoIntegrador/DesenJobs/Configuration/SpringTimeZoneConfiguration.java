package com.ProjetoIntegrador.DesenJobs.Configuration;



import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import java.util.TimeZone;

@Configuration
public class SpringTimeZoneConfiguration {

  @PostConstruct
  public void timeZoneConfig() {

    TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
  }
}