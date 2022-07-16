package com.example.LibraryApplication.configuration;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix="app")
@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationProperties {
    @NotNull
    private int maxCheckoutBook;
    @NotNull
    private int maxDaysBorrow;
    @NotNull
    private double feePerDay;

    private String bookCatalogUrl;
    @NotNull
    private int outstandingFeePrintTime;
}
