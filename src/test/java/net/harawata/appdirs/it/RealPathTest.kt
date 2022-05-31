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
package net.harawata.appdirs.it

import net.harawata.appdirs.AppDirs
import net.harawata.appdirs.AppDirsFactory
import org.apache.commons.lang3.SystemUtils
import org.junit.Assert
import org.junit.Assume
import org.junit.BeforeClass
import org.junit.Test

class RealPathTest {

    @Test
    fun testRealPathMacUserDataDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_MAC_OSX)
        Assert.assertEquals(
            "$home/Library/Application Support",
            appDirs.getUserDataDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacUserConfigDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_MAC_OSX)
        Assert.assertEquals(
            "$home/Library/Preferences",
            appDirs.getUserConfigDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacUserCacheDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_MAC_OSX)
        Assert.assertEquals(
            "$home/Library/Caches",
            appDirs.getUserCacheDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacUserLogDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_MAC_OSX)
        Assert.assertEquals(
            "$home/Library/Logs",
            appDirs.getUserLogDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacSiteDataDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_MAC_OSX)
        Assert.assertEquals(
            "/Library/Application Support",
            appDirs.getSiteDataDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacSiteConfigDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_MAC_OSX)
        Assert.assertEquals(
            "/Library/Preferences",
            appDirs.getSiteConfigDir(null, null, null)
        )
    }

    @Test
    fun testRealPathMacSharedDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_MAC_OSX)
        Assert.assertEquals(
            "/Users/Shared/Library/Application Support",
            appDirs.getSharedDir(null, null, null)
        )
    }

    @Test
    fun testRealPathLinuxUserDataDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_LINUX)
        Assert.assertEquals(
            "$home/.local/share",
            appDirs.getUserDataDir(null, null, null)
        )
    }

    @Test
    fun testRealPathLinuxUserConfigDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_LINUX)
        Assert.assertEquals("$home/.config", appDirs.getUserConfigDir(null, null, null))
    }

    @Test
    fun testRealPathLinuxUserCacheDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_LINUX)
        Assert.assertEquals("$home/.cache", appDirs.getUserCacheDir(null, null, null))
    }

    @Test
    fun testRealPathLinuxUserLogDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_LINUX)
        Assert.assertEquals(
            "$home/.cache/logs",
            appDirs.getUserLogDir(null, null, null)
        )
    }

    @Test
    fun testRealPathLinuxSiteDataDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_LINUX)
        Assert.assertEquals("/usr/local/share", appDirs.getSiteDataDir(null, null, null))
    }

    @Test
    fun testRealPathLinuxSiteConfigDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_LINUX)
        Assert.assertEquals("/etc/xdg", appDirs.getSiteConfigDir(null, null, null))
    }

    @Test
    fun testRealPathLinuxSharedDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_LINUX)
        Assert.assertEquals("/srv", appDirs.getSharedDir(null, null, null))
    }

    @Test
    fun testRealPathWinUserDataDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_WINDOWS)
        Assert.assertEquals(
            "$home\\AppData\\Local",
            appDirs.getUserDataDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinUserConfigDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_WINDOWS)
        Assert.assertEquals(
            "$home\\AppData\\Local",
            appDirs.getUserConfigDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinUserCacheDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_WINDOWS)
        Assert.assertEquals(
            "$home\\AppData\\Local\\Cache",
            appDirs.getUserCacheDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinUserLogDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_WINDOWS)
        Assert.assertEquals(
            "$home\\AppData\\Local\\Logs",
            appDirs.getUserLogDir(null, null, null)
        )
    }

    @Test
    fun testRealPathWinSiteDataDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_WINDOWS)
        Assert.assertEquals("C:\\ProgramData", appDirs.getSiteDataDir(null, null, null))
    }

    @Test
    fun testRealPathWinSiteConfigDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_WINDOWS)
        Assert.assertEquals("C:\\ProgramData", appDirs.getSiteConfigDir(null, null, null))
    }

    @Test
    fun testRealPathWinSharedDir() {
        Assume.assumeTrue(SystemUtils.IS_OS_WINDOWS)
        Assert.assertEquals("C:\\ProgramData", appDirs.getSharedDir(null, null, null))
    }


    companion object {
        val appDirs: AppDirs = AppDirsFactory.getInstance()
        val home: String = System.getProperty("user.home")
    }

}