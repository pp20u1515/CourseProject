package ru.bmstu.dc.architectureanddi.utils

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class GET(val value: String = "")
