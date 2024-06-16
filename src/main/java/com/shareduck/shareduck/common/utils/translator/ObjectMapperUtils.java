package com.shareduck.shareduck.common.utils.translator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shareduck.shareduck.common.exception.BusinessLogicException;
import com.shareduck.shareduck.common.exception.CommonExceptionCode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class ObjectMapperUtils {
    private final ObjectMapper objectMapper;

    public <T> T toEntity(HttpServletRequest request, Class<T> valueType) {
        try {
            return objectMapper.readValue(request.getInputStream(), valueType);
        } catch (IOException e) {
            throw new BusinessLogicException(CommonExceptionCode.TRANS_ENTITY_ERROR);
        }
    }

    public <T> T toEntity(String content, Class<T> valueType) {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (IOException e) {
            throw new BusinessLogicException(CommonExceptionCode.TRANS_ENTITY_ERROR);
        }
    }

    public String toStringValue(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new BusinessLogicException(CommonExceptionCode.TRANS_JSON_ERROR);
        }
    }
}