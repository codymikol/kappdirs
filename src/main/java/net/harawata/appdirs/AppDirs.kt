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

abstract class AppDirs {
    fun getUserDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String? {
        return getUserDataDir(appName, appVersion, appAuthor, false)
    }

    abstract fun getUserDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String?

    fun getUserConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String? {
        return getUserConfigDir(appName, appVersion, appAuthor, false)
    }

    abstract fun getUserConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        roaming: Boolean
    ): String?

    abstract fun getUserCacheDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String?

    fun getSiteDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String? {
        return getSiteDataDir(appName, appVersion, appAuthor, false)
    }

    abstract fun getSiteDataDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String?

    fun getSiteConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String? {
        return getSiteConfigDir(appName, appVersion, appAuthor, false)
    }

    abstract fun getSiteConfigDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?,
        multiPath: Boolean
    ): String?

    abstract fun getUserLogDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String?

    abstract fun getSharedDir(
        appName: String?,
        appVersion: String?,
        appAuthor: String?
    ): String?

    protected fun home(): String? {
        return System.getProperty("user.home")
    }

    protected fun buildPath(vararg elems: String?): String {
        val separator = System.getProperty("file.separator")
        val buffer = StringBuilder()
        var lastElem: String? = null
        for (elem in elems) {
            if (elem == null) {
                continue
            }
            if (lastElem == null) {
                buffer.append(elem)
            } else if (lastElem.endsWith(separator)) {
                buffer.append(if (elem.startsWith(separator)) elem.substring(1) else elem)
            } else {
                if (!elem.startsWith(separator)) {
                    buffer.append(separator)
                }
                buffer.append(elem)
            }
            lastElem = elem
        }
        return buffer.toString()
    }

    protected fun joinPaths(vararg paths: String?): String {
        val separator = System.getProperty("path.separator")
        val buffer = StringBuilder()
        for (path in paths) {
            if (path == null) {
                continue
            }
            if (buffer.isNotEmpty()) {
                buffer.append(separator)
            }
            buffer.append(path)
        }
        return buffer.toString()
    }

    protected fun splitPaths(paths: String?): Array<String?>? {
        val separator = System.getProperty("path.separator")
        return paths?.split(separator.toRegex())?.dropLastWhile { it.isEmpty() }?.toTypedArray()
    }
}