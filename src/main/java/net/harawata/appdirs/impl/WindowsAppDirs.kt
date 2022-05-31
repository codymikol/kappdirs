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

import net.harawata.appdirs.AppDirs

class WindowsAppDirs(private val folderResolver: WindowsFolderResolver) : AppDirs() {
    enum class FolderId {
        APPDATA, LOCAL_APPDATA, COMMON_APPDATA
    }

    override fun getUserDataDir(
        appName: String?, appVersion: String?,
        appAuthor: String?, roaming: Boolean
    ): String {
        val dir = if (roaming) getAppData() else getLocalAppData()
        return buildPath(dir, appAuthor, appName, appVersion)
    }

    override fun getUserConfigDir(
        appName: String?, appVersion: String?,
        appAuthor: String?, roaming: Boolean
    ): String {
        return getUserDataDir(appName, appVersion, appAuthor, roaming)
    }

    override fun getUserCacheDir(
        appName: String?, appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(
            getLocalAppData(), appAuthor, appName, "\\Cache",
            appVersion
        )
    }

    override fun getSiteDataDir(
        appName: String?, appVersion: String?,
        appAuthor: String?, multiPath: Boolean
    ): String {
        return buildPath(getCommonAppData(), appAuthor, appName, appVersion)
    }

    override fun getSiteConfigDir(
        appName: String?, appVersion: String?,
        appAuthor: String?, multiPath: Boolean
    ): String {
        return getSiteDataDir(appName, appVersion, appAuthor, multiPath)
    }

    override fun getUserLogDir(
        appName: String?, appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(
            getLocalAppData(), appAuthor, appName, "\\Logs",
            appVersion
        )
    }

    override fun getSharedDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(getCommonAppData(), appAuthor, appName, appVersion)
    }

    private fun getAppData(): String? {
        return folderResolver.resolveFolder(FolderId.APPDATA)
    }

    private fun getLocalAppData(): String? {
        return folderResolver.resolveFolder(FolderId.LOCAL_APPDATA)
    }

    private fun getCommonAppData(): String? {
        return folderResolver.resolveFolder(FolderId.COMMON_APPDATA)
    }
}