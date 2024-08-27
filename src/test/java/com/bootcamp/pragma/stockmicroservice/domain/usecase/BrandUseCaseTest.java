package com.bootcamp.pragma.stockmicroservice.domain.usecase;

import com.bootcamp.pragma.stockmicroservice.domain.api.usecase.BrandUseCase;
import com.bootcamp.pragma.stockmicroservice.domain.exception.BrandAlreadyExistsException;
import com.bootcamp.pragma.stockmicroservice.domain.model.Brand;
import com.bootcamp.pragma.stockmicroservice.domain.model.ContentPage;
import com.bootcamp.pragma.stockmicroservice.domain.spi.IBrandPersistencePort;
import com.bootcamp.pragma.stockmicroservice.domain.usecase.util.BrandTestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BrandUseCaseTest {

    @Mock
    private IBrandPersistencePort brandPersistencePort;
    private BrandUseCase brandUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        brandUseCase = new BrandUseCase(brandPersistencePort);
    }

    @Test
    void shouldSaveBrandWhenNotExist() {
        Brand brand = BrandTestUtil.generateBrand();
        brandUseCase.saveBrand(brand);
        verify(brandPersistencePort, times(1)).save(brand);
    }

    @Test
    void shouldThrowExceptionWhenBrandAlreadyExist() {
        Brand brand = BrandTestUtil.generateBrand();
        when(brandPersistencePort.findByName(brand.getName())).thenReturn(Optional.of(brand));
        assertThrows(BrandAlreadyExistsException.class, () -> brandUseCase.saveBrand(brand));
    }

    @Test
    void shouldReturnAllBrandsWhenExistPaged() {
        int page = 0;
        int size = 10;
        boolean isAsc = true;
        ContentPage<Brand> expectedPage = BrandTestUtil.generateBrandPage();
        when(brandPersistencePort.findAllBrands(page, size, isAsc)).thenReturn(expectedPage);
    }

}
