/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.sesame;

import java.util.HashMap;
import java.util.Map;

import com.opengamma.analytics.financial.provider.sensitivity.multicurve.MultipleCurrencyParameterSensitivity;
import com.opengamma.analytics.math.matrix.DoubleMatrix1D;
import com.opengamma.financial.analytics.DoubleLabelledMatrix1D;
import com.opengamma.financial.analytics.model.fixedincome.BucketedCurveSensitivities;
import com.opengamma.util.money.Currency;
import com.opengamma.util.tuple.Pair;

/**
 * Provides a mechanism to retrieve zero rate sensitivities given a MultipleCurrencyParameterSensitivity object.
 */
public final class ZeroIRDeltaBucketingUtils {

  private ZeroIRDeltaBucketingUtils() {
  }
  
  public static BucketedCurveSensitivities getBucketedCurveSensitivities(
      MultipleCurrencyParameterSensitivity parameterSensitivities,
      Map<String, CurveMatrixLabeller> curveLabellers) {

    Map<Pair<String, Currency>, DoubleLabelledMatrix1D> labelledMatrix1DMap = new HashMap<>();

    for (Map.Entry<Pair<String, Currency>, DoubleMatrix1D> entry :
        parameterSensitivities.getSensitivities().entrySet()) {

      CurveMatrixLabeller curveLabeller = curveLabellers.get(entry.getKey().getFirst());
      DoubleLabelledMatrix1D matrix = curveLabeller.labelMatrix(entry.getValue());
      labelledMatrix1DMap.put(entry.getKey(), matrix);
    }
    return BucketedCurveSensitivities.of(labelledMatrix1DMap);
  }
}
