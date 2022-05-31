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

class UnixAppDirs(private val sysEnv: MutableMap<String?, String?>) : AppDirs() {

    override fun getUserDataDir(
        appName: String?, appVersion: String?,
        appAuthor: String?, roaming: Boolean
    ): String {
        val dir = getOrDefault(
            XDG_DATA_HOME,
            buildPath(home(), "/.local/share")
        )
        return buildPath(dir, appName, appVersion)
    }

    override fun getUserConfigDir(
        appName: String?, appVersion: String?,
        appAuthor: String?, roaming: Boolean
    ): String {
        val dir = getOrDefault(XDG_CONFIG_HOME, buildPath(home(), "/.config"))
        return buildPath(dir, appName, appVersion)
    }

    override fun getUserCacheDir(
        appName: String?, appVersion: String?,
        appAuthor: String?
    ): String {
        val dir = getOrDefault(XDG_CACHE_HOME, buildPath(home(), "/.cache"))
        return buildPath(dir, appName, appVersion)
    }

    override fun getSiteDataDir(
        appName: String?, appVersion: String?,
        appAuthor: String?, multiPath: Boolean
    ): String {
        val xdgDirs = sysEnv[XDG_DATA_DIRS]
        if (xdgDirs == null) {
            val primary = buildPath("/usr/local/share", appName, appVersion)
            val secondary = buildPath("/usr/share", appName, appVersion)
            return if (multiPath) joinPaths(primary, secondary) else primary
        }
        val xdgDirArr = splitPaths(xdgDirs)
        return if (multiPath) {
            buildMultiPaths(appName, appVersion, xdgDirArr)
        } else {
            buildPath(xdgDirArr!![0], appName, appVersion)
        }
    }

    override fun getSiteConfigDir(
        appName: String?, appVersion: String?,
        appAuthor: String?, multiPath: Boolean
    ): String {
        val xdgDirs = sysEnv[XDG_CONFIG_DIRS] ?: return buildPath("/etc/xdg", appName, appVersion)
        val xdgDirArr = splitPaths(xdgDirs)
        return if (multiPath) {
            buildMultiPaths(appName, appVersion, xdgDirArr)
        } else {
            buildPath(xdgDirArr!![0], appName, appVersion)
        }
    }

    private fun buildMultiPaths(
        appName: String?, appVersion: String?,
        xdgDirArr: Array<String?>?
    ): String {
        val dirNum = xdgDirArr!!.size
        val newDirs = arrayOfNulls<String?>(dirNum)
        for (i in 0 until dirNum) {
            newDirs[i] = buildPath(xdgDirArr[i], appName, appVersion)
        }
        return joinPaths(*newDirs)
    }

    override fun getUserLogDir(
        appName: String?, appVersion: String?,
        appAuthor: String?
    ): String {
        val dir = getOrDefault(XDG_CACHE_HOME, buildPath(home(), "/.cache"))
        return buildPath(dir, appName, "/logs", appVersion)
    }

    override fun getSharedDir(
        appName: String?, appVersion: String?,
        appAuthor: String?
    ): String {
        return buildPath("/srv", appName, appVersion)
    }

    private fun getOrDefault(key: String?, def: String?): String? = sysEnv[key] ?: def

    companion object {
        const val XDG_CONFIG_DIRS: String = "XDG_CONFIG_DIRS"
        const val XDG_DATA_DIRS: String = "XDG_DATA_DIRS"
        const val XDG_CACHE_HOME: String = "XDG_CACHE_HOME"
        const val XDG_CONFIG_HOME: String = "XDG_CONFIG_HOME"
        const val XDG_DATA_HOME: String = "XDG_DATA_HOME"
    }
}