package com.itcode.implic

import java.io.File

/**
  * Created by along on 17/8/11 15:03.
  * Email:466210864@qq.com
  */
object MyPredef {
  implicit def fileToRichFile(f: File) = new RichFile(f)
}
