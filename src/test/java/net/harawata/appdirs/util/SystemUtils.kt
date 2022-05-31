package net.harawata.appdirs.util

fun setSystemPropertyFromNullable(key: String, value: String?) {
    if(null != value) {
        System.setProperty(key, value)
    } else {
        System.clearProperty(key)
    }
}