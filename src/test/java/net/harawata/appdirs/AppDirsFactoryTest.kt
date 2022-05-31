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

import net.harawata.appdirs.impl.MacOSXAppDirs
import net.harawata.appdirs.impl.UnixAppDirs
import net.harawata.appdirs.impl.WindowsAppDirs
import org.junit.After
import org.junit.Assert
import org.junit.Test

class AppDirsFactoryTest {
    @Test
    fun testGetInstance_MacOSX() {
        origOs = System.setProperty("os.name", "Mac OS X")
        val appDirs = AppDirsFactory.getInstance()
        Assert.assertEquals(MacOSXAppDirs::class.java, appDirs.javaClass)
    }

    @Test
    fun testGetInstance_Unix() {
        origOs = System.setProperty("os.name", "OpenBSD")
        val appDirs = AppDirsFactory.getInstance()
        Assert.assertEquals(UnixAppDirs::class.java, appDirs.javaClass)
    }

    @Test
    fun testGetInstance_Windows() {
        origOs = System.setProperty("os.name", "Windows 7")
        val appDirs = AppDirsFactory.getInstance()
        Assert.assertEquals(WindowsAppDirs::class.java, appDirs.javaClass)
    }

    @After
    fun resetProperty() {
        System.setProperty("os.name", origOs)
    }

    companion object {
        private var origOs: String? = null
    }
}