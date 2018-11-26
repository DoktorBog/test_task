package com.test.presentation.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.test.domain.interactor.SmartBoxApiUseCase
import com.test.presentation.base.BaseViewModel
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DataViewModel  @Inject constructor(private val useCase: SmartBoxApiUseCase,
                                         private val mapper: DataMapper) : BaseViewModel() {


    val loadingState: LiveData<Boolean> get() = _loadingState
    val data: LiveData<List<Data>> get() = _data
    val errors: LiveData<Throwable> get() = _errors
    val routingEvents: LiveData<RoutingEvent> get() = _routingEvents

    private val _data = MutableLiveData<List<Data>>()
    private val _loadingState = MutableLiveData<Boolean>()
    private val _errors = MutableLiveData<Throwable>()
    private val _routingEvents = MutableLiveData<RoutingEvent>()


    fun getData() = useDisposable {
        useCase.get()
                .doOnSubscribe { _loadingState.postValue(true) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .map { mapper.mapToPresentation(it) }
                .subscribe({
                    _data.postValue(it)
                    _loadingState.postValue(false)
                }, { _errors.postValue(it)
                    _loadingState.postValue(false)})
    }

    fun onEventClick(data: Data) {
        if(data.type == PageFragment.Type.EVENT){
            _routingEvents.postValue(RoutingEvent.RouteToDetailsScreen(data))
        } else IllegalArgumentException("Type must be event!")
    }

    sealed class RoutingEvent {
        data class RouteToDetailsScreen(val data: Data) : RoutingEvent()
    }

}