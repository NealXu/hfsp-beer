package io.github.nealxu.utils

import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager

trait LogSupport {

  protected val log: Logger = LogManager.getLogger(this.getClass)

  def logError(msg: String, t: Throwable = null): Unit = log.error(msg, t)

  def logWarn(msg: String): Unit = log.warn(msg)

  def logInfo(msg: String): Unit = log.info(msg)

  def logDebug(msg: String): Unit = log.debug(msg)

  def log(msg: String): Unit = logDebug(msg)

}
