package dokutoku.golden_thumb.util

import java.util.logging.{Logger => JLogger, Level}
import dokutoku.golden_thumb.lib.Reference

object Logger {
  
  val logger = JLogger.getLogger(Reference.ModID)
  
  val severe = logger.log(Level.SEVERE, _ : String)
  val warning = logger.log(Level.WARNING, _ : String)
  val info = logger.log(Level.INFO, _ : String)
  val config = logger.log(Level.CONFIG, _ : String)
  val fine = logger.log(Level.FINE, _ : String)
  val finer = logger.log(Level.FINER, _ : String)
  val finest = logger.log(Level.FINEST, _ : String)
  
  def debug(msg: String) = warning("[DEBUG] " + msg : String)
  
  
}