package com.example.exchange_rate.service;

import com.example.exchange_rate.dao.ExchangeRateDao;
import com.example.exchange_rate.dto.ExchangeRateRequest;
import com.example.exchange_rate.dto.ExchangeRateResponse;
import com.example.exchange_rate.mapper.MapperConfiguration;
import io.reactivex.rxjava3.core.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService{

    @Autowired
    private ExchangeRateDao exchangeRateDao;

    @Autowired
    private MapperConfiguration mapperConfiguration;

    @Override
    public Single<ExchangeRateResponse> getExchangeRate(ExchangeRateRequest request) {
        return exchangeRateDao.getExchangeRate(request.getOriginalCurrency(),request.getExchangeCurrency())
                .map(exchangeRate ->
                        mapperConfiguration.mapExchangeRateResponse(exchangeRate,request.getOriginalAmount()));
    }
}