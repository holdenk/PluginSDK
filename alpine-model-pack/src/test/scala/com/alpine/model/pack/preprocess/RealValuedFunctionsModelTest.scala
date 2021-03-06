/*
 * Copyright (c) 2015 Alpine Data Labs
 * All rights reserved.
 */
package com.alpine.model.pack.preprocess

import com.alpine.features.{DoubleType, FeatureDesc}
import com.alpine.json.{JsonTestUtil, TypeWrapper}
import org.scalatest.FunSuite
/**
 * Tests serialization of RealValuedFunctionsModel
 * and application of RealValuedFunctionTransformer.
 */
class RealValuedFunctionsModelTest extends FunSuite {

  val inputFeatures = Seq(FeatureDesc("x1", DoubleType()), FeatureDesc("x2", DoubleType()))
  val functions = Seq((Exp(), 0), (Exp(), 1), (Log(), 1), (Power(2), 0))
  val model = RealValuedFunctionsModel(functions.map(t => RealFunctionWithIndex(TypeWrapper(t._1), t._2)), inputFeatures)

  test("Should serialize properly") {
    JsonTestUtil.testJsonization(model)
  }

  test("Should score properly") {
    val scorer = model.transformer
    assert(Seq(math.exp(2), math.E, 0, 4) === scorer(Seq(2,1.0)))
  }

}
