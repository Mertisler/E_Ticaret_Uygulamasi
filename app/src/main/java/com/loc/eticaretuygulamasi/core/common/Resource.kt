package com.loc.eticaretuygulamasi.core.common

sealed class Resource <T>{
<<<<<<< HEAD
    data class Success <T>(val data : T):Resource<T>()
=======
    data class Succes <T>(val data : T):Resource<T>()
>>>>>>> ff758f12fdaea21bb4b85e72686018d4cfb43353
    data class Error<T>(val message : String):Resource<T>()
    class Loading<T> : Resource<T>()
}


