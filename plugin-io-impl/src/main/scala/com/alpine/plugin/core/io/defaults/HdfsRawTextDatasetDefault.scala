/**
 * COPYRIGHT (C) 2015 Alpine Data Labs Inc. All Rights Reserved.
 */

package com.alpine.plugin.core.io.defaults

import com.alpine.plugin.core.io.{HdfsRawTextDataset, OperatorInfo}

/**
 * Default implementation.
 * Developers wanting to change behaviour can extend HdfsRawTextDataset.
 */
abstract class AbstractHdfsRawTextDataset(val path: String,
                                          val sourceOperatorInfo: Option[OperatorInfo],
                                          val addendum: Map[String, AnyRef]
                                           )
  extends HdfsRawTextDataset {
  override def displayName: String = path
}

case class HdfsRawTextDatasetDefault(override val path: String,
                                     override val sourceOperatorInfo: Option[OperatorInfo],
                                     override val addendum: Map[String, AnyRef] = Map[String, AnyRef]()
                                      )
  extends AbstractHdfsRawTextDataset(path, sourceOperatorInfo, addendum)