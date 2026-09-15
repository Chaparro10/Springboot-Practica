package com.kmlch.user_service.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public record APIError (
        LocalDateTime timestamp,
        int status,
        String message,
        String errorMessage,
        String path
) implements Serializable {

}
