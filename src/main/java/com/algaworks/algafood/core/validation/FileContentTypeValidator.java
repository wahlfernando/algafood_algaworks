package com.algaworks.algafood.core.validation;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FileContentTypeValidator implements ConstraintValidator<FileContentType, MultipartFile> {

    private String[] allowed;

    @Override
    public void initialize(FileContentType constraintAnnotation) {
        this.allowed = constraintAnnotation.allowed();
    }

    @Override
    public boolean isValid(MultipartFile value, ConstraintValidatorContext context) {
        return value == null || Arrays.asList(allowed).contains(value.getContentType());
    }
}
