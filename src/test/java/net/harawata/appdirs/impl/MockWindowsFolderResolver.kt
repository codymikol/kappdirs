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
package net.harawata.appdirs.impl

import net.harawata.appdirs.AppDirsException
import net.harawata.appdirs.impl.WindowsAppDirs.FolderId

class MockWindowsFolderResolver : WindowsFolderResolver {
    override fun resolveFolder(folderId: FolderId?): String {
        return when (folderId) {
            FolderId.APPDATA -> "C:\\Documents and Settings\\harawata\\Application Data"
            FolderId.LOCAL_APPDATA -> "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data"
            FolderId.COMMON_APPDATA -> "C:\\Documents and Settings\\All Users\\Application Data"
            else -> throw AppDirsException(
                "Unknown folder ID $folderId was specified."
            )
        }
    }
}