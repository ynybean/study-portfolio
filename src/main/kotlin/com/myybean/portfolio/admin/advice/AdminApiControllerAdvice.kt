package com.myybean.portfolio.admin.advice

import com.myybean.portfolio.admin.exception.AdminException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice // exception 처리하는것들을 모아둔 곳
class AdminApiControllerAdvice {

    val log = LoggerFactory.getLogger(AdminApiControllerAdvice::class.java)

    @ExceptionHandler
    fun handleException(e: AdminException) : ResponseEntity<String> {
        log.info(e.message, e)

        return ResponseEntity.status(e.httpStatus).body(e.message)
    }

    @ExceptionHandler
    fun handleException(e: MethodArgumentNotValidException) : ResponseEntity<String> {
        log.info(e.message, e)

        val fieldError = e.bindingResult.fieldErrors[0]
        val message = "[${fieldError.field} ${fieldError.defaultMessage}]"

        return ResponseEntity.badRequest().body(message)
    }

    @ExceptionHandler
    fun handleException(e: Exception) : ResponseEntity<String> {
        log.info(e.message, e)

        return ResponseEntity.internalServerError().body("시스템 오류가 발생했습니다.")
    }
}