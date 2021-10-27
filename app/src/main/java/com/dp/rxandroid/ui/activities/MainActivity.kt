package com.dp.rxandroid.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dp.rxandroid.R
import com.dp.rxandroid.databinding.ActivityMainBinding
import com.dp.rxandroid.domain.networkEntities.HttpAuth
import com.dp.rxandroid.domain.networkEntities.HttpAuthRequest
import com.dp.rxandroid.ui.viewmodel.MainActivityViewModel
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable

class MainActivity : AppCompatActivity() {
    private var TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.mainActivityViewModel = viewModel
        binding.lifecycleOwner = this@MainActivity

        binding.apply {
            login.setOnClickListener {
                var dto = HttpAuthRequest("${password.text}", "${username.text}")

                /*REQUEST: ACTIVITY -> VIEW MODEL -> REPOSITORY
                *
                * OR
                *
                * RESPONSE: REPOSITORY -> VIEW MODEL -> ACTIVITY
                *
                * */

                /*TODO FIRST INITIALIZE */
                viewModel.getAuthenticate(dto).observe(this@MainActivity, Observer { it ->

                    var s = it.response?.body?.token
                    Log.i("PUTANGNA MO", "Viewsdada: ${s}")
                    Toast.makeText(
                        this@MainActivity,
                        "PUTANGNA MO GUMANA KNA${s}",
                        Toast.LENGTH_SHORT
                    ).show()
                })

            }

        }

    }

     /*fun authenticate(dto: HttpAuthRequest): @NonNull Observable<LiveData<HttpAuth>>? {
         return Observable.just(viewModel.getAuthenticate(dto))
             .flatMap { response ->
                 Log.i("$TAG","$response")
                 Toast.makeText(
                     this@MainActivity,
                     "PUTANGNA MO GUMANA KNA${response}",
                     Toast.LENGTH_SHORT
                 ).show()
                 return@flatMap Observable.just(response)
             }
     }*/
    /*private fun showFirstTodo() {
        viewModel.authenticate().observe(this, Observer {
            titleTextView.text = it.title
        })
    }*/


//    private fun startRStream() {
//
////Create an Observable//
//
//        val myObservable = getObservable()
//
////Create an Observer//
//
//        val myObserver = getObserver()
//
////Subscribe myObserver to myObservable//
//
//        myObservable
//            .subscribe(myObserver)
//    }
//
//    private fun getObserver(): Observer<Dto> {
//        return object : Observer<Dto> {
//            override fun onSubscribe(d: Disposable) {
//            }
//
////Every time onNext is called, print the value to Android Studio’s Logcat//
//
//            override fun onNext(s: Dto) {
//                Log.d(TAG, "onNext: $s")
//            }
//
////Called if an exception is thrown//
//
//            override fun onError(e: Throwable) {
//                Log.e(TAG, "onError: " + e.message)
//            }
//
////When onComplete is called, print the following to Logcat//
//
//            override fun onComplete() {
//                Log.d(TAG, "onComplete")
//            }
//        }
//    }
//
////Give myObservable some data to emit//
//
//    private fun getObservable(): Observable<Dto> {
//        var service = Impl()
//        return Observable.just(service.test1())
//
//            .flatMap { response ->
//
//                Log.i("$TAG", "${response}")
//                return@flatMap Observable.just(response)
//            }
//    }
}