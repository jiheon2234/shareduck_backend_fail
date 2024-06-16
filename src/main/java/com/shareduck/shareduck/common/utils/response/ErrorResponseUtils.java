package com.shareduck.shareduck.common.utils.response;

import com.shareduck.shareduck.common.exception.ErrorResponse;
import com.shareduck.shareduck.common.security.exception.AuthExceptionCode;
import com.shareduck.shareduck.common.utils.translator.ObjectMapperUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ErrorResponseUtils {

    private final ObjectMapperUtils objectMapperUtils;

    public void sendErrorResponse(HttpServletResponse response) throws IOException {
        setResponseAuthErrorToHeader(response);
        response.getWriter().write(getResponseData());
    }

    private void setResponseAuthErrorToHeader(HttpServletResponse response) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setCharacterEncoding("utf-8");
    }

    private String getResponseData() {
        return objectMapperUtils.toStringValue(createErrorResponse());
    }

    private ErrorResponse createErrorResponse() {
        return ErrorResponse.of(
                AuthExceptionCode.UNAUTHENTICATED.getHttpStatus(),
                AuthExceptionCode.UNAUTHENTICATED.getMessage());
    }
}