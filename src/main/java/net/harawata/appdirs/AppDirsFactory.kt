/*-
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.harawata.appdirs

import net.harawata.appdirs.impl.*
import java.util.*

object AppDirsFactory {
    fun getInstance(): AppDirs {
        val os = System.getProperty("os.name").lowercase(Locale.getDefault())
        return if (os.startsWith("mac os x")) {
            MacOSXAppDirs()
        } else if (os.startsWith("windows")) {
            val folderResolver: WindowsFolderResolver = ShellFolderResolver()
            WindowsAppDirs(folderResolver)
        } else {
            // Assume other *nix.
            UnixAppDirs(System.getenv())
        }
    }
}