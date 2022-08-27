package com.clean.poc_clean_architec.test

class CommonUITestUtils {
    companion object {

        fun pause(pauseTime: Int) {
            try {
                Thread.sleep(pauseTime.toLong())
            } catch (e1: InterruptedException) {
                // eat it.
            }
        }
    }
}