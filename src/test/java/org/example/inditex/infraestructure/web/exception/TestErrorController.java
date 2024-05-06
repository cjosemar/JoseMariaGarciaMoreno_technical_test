package org.example.inditex.infraestructure.web.exception;

import org.example.inditex.domain.exception.InditexGeneralException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestErrorController {

    @GetMapping("/test/notFound")
    public void throwNotFound() throws Exception {
        throw new InditexGeneralException("Not Found Exception");
    }

    @GetMapping("/test/badRequest")
    public void throwBadRequest() throws Exception {
        throw new Exception("Bad Request Exception");
    }

}
