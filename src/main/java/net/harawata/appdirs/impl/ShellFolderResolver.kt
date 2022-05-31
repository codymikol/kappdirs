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

import com.sun.jna.platform.win32.*
import net.harawata.appdirs.AppDirsException
import net.harawata.appdirs.impl.WindowsAppDirs.FolderId

class ShellFolderResolver : WindowsFolderResolver {
    override fun resolveFolder(folderId: FolderId?): String? {
        return try {
            Shell32Util.getKnownFolderPath(convertFolderIdToGuid(folderId))
        } catch (e: Win32Exception) {
            throw AppDirsException(
                "SHGetKnownFolderPath returns an error: " + e.errorCode
            )
        } catch (e: UnsatisfiedLinkError) {
            // Fallback for pre-vista OSes. #5
            try {
                val folder = convertFolderIdToCsidl(folderId)
                Shell32Util.getFolderPath(folder)
            } catch (e2: Win32Exception) {
                throw AppDirsException(
                    "SHGetFolderPath returns an error: " + e2.errorCode
                )
            }
        }
    }

    private fun convertFolderIdToGuid(folderId: FolderId?): Guid.GUID? {
        return when (folderId) {
            FolderId.APPDATA -> KnownFolders.FOLDERID_RoamingAppData
            FolderId.LOCAL_APPDATA -> KnownFolders.FOLDERID_LocalAppData
            FolderId.COMMON_APPDATA -> KnownFolders.FOLDERID_ProgramData
            else -> throw AppDirsException(
                "Unknown folder ID $folderId was specified."
            )
        }
    }

    protected fun convertFolderIdToCsidl(folderId: FolderId?): Int {
        return when (folderId) {
            FolderId.APPDATA -> ShlObj.CSIDL_APPDATA
            FolderId.LOCAL_APPDATA -> ShlObj.CSIDL_LOCAL_APPDATA
            FolderId.COMMON_APPDATA -> ShlObj.CSIDL_COMMON_APPDATA
            else -> throw AppDirsException(
                "Unknown folder ID $folderId was specified."
            )
        }
    }
}