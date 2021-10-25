/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package at.bitfire.dav4jvm.property

import at.bitfire.dav4jvm.Property
import at.bitfire.dav4jvm.PropertyFactory
import at.bitfire.dav4jvm.XmlUtils
import org.xmlpull.v1.XmlPullParser

data class QuotaAvailableBytes(
        val quotaAvailableBytes: Long
) : Property {
    companion object {
        @JvmField
        val NAME = Property.Name(XmlUtils.NS_WEBDAV, "quota-available-bytes")
    }

    object Factory: PropertyFactory {
        override fun getName() = NAME

        override fun create(parser: XmlPullParser): QuotaAvailableBytes? {
            XmlUtils.readText(parser)?.let {
                return QuotaAvailableBytes(it.toLong())
            }
            return null
        }
    }
}