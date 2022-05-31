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
import net.harawata.appdirs.util.setSystemPropertyFromNullable
import org.junit.*

class UnixAppDirTest {
    @Test
    fun testGetUserDataDir() {
        val appDirs = getAppDirs()
        Assert.assertEquals(
            "/home/somebody/.local/share",
            appDirs.getUserDataDir(null, null, null)
        )
        Assert.assertEquals(
            "/home/somebody/.local/share",
            appDirs.getUserDataDir(null, null, null, true)
        )
        Assert.assertEquals(
            "/home/somebody/.local/share/myapp",
            appDirs.getUserDataDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/home/somebody/.local/share/myapp",
            appDirs.getUserDataDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "/home/somebody/.local/share/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/home/somebody/.local/share/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "/home/somebody/.local/share/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "/home/somebody/.local/share/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testGetUserConfigDir() {
        val appDirs = getAppDirs()
        Assert.assertEquals(
            "/home/somebody/.config",
            appDirs.getUserConfigDir(null, null, null)
        )
        Assert.assertEquals(
            "/home/somebody/.config",
            appDirs.getUserConfigDir(null, null, null, true)
        )
        Assert.assertEquals(
            "/home/somebody/.config/myapp",
            appDirs.getUserConfigDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/home/somebody/.config/myapp",
            appDirs.getUserConfigDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "/home/somebody/.config/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/home/somebody/.config/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "/home/somebody/.config/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "/home/somebody/.config/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testGetUserCacheDir() {
        val appDirs = getAppDirs()
        Assert.assertEquals(
            "/home/somebody/.cache",
            appDirs.getUserCacheDir(null, null, null)
        )
        Assert.assertEquals(
            "/home/somebody/.cache/myapp",
            appDirs.getUserCacheDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/home/somebody/.cache/myapp/1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/home/somebody/.cache/myapp/1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", "harawata")
        )
    }

    @Test
    fun testGetUserLogDir() {
        val appDirs = getAppDirs()
        Assert.assertEquals(
            "/home/somebody/.cache/logs",
            appDirs.getUserLogDir(null, null, null)
        )
        Assert.assertEquals(
            "/home/somebody/.cache/myapp/logs",
            appDirs.getUserLogDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/home/somebody/.cache/myapp/logs/1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/home/somebody/.cache/myapp/logs/1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", "harawata")
        )
    }

    @Test
    fun testSiteDataDir() {
        val appDirs = getAppDirs()
        Assert.assertEquals("/usr/local/share", appDirs.getSiteDataDir(null, null, null))
        Assert.assertEquals(
            "/usr/local/share:/usr/share",
            appDirs.getSiteDataDir(null, null, null, true)
        )
        Assert.assertEquals(
            "/usr/local/share/myapp",
            appDirs.getSiteDataDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/usr/local/share/myapp:/usr/share/myapp",
            appDirs.getSiteDataDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "/usr/local/share/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/usr/local/share/myapp/1.2.3:/usr/share/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "/usr/local/share/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "/usr/local/share/myapp/1.2.3:/usr/share/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testSiteConfigDir() {
        val appDirs = getAppDirs()
        Assert.assertEquals("/etc/xdg", appDirs.getSiteConfigDir(null, null, null))
        Assert.assertEquals("/etc/xdg", appDirs.getSiteConfigDir(null, null, null, true))
        Assert.assertEquals(
            "/etc/xdg/myapp",
            appDirs.getSiteConfigDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/etc/xdg/myapp",
            appDirs.getSiteConfigDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "/etc/xdg/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/etc/xdg/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "/etc/xdg/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "/etc/xdg/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testEnvironmentVariables() {
        val vars: MutableMap<String?, String?> = HashMap()
        vars[UnixAppDirs.Companion.XDG_DATA_HOME] = "/data_home"
        vars[UnixAppDirs.Companion.XDG_CONFIG_HOME] = "/config_home"
        vars[UnixAppDirs.Companion.XDG_CACHE_HOME] = "/cache_home"
        vars[UnixAppDirs.Companion.XDG_DATA_DIRS] = "/data_dir:/opt/data_dir"
        vars[UnixAppDirs.Companion.XDG_CONFIG_DIRS] = "/config_dir:/opt/config_dir"
        val appDirs = getAppDirs(vars)
        Assert.assertEquals(
            "/data_home/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "harawata", true)
        )
        Assert.assertEquals(
            "/config_home/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "harawata", true)
        )
        Assert.assertEquals(
            "/cache_home/myapp/1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "/cache_home/myapp/logs/1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "/data_dir/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/data_dir/myapp/1.2.3:/opt/data_dir/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "/config_dir/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/config_dir/myapp/1.2.3:/opt/config_dir/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testgetSharedDir() {
        val appDirs = getAppDirs()
        Assert.assertEquals("/srv", appDirs.getSharedDir(null, null, null))
        Assert.assertEquals("/srv/myapp", appDirs.getSharedDir("myapp", null, null))
        Assert.assertEquals(
            "/srv/myapp/1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/srv/myapp/1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", "harawata")
        )
    }

    private fun getAppDirs(): AppDirs {
        return getAppDirs(HashMap())
    }

    private fun getAppDirs(envVars: MutableMap<String?, String?>): AppDirs {
        return UnixAppDirs(envVars)
    }

    companion object {
        private var origHome: String? = null
        private var origFileSeparator: String? = null
        private var origPathSeparator: String? = null

        @BeforeClass
        @JvmStatic
        fun setUp() {
            origHome = System.setProperty("user.home", "/home/somebody")
            origFileSeparator = System.setProperty("file.separator", "/")
            origPathSeparator = System.setProperty("path.separator", ":")
        }

        @AfterClass
        @JvmStatic
        fun tearDown() {
            setSystemPropertyFromNullable("user.home", origHome)
            setSystemPropertyFromNullable("file.separator", origFileSeparator)
            setSystemPropertyFromNullable("path.separator", origPathSeparator)
        }
    }
}