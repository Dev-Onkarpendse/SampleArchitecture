package com.example.samplearchitecture.utility

open class Error()

data class Runtime(val s:String) :Error()
class Complietime() :Error()


fun main(){
    val error:Error = Runtime("Sample")

}