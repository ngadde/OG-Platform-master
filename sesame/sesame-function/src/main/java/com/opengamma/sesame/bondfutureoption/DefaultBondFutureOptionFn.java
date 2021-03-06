/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame.bondfutureoption;

import com.opengamma.analytics.financial.provider.sensitivity.multicurve.MultipleCurrencyMulticurveSensitivity;
import com.opengamma.analytics.financial.provider.sensitivity.multicurve.MultipleCurrencyParameterSensitivity;
import com.opengamma.sesame.Environment;
import com.opengamma.sesame.trade.BondFutureOptionTrade;
import com.opengamma.util.ArgumentChecker;
import com.opengamma.util.money.MultipleCurrencyAmount;
import com.opengamma.util.result.Result;

/**
 * Default implementation of the {@link BondFutureOptionFn} that uses a specified calculator to calculate requested values.
 */
public class DefaultBondFutureOptionFn implements BondFutureOptionFn {
  
  private final BondFutureOptionCalculatorFactory _bondFutureOptionCalculatorFactory;
  
  /**
   * Constructs a function to calculate values for a bond future option.
   * @param bondFutureOptionCalculatorFactory the calculator factory for bond future options, not null.
   */
  public DefaultBondFutureOptionFn(BondFutureOptionCalculatorFactory bondFutureOptionCalculatorFactory) {
    _bondFutureOptionCalculatorFactory = ArgumentChecker.notNull(bondFutureOptionCalculatorFactory, "bondFutureOptionCalculatorFactory");
  }

  @Override
  public Result<MultipleCurrencyAmount> calculatePV(Environment env, BondFutureOptionTrade trade) {
    Result<BondFutureOptionCalculator> calculatorResult = _bondFutureOptionCalculatorFactory.createCalculator(env, trade);
    if (!calculatorResult.isSuccess()) {
      return Result.failure(calculatorResult);
    }
    return calculatorResult.getValue().calculatePV();
  }
  
  @Override
  public Result<Double> calculateSecurityModelPrice(Environment env, BondFutureOptionTrade trade) {
    Result<BondFutureOptionCalculator> calculatorResult = _bondFutureOptionCalculatorFactory.createCalculator(env, trade);
    if (!calculatorResult.isSuccess()) {
      return Result.failure(calculatorResult);
    }
    return calculatorResult.getValue().calculateModelPrice();
  }
  
  @Override
  public Result<Double> calculateDelta(Environment env, BondFutureOptionTrade trade) {
    Result<BondFutureOptionCalculator> calculatorResult = _bondFutureOptionCalculatorFactory.createCalculator(env, trade);
    if (!calculatorResult.isSuccess()) {
      return Result.failure(calculatorResult);
    }
    return calculatorResult.getValue().calculateDelta();
  }
  
  @Override
  public Result<Double> calculateGamma(Environment env, BondFutureOptionTrade trade) {
    Result<BondFutureOptionCalculator> calculatorResult = _bondFutureOptionCalculatorFactory.createCalculator(env, trade);
    if (!calculatorResult.isSuccess()) {
      return Result.failure(calculatorResult);
    }
    return calculatorResult.getValue().calculateGamma();
  }
  
  @Override
  public Result<Double> calculateVega(Environment env, BondFutureOptionTrade trade) {
    Result<BondFutureOptionCalculator> calculatorResult = _bondFutureOptionCalculatorFactory.createCalculator(env, trade);
    if (!calculatorResult.isSuccess()) {
      return Result.failure(calculatorResult);
    }
    return calculatorResult.getValue().calculateVega();
  }
  
  @Override
  public Result<Double> calculateTheta(Environment env, BondFutureOptionTrade trade) {
    Result<BondFutureOptionCalculator> calculatorResult = _bondFutureOptionCalculatorFactory.createCalculator(env, trade);
    if (!calculatorResult.isSuccess()) {
      return Result.failure(calculatorResult);
    }
    return calculatorResult.getValue().calculateTheta();
  }

  @Override
  public Result<Double> calculatePV01(Environment env, BondFutureOptionTrade trade) {
    Result<BondFutureOptionCalculator> calculatorResult = _bondFutureOptionCalculatorFactory.createCalculator(env, trade);
    if (!calculatorResult.isSuccess()) {
      return Result.failure(calculatorResult);
    }
    return calculatorResult.getValue().calculatePV01();
  }

  @Override
  public Result<MultipleCurrencyParameterSensitivity> calculateBucketedPV01(Environment env,
                                                                            BondFutureOptionTrade trade) {
    Result<BondFutureOptionCalculator> calculatorResult = _bondFutureOptionCalculatorFactory.createCalculator(env, trade);
    if (!calculatorResult.isSuccess()) {
      return Result.failure(calculatorResult);
    }
    return calculatorResult.getValue().calculateBucketedPV01();
  }
}
