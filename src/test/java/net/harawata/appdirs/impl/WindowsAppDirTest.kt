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

import net.harawata.appdirs.util.setSystemPropertyFromNullable
import org.junit.*

class WindowsAppDirTest {

    private lateinit var appDirs: WindowsAppDirs

    @Before
    fun pre() {
        appDirs = WindowsAppDirs(MockWindowsFolderResolver())
    }

    @Test
    fun testGetUserDataDir() {
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data",
            appDirs.getUserDataDir(null, null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Application Data",
            appDirs.getUserDataDir(null, null, null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\myapp",
            appDirs.getUserDataDir("myapp", null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Application Data\\myapp",
            appDirs.getUserDataDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\myapp\\1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Application Data\\myapp\\1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\harawata\\myapp\\1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Application Data\\harawata\\myapp\\1.2.3",
            appDirs.getUserDataDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testGetUserConfigDir() {
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data",
            appDirs.getUserConfigDir(null, null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Application Data",
            appDirs.getUserConfigDir(null, null, null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\myapp",
            appDirs.getUserConfigDir("myapp", null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Application Data\\myapp",
            appDirs.getUserConfigDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\myapp\\1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Application Data\\myapp\\1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\harawata\\myapp\\1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Application Data\\harawata\\myapp\\1.2.3",
            appDirs.getUserConfigDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testGetUserCacheDir() {
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\Cache",
            appDirs.getUserCacheDir(null, null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\myapp\\Cache",
            appDirs.getUserCacheDir("myapp", null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\myapp\\Cache\\1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\harawata\\myapp\\Cache\\1.2.3",
            appDirs.getUserCacheDir("myapp", "1.2.3", "harawata")
        )
    }

    @Test
    fun testGetUserLogDir() {
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\Logs",
            appDirs.getUserLogDir(null, null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\myapp\\Logs",
            appDirs.getUserLogDir("myapp", null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\myapp\\Logs\\1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\harawata\\Local Settings\\Application Data\\harawata\\myapp\\Logs\\1.2.3",
            appDirs.getUserLogDir("myapp", "1.2.3", "harawata")
        )
    }

    @Test
    fun testSiteDataDir() {
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data",
            appDirs.getSiteDataDir(null, null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data",
            appDirs.getSiteDataDir(null, null, null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\myapp",
            appDirs.getSiteDataDir("myapp", null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\myapp",
            appDirs.getSiteDataDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\myapp\\1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\myapp\\1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\harawata\\myapp\\1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\harawata\\myapp\\1.2.3",
            appDirs.getSiteDataDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testSiteConfigDir() {
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data",
            appDirs.getSiteConfigDir(null, null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data",
            appDirs.getSiteConfigDir(null, null, null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\myapp",
            appDirs.getSiteConfigDir("myapp", null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\myapp",
            appDirs.getSiteConfigDir("myapp", null, null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\myapp\\1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\myapp\\1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", null, true)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\harawata\\myapp\\1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "harawata")
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\harawata\\myapp\\1.2.3",
            appDirs.getSiteConfigDir("myapp", "1.2.3", "harawata", true)
        )
    }

    @Test
    fun testgetSharedDir() {
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data",
            appDirs.getSharedDir(null, null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\myapp",
            appDirs.getSharedDir("myapp", null, null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\myapp\\1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", null)
        )
        Assert.assertEquals(
            "C:\\Documents and Settings\\All Users\\Application Data\\harawata\\myapp\\1.2.3",
            appDirs.getSharedDir("myapp", "1.2.3", "harawata")
        )
    }

    companion object {

        private var origFileSeparator: String? = null

        @BeforeClass
        @JvmStatic
        fun setUp() {
            origFileSeparator = System.setProperty("file.separator", "\\")
        }

        @AfterClass
        @JvmStatic
        fun tearDown() {
            setSystemPropertyFromNullable("file.separator", origFileSeparator)
        }
    }
}