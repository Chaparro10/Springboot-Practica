package com.kmlch.play.web.exception;

public record Error(
        String type,
        String message
) {
}
