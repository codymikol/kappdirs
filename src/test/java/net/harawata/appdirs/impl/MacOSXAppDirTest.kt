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

class MacOSXAppDirTest {

    private lateinit var appDirs: AppDirs

    @Before
    fun pre() {
        appDirs = MacOSXAppDirs()
    }

    @Test
    fun testGetUserDataDir() {
        Assert.assertEquals(
            "/Users/somebody/Library/Application Support",
            appDirs.getUserDataDir(null, null, null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Application Support",
            appDirs.getUserDataDir(null, null, null, true)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Application Support/myapp",
            appDirs.getUserDataDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Application Support/myapp",
            appDirs.getUserDataDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Application Support/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Application Support/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Application Support/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Application Support/myapp/1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testGetUserConfigDir() {
        Assert.assertEquals(
            "/Users/somebody/Library/Preferences",
            appDirs.getUserConfigDir(null, null, null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Preferences",
            appDirs.getUserConfigDir(null, null, null, true)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Preferences/myapp",
            appDirs.getUserConfigDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Preferences/myapp",
            appDirs.getUserConfigDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Preferences/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Preferences/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Preferences/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Preferences/myapp/1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testGetUserCacheDir() {
        Assert.assertEquals(
            "/Users/somebody/Library/Caches",
            appDirs.getUserCacheDir(null, null, null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Caches/myapp",
            appDirs.getUserCacheDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Caches/myapp/1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Caches/myapp/1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", "harawata")
        )
    }

    @Test
    fun testGetUserLogDir() {
        Assert.assertEquals(
            "/Users/somebody/Library/Logs",
            appDirs.getUserLogDir(null, null, null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Logs/myapp",
            appDirs.getUserLogDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Logs/myapp/1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/Users/somebody/Library/Logs/myapp/1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", "harawata")
        )
    }

    @Test
    fun testSiteDataDir() {
        Assert.assertEquals(
            "/Library/Application Support",
            appDirs.getSiteDataDir(null, null, null)
        )
        Assert.assertEquals(
            "/Library/Application Support",
            appDirs.getSiteDataDir(null, null, null, true)
        )
        Assert.assertEquals(
            "/Library/Application Support/myapp",
            appDirs.getSiteDataDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/Library/Application Support/myapp",
            appDirs.getSiteDataDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "/Library/Application Support/myapp/1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testSiteConfigDir() {
        Assert.assertEquals(
            "/Library/Preferences",
            appDirs.getSiteConfigDir(null, null, null)
        )
        Assert.assertEquals(
            "/Library/Preferences",
            appDirs.getSiteConfigDir(null, null, null, true)
        )
        Assert.assertEquals(
            "/Library/Preferences/myapp",
            appDirs.getSiteConfigDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/Library/Preferences/myapp",
            appDirs.getSiteConfigDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "/Library/Preferences/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/Library/Preferences/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "/Library/Preferences/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "/Library/Preferences/myapp/1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testgetSharedDir() {
        Assert.assertEquals(
            "/Users/Shared/Library/Application Support",
            appDirs.getSharedDir(null, null, null)
        )
        Assert.assertEquals(
            "/Users/Shared/Library/Application Support/myapp",
            appDirs.getSharedDir("myapp", null, null)
        )
        Assert.assertEquals(
            "/Users/Shared/Library/Application Support/myapp/1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "/Users/Shared/Library/Application Support/myapp/1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", "harawata")
        )
    }

    companion object {
        private var origHome: String? = null
        private var origFileSeparator: String? = null
        @BeforeClass
        @JvmStatic
        fun setUp() {
            origHome = System.setProperty("user.home", "/Users/somebody")
            origFileSeparator = System.setProperty("file.separator", "/")
        }

        @AfterClass
        @JvmStatic
        fun tearDown() {
            setSystemPropertyFromNullable("user.home", origHome)
            setSystemPropertyFromNullable("file.separator", origFileSeparator)
        }
    }
}