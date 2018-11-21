package com.example.ttmarparis.desafioguiabolso.ui.list

import com.example.ttmarparis.desafioguiabolso.api.ApiServiceInterface
import com.example.ttmarparis.desafioguiabolso.models.Category
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers

class ListPresenter: ListContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api: ApiServiceInterface = ApiServiceInterface.create()
    private lateinit var view: ListContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ListContract.View) {
        this.view = view
    }

    override fun loadCategory() {
        var subscribe = api.getCategory().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ category: Category? ->
                view.showProgress(false)
                view.loadCategorySuccess()
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            })

        subscriptions.add(subscribe)
    }

    override fun loadAllCategories() {

    }

    private fun createDetailsViewModel(posts: List<Post>, categories: List<Category>, albums: List<Album>): DetailsViewModel {
        val postList = posts.take(30)
        val userList = categories.take(30)
        val albumList = albums.take(30)
        return DetailsViewModel(postList, userList, albumList)
    }
}