package glebdyakovcompany.app.shop.controllers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class ErrorHandlerController {
    @ExceptionHandler(Exception.class)
    public RedirectView handleNonExistingRoute() {
        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
		URI newUri = builder.build().toUri();
		return new RedirectView("/?redirecttoroute=" + newUri.getPath());
    }
}
