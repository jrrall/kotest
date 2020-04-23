package com.sksamuel.kotest.specs.expect

import io.kotest.core.spec.style.ExpectSpec

class ExpectSpecExample : ExpectSpec() {
   init {
      context("some context") {
         expect("some test") {
            // test here
         }
         expect("some test 2").config(enabled = true) {
            // test here
         }
         context("another nested context") {
            expect("some test") {
               // test here
            }
            expect("some test 2").config(enabled = false) {
               // test here
            }
            xexpect("disabled") {
               error("Boom")
            }
         }
      }
      xcontext("should be ignored 1") {
         expect("disabled") {
            error("Boom")
         }
      }
      xcontext("should be ignored 2") {
         error("Boom")
      }
   }
}