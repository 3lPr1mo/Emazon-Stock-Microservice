package com.bootcamp.pragma.stockmicroservice.configuration;

import com.bootcamp.pragma.stockmicroservice.domain.api.IBrandServicePort;
import com.bootcamp.pragma.stockmicroservice.domain.api.usecase.BrandUseCase;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IBrandPersistencePort;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.adapter.BrandJpaAdapter;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.mapper.BrandEntityMapper;
import com.bootcamp.pragma.stockmicroservice.infrastructure.output.jpa.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BrandBeanConfiguration {

    private final BrandRepository brandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Bean
    public IBrandPersistencePort brandPersistencePort() {
        return new BrandJpaAdapter(brandRepository, brandEntityMapper);
    }

    @Bean
    public IBrandServicePort brandServicePort() {
        return new BrandUseCase(brandPersistencePort());
    }

}
