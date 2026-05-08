package com.loc.eticaretuygulamasi.core.common

sealed class Resource <T>{
    data class Succes <T>(val data : T):Resource<T>()
    data class Error<T>(val message : String):Resource<T>()
    class Loading<T> : Resource<T>()
}


