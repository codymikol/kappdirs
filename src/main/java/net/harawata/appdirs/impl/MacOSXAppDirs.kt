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

class MacOSXAppDirs : AppDirs() {
    override fun getUserDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String {
        return buildPath(
            home(), "/Library/Application Support", appName,
            appVersion
        )
    }

    override fun getUserConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String {
        return buildPath(home(), "/Library/Preferences", appName, appVersion)
    }

    override fun getUserCacheDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(home(), "/Library/Caches", appName, appVersion)
    }

    override fun getSiteDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String {
        return buildPath("/Library/Application Support", appName, appVersion)
    }

    override fun getSiteConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String {
        return buildPath("/Library/Preferences", appName, appVersion)
    }

    override fun getUserLogDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(home(), "/Library/Logs", appName, appVersion)
    }

    override fun getSharedDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath(
            "/Users/Shared/Library/Application Support", appName,
            appVersion
        )
    }
}