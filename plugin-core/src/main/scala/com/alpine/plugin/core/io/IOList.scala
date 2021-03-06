/**
 * COPYRIGHT (C) 2015 Alpine Data Labs Inc. All Rights Reserved.
 */

package com.alpine.plugin.core.io

import com.alpine.plugin.core.annotation.AlpineSdkApi

/**
 * :: AlpineSdkApi ::
 * A list of IOBase objects. This can be used to output a list of objects and/or
 * to define inputs as list.
 */
@AlpineSdkApi
trait IOList[T <: IOBase] extends IOBase {
  def elements: Seq[T]
}
